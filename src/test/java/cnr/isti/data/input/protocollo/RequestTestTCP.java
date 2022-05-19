package cnr.isti.data.input.protocollo;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.data.input.sender.SenderTCP;

public class RequestTestTCP {

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
		byte Address =  0x08;
		byte AddressPeriferica =  0x08;
		byte[] finalmessage = s.get_T_REQ_BOARD_STD(Address, AddressPeriferica);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		//finalmessage = s.get_T_REQ_Alarm(b, b);
		System.out.println( Hex.encodeHexString( finalmessage ) );
		System.out.println(new String(finalmessage));
		
		SenderTCP sender = new SenderTCP();
		byte[] baos = sender.Send(finalmessage);
          //  System.out.println( Hex.encodeHexString(baos.toByteArray())); 
            System.out.println(Hex.encodeHexString(baos));
            Reader read = new Reader();
            read.Read(baos);
            
            System.out.println(read);

          
           
           
           System.out.println("End");
          /*   */
 
           /* while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }*/
        
    }
		
	

}
