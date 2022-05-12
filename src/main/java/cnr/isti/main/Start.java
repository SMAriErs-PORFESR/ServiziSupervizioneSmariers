package cnr.isti.main;

import cnr.isti.config.Config;

public class Start {
	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Start.class);

	public static void main(String[] args) {
		Config config = new Config();
		String serverUrl = config.getISO1Url();
		String port = config.getISO1Port();
		
		while(true) {
			
			try {
				
				
				
				
				
			}catch (Exception e) {
				log.error(e.getLocalizedMessage());
			}
			
		}

	}

}
