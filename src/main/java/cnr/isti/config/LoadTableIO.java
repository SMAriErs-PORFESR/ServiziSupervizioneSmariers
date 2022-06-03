package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cnr.isti.data.input.protocollo.util.Pair;



public class LoadTableIO {

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LoadTableIO.class);

	
	
	public Map<String,String>  getTable(byte address, int io){
		String Address = String.format("%02x", address);
		 Map<String,String> table =  new HashMap<String,String>();
		 String type = "input";
		 if(io ==2) type = "output";
		 if(io ==3) type = "diagnostica";	
		 if(io ==4) type = "analog";	 
		 try (InputStream input = LoadTable.class.getClassLoader()
					.getResourceAsStream("data/"+Address + "."+type+".txt")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);
					for(int i=0; i<=64; i++) {
					 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
					}
					return table;
				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}

			try (InputStream input = LoadTable.class.getClassLoader().getResourceAsStream("FF"+ "."+type+".txt")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);

					// get the property value and print it out

					for(int i=0; i<=64; i++) {
						 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
						}

				}
				
			} catch (IOException ex) {
				log.error(ex, ex);
			}
			log.error("** MANCA FILE***");
			log.error(type);
			log.error(address);
			log.error("** FINE MANCA FILE***");
		return table;
	}

	

}
