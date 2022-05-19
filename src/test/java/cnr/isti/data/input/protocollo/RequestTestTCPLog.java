package cnr.isti.data.input.protocollo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.alibaba.fastjson2.JSON;

import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.protocollo.decode.EsitiScarico;
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.data.input.sender.SenderTCP;
import cnr.isti.mqtt.publisher.Publisher;
import cnr.isti.mqtt.topic.Topic;

public class RequestTestTCPLog {

	@Test
	public void test() throws DecoderException, UnknownHostException, IOException {
		
		
		byte[] g = Hex.decodeHex("00FF01FE3000000000201000");
		g = Hex.decodeHex("11EE11EE312E690B2A02400000");
		// 50 5E
		System.out.println("00FF01FE3000000000201000");
		int Calc_CRC = Service.CRC(g);
		byte[] recCRC = Service.intToBytes(Calc_CRC);
		System.out.println( Hex.encodeHexString( recCRC ) );
		//byte[] recCRC2 = Service.integerToTwoBytes(Calc_CRC);
		
		List<byte[]> l = new ArrayList<byte[]>();
		
		Request s =  new Request();
		byte b =  0x08;
		byte b2 =  0x08;
	
	/*	byte[] finalmessage = s.get_T_REQ_GROUP_STD(b, b2);
		l.add(finalmessage);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		*/
		byte[]  finalmessage = s.get_T_REQ_DATALOG1(b, b2);
		l.add(finalmessage);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
	
			
		for (byte [] c : l) {
			
			SenderTCP sender = new SenderTCP();
			byte[] baos = sender.Send(c);
	          //  System.out.println( Hex.encodeHexString(baos.toByteArray())); 
	            System.out.println(Hex.encodeHexString(baos));
	            Reader read = new Reader();
	            read.Read(baos);
	            
	            DecodeMessage dm = read.getDm();
	    		
	            //List<Message> lmess = dm.getListamessaggi();
	    		
	    	//	for (Message messageDiretto : lmess) {
	    			String jsonOutput= JSON.toJSONString(dm);
	    			
	    			System.out.println( jsonOutput);
	    		//	Publisher pub  = new Publisher();
	    			
	    		//	pub.send(jsonOutput.getBytes(), "", Topic.PRESENZA_ALLARMI );
			
		}
		
		
    			
    		//}
    }
		
	

}
