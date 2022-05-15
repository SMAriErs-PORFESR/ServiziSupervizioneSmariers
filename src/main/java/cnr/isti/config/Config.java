package cnr.isti.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;



public class Config {
	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Config.class);
	
	
	public String getISO1Url() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("ISO1.url"));
            return prop.getProperty("ISO1.url");
           

        } catch (IOException ex) {
        	log.error(ex,ex);
        }
		return "spagnolo2.isti.cnr.it";
	}
	
	public String getISO1Port() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("ISO1.port"));
            return prop.getProperty("ISO1.port");
           

        } catch (IOException ex) {
        	log.error(ex,ex);
        }
		return "9999";
	}

	
	public String getMoqosquittoUrl() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("mosquitto.url"));
            return prop.getProperty("mosquitto.url");
           

        } catch (IOException ex) {
        	log.error(ex,ex);
        }
		return "ssl://stingray.isti.cnr.it:8883";
	}
	
	public String getMoqosquittoUser() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("mosquitto.user"));
            return prop.getProperty("mosquitto.user");
           

        } catch (IOException ex) {
        	log.error(ex,ex);
        }
		return "stingrayserver";
	}
	
	public String getMoqosquittoPass() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("mosquitto.pass"));
            return prop.getProperty("mosquitto.pass");
           

        } catch (IOException ex) {
        	log.error(ex,ex);
        }
		return "stingrayserver";
	}
	
	public byte[] getAddressPeriferica() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.trace(prop.getProperty("AddressPeriferica"));
            
           String p = prop.getProperty("AddressPeriferica");
           String [] listcd  =  p.split(",");
           byte[] result = new byte[listcd.length];
           for(int i=0; i<listcd.length; i++) {
        	   byte[] m = Hex.decodeHex(listcd[i]);
        	    result[i] = m[0];
           }
           
           
            return result;
           

        } catch (IOException | DecoderException ex) {
        	log.error(ex,ex);
        }
	
		return null;
	}
	public byte[] getAddressCD() {
		try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")){

		//try (InputStream input = new FileInputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            
            log.info(prop.getProperty("AddressCD"));
            
           String p = prop.getProperty("AddressCD");
           String [] listcd  =  p.split(",");
           byte[] result = new byte[listcd.length];
           for(int i=0; i<listcd.length; i++) {
        	   byte[] m = Hex.decodeHex(listcd[i]);
        	    result[i] = m[0];
           }
           
           
            return result;
           

        } catch (IOException | DecoderException ex) {
        	log.error(ex,ex);
        }
	
		return null;
	}

}
