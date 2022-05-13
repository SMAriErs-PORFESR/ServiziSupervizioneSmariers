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
import java.util.List;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import com.alibaba.fastjson2.JSON;

import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.mqtt.publisher.Publisher;

public class RequestTestOffline {

	@Test
	public void test() throws DecoderException, UnknownHostException, IOException {

		byte[] g = Hex.decodeHex("00FF01FE3000000000201000");
		g = Hex.decodeHex("11EE11EE312E690B2A02400000");
		// 50 5E
		System.out.println("00FF01FE3000000000201000");
		int Calc_CRC = Service.CRC(g);
		byte[] recCRC = Service.intToBytes(Calc_CRC);
		System.out.println(Hex.encodeHexString(recCRC));
		// byte[] recCRC2 = Service.integerToTwoBytes(Calc_CRC);

		Request s = new Request();
		byte Address = 0x08;
		byte AddressPeriferica = 0x08;
		byte[] finalmessage = s.get_T_REQ_BOARD_STD(Address, AddressPeriferica);
		System.out.println(Hex.encodeHexString(finalmessage));
		System.out.println(new String(finalmessage));

		// finalmessage = s.get_T_REQ_Alarm(b, b);
		System.out.println(Hex.encodeHexString(finalmessage));
		System.out.println(new String(finalmessage));
		
		
		byte[] decodee = Hex.decodeHex("1408f708f741c1060f2a0d4174000740000804041902053000000200000400000600000800000a00000c00000e00001000001200001400001600001800001a00001c00001e00002000002200002400002600002800002a00002c00002e000030000032000000000840000804041902053000000200000400000600000800000a00000c00000e00001000001200001400001600001800001a00001c00001e00002000002200002400002600002800002a00002c00002e000030000032000000004240000804041902053000000200000400000600000800000a00000c00000e00001000001200001400001600001800001a00001c00001e00002000002200002400002600002800002a00002c00002e0000300000320000000012e817" );

		Reader read = new Reader();
		read.Read(decodee);
		
		DecodeMessage dm = read.getDm();
		
		List<MessageDiretto> lmdiretto = dm.getLmd();
		
		for (MessageDiretto messageDiretto : lmdiretto) {
			String jsonOutput= JSON.toJSONString(messageDiretto);
			Publisher pub  = new Publisher();
			
			pub.send(jsonOutput.getBytes(), messageDiretto.getAddress(), "RT");
			
		}
		
		System.out.println("End");
		/*
		
		String hostname = "spagnolo2.isti.cnr.it";
		int port = 9999;

		try (Socket socket = new Socket(hostname, port)) {

			// OutputStream output = socket.getOutputStream();

			DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

			os.write(finalmessage);
			os.flush();

			InputStream inputStream = socket.getInputStream();

			// read from the stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] content = new byte[1];
			int bytesRead = -1;
			boolean bandiera = true;
			int readb = 0;
			while (((bytesRead = inputStream.read(content)) != -1)) {
				baos.write(content, 0, bytesRead);
				readb++;
				if (content[0] == 0x17) {
					if (readb > 10)
						break;
				}
			} // while

			socket.close();
			System.out.println("Client Closed");
			// System.out.println( Hex.encodeHexString(baos.toByteArray()));
			System.out.println(Hex.encodeHexString(baos.toByteArray()));
			Reader read = new Reader();
			read.Read(baos.toByteArray());

			System.out.println(read);

			EsitiScarico es = EsitiScarico.getEsitiScarico(4264193);

			boolean d = es.isAllarmi();
			System.out.println("End");

		} catch (UnknownHostException ex) {

			System.out.println("Server not found: " + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("I/O error: " + ex.getMessage());
		}*/
	}

}
