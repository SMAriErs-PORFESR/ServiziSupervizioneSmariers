package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cnr.isti.data.input.protocollo.util.Pair;



public class LoadTableEventi {

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LoadTableEventi.class);

	
	
	public Map<String,String>  getTable(byte address){
		String Address = String.format("%02x", address);
		 Map<String,String> table =  new HashMap<String,String>();
		 try (InputStream input = LoadTable.class.getClassLoader()
					.getResourceAsStream(Address + ".eventi.properties")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);
					for(int i=0; i<=114; i++) {
					 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
					}

				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}

			try (InputStream input = LoadTable.class.getClassLoader().getResourceAsStream("FF.eventi.properties")) {

				// try (InputStream input = new FileInputStream("path/to/config.properties")) {
				if (input != null) {
					Properties prop = new Properties();

					// load a properties file
					prop.load(input);

					// get the property value and print it out

					for(int i=0; i<=114; i++) {
						 table.put(String.valueOf(i),prop.getProperty(String.valueOf(i)));
						}

				}

			} catch (IOException ex) {
				log.error(ex, ex);
			}
		
		return table;
	}

	public Pair<String,String> getDiagnosticaDesc(byte address, int i) {
		String Address = String.format("%02x", address);
		try (InputStream input = LoadTableEventi.class.getClassLoader()
				.getResourceAsStream(Address + ".eventi.properties")) {

			// try (InputStream input = new FileInputStream("path/to/config.properties")) {
			if (input != null) {
				Properties prop = new Properties();

				// load a properties file
				prop.load(input);
				 String tipo = "Evento";
				// get the property value and print it out
				String[] r = prop.getProperty(String.valueOf(i)).split(",");
				if(r[1].equals("1")) {
					tipo = "Evento";
				}
				if(r[1].equals("2")) {
					tipo = "Evento";
				}
				if(r[1].equals("3")) {
					tipo = "Warning";
				}
				log.trace(prop.getProperty(String.valueOf(i)));
				return new Pair<>(r[0], tipo);
			}

		} catch (IOException ex) {
			log.error(ex, ex);
		}

		try (InputStream input = LoadTableEventi.class.getClassLoader().getResourceAsStream("FF.eventi.properties")) {

			// try (InputStream input = new FileInputStream("path/to/config.properties")) {
			if (input != null) {
				Properties prop = new Properties();

				// load a properties file
				prop.load(input);

				// get the property value and print it out
				 String tipo = "Evento";
				String[] r = prop.getProperty(String.valueOf(i)).split(",");
				if(r == null) {
					return new Pair<>("", "");
				}
				if(r[1].equals("1")) {
					tipo = "Evento";
				}
				if(r[1].equals("2")) {
					tipo = "Evento";
				}
				if(r[1].equals("3")) {
					tipo = "Warning";
				}
				log.trace(prop.getProperty(String.valueOf(i)));
				return new Pair<>(r[0], tipo);
			}

		} catch (IOException ex) {
			log.error(ex, ex);
		}

		return  new Pair<>("", "");
	}

	

}
