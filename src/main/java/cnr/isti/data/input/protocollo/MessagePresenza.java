package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaAnalogica;
import cnr.isti.data.input.protocollo.decode.DecodificaPresenze;
import cnr.isti.data.input.protocollo.util.Service;

public class MessagePresenza {

	@JSONField(name = "Address")
	String ind;
	@JSONField(name = "AddreddCD")
	String addcd;
	@JSONField(name = "DecodificaPresenze")
	DecodificaPresenze decodificaPpresenze;
	@JSONField(name = "Data")
	long data;
	

	/**
	 * 
	 */
	public MessagePresenza(byte[] range, long data, String ind , String addcd) {
		ind = String.format("%02x", range[0]);
		byte[] cod = Arrays.copyOfRange(range, 1, 6);

		decodificaPpresenze = new DecodificaPresenze(cod);

		this.data= data;
		this.ind= ind;
		this.addcd= addcd;
		// Service.getTime(TIME_INFO);
		

	}

	public String getData() {
		return Service.getTime(data);
	}
	
	

	

}
