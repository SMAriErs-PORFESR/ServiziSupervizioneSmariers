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
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.data.input.sender.SenderTCP;
import cnr.isti.mqtt.publisher.Publisher;
import cnr.isti.mqtt.topic.Topic;

public class RequestTestTCPAllmessage {

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
		
		
		
		Request s =  new Request();
		byte b =  0x08;
		byte b2 =  0x08;
		byte[] finalmessage = s.get_T_REQ_STATUS_ANALOG(b2, b);

		send(finalmessage, Topic.REG_VALORE);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		/*
		byte[] finalmessage = s.getPresenzaDati(b2, b);
		send(finalmessage, Topic.PRESENZA_DATI);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		finalmessage = s.get_T_REQ_GROUP_STD(b, b);
		send(finalmessage, Topic.GROUP);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		finalmessage = s.get_T_REQ_DATALOG1(b, b);
		send(finalmessage, Topic.LOG);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		
		finalmessage = s.get_T_REQ_Warning(b, b);
		send(finalmessage, Topic.PRESENZA_WARNING);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		finalmessage = s.get_T_REQ_Data(b, b);
		send(finalmessage, Topic.PRESENZA_EVENTI);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		
		finalmessage = s.get_T_REQ_Alarm(b, b);
		send(finalmessage, Topic.PRESENZA_ALLARMI);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		*/
		
		
    			
    		//}
    }
		
	
	private void send(byte[] c, Topic d) throws IOException {
		SenderTCP sender = new SenderTCP();
		byte[] baos = sender.Send(c);
          //  System.out.println( Hex.encodeHexString(baos.toByteArray())); 
            System.out.println(Hex.encodeHexString(baos));
            Reader read = new Reader();
            read.Read(baos);
            
            DecodeMessage dm = read.getDm();
    		Object g =  dm.getObject(d);
            //List<Message> lmess = dm.getListamessaggi();
    		
    	//	for (Message messageDiretto : lmess) {
    		String jsonOutput= JSON.toJSONString(g);
    			
    			System.out.println( jsonOutput);
    			Publisher pub  = new Publisher();
    			
    			pub.send(jsonOutput.getBytes(), "", d );/*	*/
	}
	

}
