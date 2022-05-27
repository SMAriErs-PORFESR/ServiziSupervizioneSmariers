package cnr.isti.data.input.protocollo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.alibaba.fastjson2.JSON;

import cnr.isti.config.Config;
import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.data.input.sender.SenderTCP;
import cnr.isti.main.thread.ThreadSendRealTime;
import cnr.isti.mqtt.publisher.Publisher;
import cnr.isti.mqtt.topic.Topic;

public class RequestTestRegolaritaAnalog {

	@Test
	public void test() throws DecoderException, UnknownHostException, IOException {
		
		
		try {
			
			
			Request s =  new Request();
			byte b =  0x08;
			byte b2 =  0x08;
			byte[] finalmessage = s.get_T_REQ_STATUS_ANALOG(b2, b);

			send(finalmessage, Topic.REG_VALORE);
			System.out.println( Hex.encodeHexString( finalmessage ) );
			System.out.println(new String(finalmessage));
	        
			
		}catch (Exception e) {
			
		}
		
	}
    
	private void send(byte[] c, Topic d) throws IOException {
		SenderTCP sender = new SenderTCP();
		byte[] baos = sender.Send(c);
          //  System.out.println( Hex.encodeHexString(baos.toByteArray())); 
            System.out.println(Hex.encodeHexString(baos));
            Reader read = new Reader();
            read.Read(baos);
            
            DecodeMessage dm = read.getDm();
            List<MessageRegAnalogica> lmdiretto = dm.getListmes();
    			
    			
				for (MessageRegAnalogica message : lmdiretto) {
					String jsonOutput= JSON.toJSONString(message);
					Publisher pub  = new Publisher();
					
					pub.send(jsonOutput.getBytes(), "/"+message.getAddress(), Topic.REG_VALORE);
					
				}
	}
	

}
