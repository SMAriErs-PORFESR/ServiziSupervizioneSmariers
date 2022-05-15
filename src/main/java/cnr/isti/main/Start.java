package cnr.isti.main;

import cnr.isti.config.Config;
import cnr.isti.main.thread.ThreadSendRealTime;

public class Start {
	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Start.class);

	public static void main(String[] args) {
		
			
			try {
				
				Config config = new Config();
				
				byte[] AddressCD = config.getAddressCD();
				byte[] AddressPeriferica = config.getAddressPeriferica();
				
				ThreadSendRealTime th = new ThreadSendRealTime(AddressCD[0],AddressPeriferica[0]);
				
				Thread thread = new Thread(th);
				
		        thread.start();
		        
		        thread.join();
				
			}catch (Exception e) {
				log.error(e.getLocalizedMessage());
			}
			
		}

	

}
