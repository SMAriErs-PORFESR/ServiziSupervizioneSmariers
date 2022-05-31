package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cnr.isti.data.input.protocollo.util.Pair;



public class LoadTableEventi {

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LoadTableEventi.class);


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
