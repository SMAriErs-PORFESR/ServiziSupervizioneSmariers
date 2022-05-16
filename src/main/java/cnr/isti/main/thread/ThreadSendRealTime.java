package cnr.isti.main.thread;

import java.util.List;

import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson2.JSON;

import cnr.isti.data.input.protocollo.MessageDiretto;
import cnr.isti.data.input.protocollo.Reader;
import cnr.isti.data.input.protocollo.Request;
import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.sender.SenderTCP;
import cnr.isti.mqtt.publisher.Publisher;
import cnr.isti.mqtt.topic.Topic;

public class ThreadSendRealTime implements Runnable {

	private static Logger log = LogManager.getLogger(ThreadSendRealTime.class);

	private byte Address = 0;
	private byte AddressPeriferica = 0;

	private boolean ciclo = true;

	private int ritardo = 10000;

	public ThreadSendRealTime(byte indcd, byte indper) {
		super();
		this.Address = indcd;
		this.AddressPeriferica = indper;
	}

	public ThreadSendRealTime(byte address, byte addressPeriferica, int ritardo) {
		super();
		Address = address;
		AddressPeriferica = addressPeriferica;
		this.ritardo = ritardo;
	}

	@Override
	public void run() {
		try {
			do {
				Request s = new Request();
				byte[] finalmessage = s.get_T_REQ_BOARD_STD(Address, AddressPeriferica);
				log.info(Hex.encodeHexString(finalmessage));
				SenderTCP sender = new SenderTCP();
				byte[] baos = sender.Send(finalmessage);

				log.info(Hex.encodeHexString(baos));
				Reader read = new Reader();
				read.Read(baos);
				DecodeMessage dm = read.getDm();
				List<MessageDiretto> lmdiretto = dm.getLmd();
				
				for (MessageDiretto messageDiretto : lmdiretto) {
					String jsonOutput= JSON.toJSONString(messageDiretto);
					Publisher pub  = new Publisher();
					
					pub.send(jsonOutput.getBytes(), "/"+messageDiretto.getAddress(), Topic.REAL_TIME);
					
				}

				/* byte[] lmdiretto = read.getDm().getMap();

				Publisher pub = new Publisher();
				if (lmdiretto.length>10)
					pub.send(lmdiretto, "", Topic.REAL_TIME);
				 */
				log.info("CicloRealTimeEnd");
				Thread.sleep(ritardo);

			} while (ciclo);

		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}

	}

	public void setFinite() {

		ciclo = false;
	}

}
