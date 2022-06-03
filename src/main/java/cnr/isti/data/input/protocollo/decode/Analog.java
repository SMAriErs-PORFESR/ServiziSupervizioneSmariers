package cnr.isti.data.input.protocollo.decode;

import java.util.Map;

import cnr.isti.config.LoadTableIO;

public class Analog {
	
	String Address = "";
	Map<String, String> analogmap;

	public Analog(byte address) {
		this.Address = String.format("%02x", address);
		
		LoadTableIO lt = new LoadTableIO(); 
		analogmap = lt.getTable(address, 4);
	}

	public  String getDesc(int canale) {
		String rigo = analogmap.get(String.valueOf(canale));
		if(rigo!=null){
		String row[] = rigo.split(",");
		
		return row[0];
		}
		return "";
	}

	public double getPrecision(int canale) {
		String rigo = analogmap.get(String.valueOf(canale));
		String row[] = rigo.split(",");
		
		return Double.parseDouble(row[2]);
	}

	public String getMisure(int canale) {
		String rigo = analogmap.get(String.valueOf(canale));
		String row[] = rigo.split(",");
		
		return row[1];
	}
		
}
