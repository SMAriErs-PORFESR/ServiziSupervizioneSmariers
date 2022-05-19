package cnr.isti.data.input.protocollo;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaPresenze;

public class MessagePresenza {

	@JSONField(name = "Address")
	String Address;
	@JSONField(name = "AddreddPeriferica")
	String AddreddPeriferica;
	@JSONField(name = "DecodificaPresenze")
	DecodificaPresenze decodificaPresenze;
	@JSONField(name = "Data")
	Date data;
	

	/**
	 * 
	 */
	public MessagePresenza(byte[] range, Date data, String ind , String addper) {
		this.Address = String.format("%02x", range[0]);
		byte[] cod = Arrays.copyOfRange(range, 1, 6);

		decodificaPresenze = new DecodificaPresenze(cod);

		this.data= data;
		//this.ind= ind;
		this.AddreddPeriferica=addper;
		// Service.getTime(TIME_INFO);
		

	}


	


	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}





	public String getAddreddPeriferica() {
		return AddreddPeriferica;
	}





	public void setAddreddPeriferica(String addreddPeriferica) {
		AddreddPeriferica = addreddPeriferica;
	}





	public DecodificaPresenze getDecodificaPresenze() {
		return decodificaPresenze;
	}





	public void setDecodificaPresenze(DecodificaPresenze decodificaPresenze) {
		this.decodificaPresenze = decodificaPresenze;
	}





	public Date getData() {
		return data;
	}





	public void setData(Date data) {
		this.data = data;
	}





	@Override
	public String toString() {
		return (Address != null ? "ind: " + Address + ",  " : "") + (AddreddPeriferica != null ? "addper: " + AddreddPeriferica + ",  " : "")
				+ (decodificaPresenze != null ? "decodificaPresenze: " + decodificaPresenze + ",  " : "")
				+ (data != null ? "data: " + data : "");
	}


	

	
	
	

	

}
