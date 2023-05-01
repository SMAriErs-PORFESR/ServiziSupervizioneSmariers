package cnr.isti.data.input.sender;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.apache.commons.codec.binary.Hex;

import cnr.isti.config.Config;

public class SenderTCP {

	private String hostname;
	private int port;

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(SenderTCP.class);
	
	
	public SenderTCP() {
		
		Config config = new Config();
		hostname = config.getISO1Url();
		port = Integer.parseInt(config.getISO1Port());
		
	}
	
	

	public SenderTCP(String hostname, int port) {
		super();
		this.hostname = hostname;
		this.port = port;
	}

	public byte[] Send(byte[] message) {
		
		//log.info("Client Started");
		log.info("Client Started "+hostname+":"+port);
		try (Socket socket = new Socket(hostname, port)) {
			socket.setSoTimeout(2000);

			log.info("Client Opened "+hostname+":"+port);
			log.info("Send: ");
			log.info(Hex.encodeHexString(message));
			DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

			os.write(message);
			os.flush();

			InputStream inputStream = socket.getInputStream();

			// read from the stream
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] content = new byte[1];
			int bytesRead = -1;
			//boolean bandiera = true;
			int readb = 0;
			while (((bytesRead = inputStream.read(content)) != -1)) {
				baos.write(content, 0, bytesRead);
				readb++;
				if (content[0] == 0x17 & readb > 10) {

					break;
				}
			} // while

			socket.close();
			log.info("Client Closed");
			log.info("Received: ");
			log.info(Hex.encodeHexString(baos.toByteArray()));
			return baos.toByteArray();
			
		} catch (UnknownHostException ex) {

			log.info("Server not found: " + ex.getMessage());

		} catch (SocketTimeoutException ex) {

			log.info("Timeout error: " + ex.getMessage());
		} catch (IOException e) {
			log.info("I/O error: " + e.getMessage());
		}
		
		return new byte[1]; 

	}

}
