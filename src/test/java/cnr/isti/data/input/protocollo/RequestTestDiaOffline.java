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

import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.mqtt.publisher.Publisher;

public class RequestTestDiaOffline {

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
		byte[] finalmessage = s.getPresenzaDati(b2, b);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		//finalmessage = s.get_T_REQ_Alarm(b, b);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		
		byte[] decodee = Hex.decodeHex("1408f708f732940a0f2a05400000410100080f17");
            Reader read = new Reader();
            read.Read(decodee);
            
        /*    DecodeMessage dm = read.getDm();
    		
    		List<Message> lmess = dm.getListamessaggi();
    		
    		for (Message messageDiretto : lmess) {
    			String jsonOutput= JSON.toJSONString(messageDiretto);
    			Publisher pub  = new Publisher();
    			
    			pub.send(jsonOutput.getBytes(), messageDiretto.getInd(), "Presenza");
    			
    		}*/
    		
            
            System.out.println("End");
            
    }
		
	

}
