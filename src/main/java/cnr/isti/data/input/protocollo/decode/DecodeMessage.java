package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson2.JSON;

import cnr.isti.data.input.protocollo.Message;
import cnr.isti.data.input.protocollo.MessageDiretto;

public class DecodeMessage {

	private static Logger log = LogManager.getLogger(DecodeMessage.class);

	List<Message> listamessaggi = new ArrayList<>();
	List<MessageDiretto> lmd = new ArrayList<>();

	public DecodeMessage(byte[] msg, Date date, byte tag) {
		byte[] range = Arrays.copyOfRange(msg, 2, msg.length);

		if (msg[0] == 0x0) {

			int cicli = range.length / 11;
			int d = 0;

			for (int i = 1; i <= cicli; i++) {
				byte[] win = Arrays.copyOfRange(range, 11 * d, 11 * i);
				Message e = new Message(win);
				listamessaggi.add(e);
				d++;
			}
		}

		if (msg[0] == 0x74 & tag == 0x41) {
			int index = 0;
			while (index < range.length) {
				byte[] r = Arrays.copyOfRange(range, index, range.length);
				if (r.length > 10) {
					MessageDiretto md = new MessageDiretto(r, date);
					String jsonOutput = JSON.toJSONString(md);
					log.info(jsonOutput);
					lmd.add(md);
					index += md.getLastindex() + 1;

				} else
					break;
			}

		}

	}

	public List<Message> getListamessaggi() {
		return listamessaggi;
	}

	public void setListamessaggi(List<Message> listamessaggi) {
		this.listamessaggi = listamessaggi;
	}

	public List<MessageDiretto> getLmd() {
		return lmd;
	}

	public void setLmd(List<MessageDiretto> lmd) {
		this.lmd = lmd;
	}

	@Override
	public String toString() {
		return (listamessaggi != null ? "listamessaggi: " + listamessaggi + ",  " : "")
				+ (lmd != null ? "lmd: " + lmd : "");
	}

}
