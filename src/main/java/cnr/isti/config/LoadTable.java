package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;



public class LoadTable {
	
	private byte adds;

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LoadTable.class);
	
	

	
	public Map<String,String>  getTable(byte address){
		String Address = String.format("%02x", address);
		 Map<String,String> table =  new HashMap<String,String>();
		 try (InputStream input = LoadTable.class.getClassLoader()
					.getResourceAsStream("data/"+Address + ".diagnostica.properties")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);
					for(int i=0; i<=32; i++) {
					 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
					}

				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}

			try (InputStream input = LoadTable.class.getClassLoader().getResourceAsStream("FF.diagnostica.properties")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);

					// get the property value and print it out

					for(int i=0; i<=32; i++) {
						 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
						}

				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}
		
		return table;
	}

	public String getDiagnosticaDesc(byte address, int i) {
		String Address = String.format("%02x", address);
		try (InputStream input = LoadTable.class.getClassLoader()
				.getResourceAsStream(Address + ".diagnostica.properties")) {

			// try (InputStream input = new FileInputStream("path/to/config.properties")) {
			if (input != null) {
				Properties prop = new Properties();

				// load a properties file
				prop.load(input);

				// get the property value and print it out

				log.trace(prop.getProperty(String.valueOf(i)));
				return prop.getProperty(String.valueOf(i));
			}

		} catch (IOException ex) {
			log.error(ex, ex);
		}

		try (InputStream input = LoadTable.class.getClassLoader().getResourceAsStream("FF.diagnostica.properties")) {

			// try (InputStream input = new FileInputStream("path/to/config.properties")) {
			if (input != null) {
				Properties prop = new Properties();

				// load a properties file
				prop.load(input);

				// get the property value and print it out

				log.trace(prop.getProperty(String.valueOf(i)));
				return prop.getProperty(String.valueOf(i));
			}

		} catch (IOException ex) {
			log.error(ex, ex);
		}

		return "";
	}

}
