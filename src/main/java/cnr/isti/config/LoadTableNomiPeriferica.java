package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cnr.isti.data.input.protocollo.util.Pair;



public class LoadTableNomiPeriferica {

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LoadTableNomiPeriferica.class);
	
	public String  getDesc(byte address){
		String Address = String.format("%02x", address);
		 
		 	 
		 try (InputStream input = LoadTable.class.getClassLoader()
					.getResourceAsStream("nomiperiferiiche.properties")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);
					
					String desc = prop.getProperty(String.valueOf(Address));
					
					return desc;
				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}

			
		return "";
	}

	

}
