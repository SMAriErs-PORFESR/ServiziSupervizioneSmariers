package cnr.isti.data.input.protocollo;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import cnr.isti.config.Config;
import cnr.isti.data.input.protocollo.decode.EsitiScarico;
import cnr.isti.data.input.protocollo.util.Service;
import cnr.isti.main.thread.ThreadSendRealTime;

public class RequestTestThreadRealTime {

	@Test
	public void test() throws DecoderException, UnknownHostException, IOException {
		
		
		try {
			
			Config config = new Config();
			
			byte[] AddressCD = config.getAddressCD();
			byte[] AddressPeriferica = config.getAddressPeriferica();
			
			ThreadSendRealTime th = new ThreadSendRealTime(AddressCD[0],AddressPeriferica[0]);
			
			th.setFinite();
			
			Thread thread = new Thread(th);
			
	        thread.start();
	        
	        thread.join();
	        
			
		}catch (Exception e) {
			
		}
		
	}
    
		
	

}
