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

public class RequestTest2 {

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
		
		/*Socket socket = new Socket("spagnolo2.isti.cnr.it", 9999);
		OutputStream output = socket.getOutputStream();
		output.write(finalmessage);
		socket.close();*/
		String hostname = "spagnolo2.isti.cnr.it";
		int port = 9999;
		
		try (Socket socket = new Socket(hostname, port)) {
			 
           // OutputStream output = socket.getOutputStream();
           
	        DataOutputStream os=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            
           
            os.write(finalmessage);
            os.flush();
            
           // ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
           // byte[] temp = (byte[]) is.readObject();
 
            
            InputStream inputStream = socket.getInputStream();  

         // read from the stream  
         ByteArrayOutputStream baos = new ByteArrayOutputStream();  
         byte[] content = new byte[ 1 ];  
         int bytesRead = -1;  
         boolean bandiera = true;
         int readb = 0;
         while( (( bytesRead = inputStream.read( content ) ) != -1 )) {  
             baos.write( content, 0, bytesRead );  
             readb++;
             if(content[0]==0x17) {
            	if(readb>10)
            	 break;
             }
         } // while  
         
          /*  DataInputStream input = new  DataInputStream (new BufferedInputStream( socket.getInputStream()));
            
            
            
            //int date = input.readInt();
           // System.out.println("date:" + date);
            int bufSize = input.available();
            System.out.println("bufSize:" + bufSize);
            byte[] frame = new byte[bufSize];
            input.readFully(frame);*/
           // BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            socket.close();
            System.out.println("Client Closed"); 
          //  System.out.println( Hex.encodeHexString(baos.toByteArray())); 
            System.out.println(Hex.encodeHexString(baos.toByteArray()));
            Reader read = new Reader();
            read.Read(baos.toByteArray());
            
            System.out.println(read);

            EsitiScarico es =EsitiScarico.getEsitiScarico(4264193)  ;
           
           boolean d = es.isAllarmi();
           System.out.println("End");
          /*   */
 
           /* while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }*/
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
		
	

}
