package cnr.isti.data.input.protocollo;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaAnalogica;
import cnr.isti.data.input.protocollo.decode.DecodificaPresenze;
import cnr.isti.data.input.protocollo.util.Service;

public class MessagePresenza {

	@JSONField(name = "Address")
	String ind;
	@JSONField(name = "AddreddPeriferica")
	String addper;
	@JSONField(name = "DecodificaPresenze")
	DecodificaPresenze decodificaPresenze;
	@JSONField(name = "Data")
	Date data;
	

	/**
	 * 
	 */
	public MessagePresenza(byte[] range, Date data, String ind , String addper) {
		this.ind = String.format("%02x", range[0]);
		byte[] cod = Arrays.copyOfRange(range, 1, 6);

		decodificaPresenze = new DecodificaPresenze(cod);

		this.data= data;
		//this.ind= ind;
		this.addper=addper;
		// Service.getTime(TIME_INFO);
		

	}


	public String getInd() {
		return ind;
	}


	public void setInd(String ind) {
		this.ind = ind;
	}


	public String getAddcd() {
		return addper;
	}


	public void setAddcd(String addcd) {
		this.addper = addcd;
	}


	public DecodificaPresenze getDecodificaPpresenze() {
		return decodificaPresenze;
	}


	public void setDecodificaPresenze(DecodificaPresenze decodificaPpresenze) {
		this.decodificaPresenze = decodificaPpresenze;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return (ind != null ? "ind: " + ind + ",  " : "") + (addper != null ? "addper: " + addper + ",  " : "")
				+ (decodificaPresenze != null ? "decodificaPresenze: " + decodificaPresenze + ",  " : "")
				+ (data != null ? "data: " + data : "");
	}


	

	
	
	

	

}
