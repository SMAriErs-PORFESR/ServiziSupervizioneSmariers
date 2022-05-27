package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaRegValoreCanaleAnalogica;

public class MessageRegAnalogica {
	
	@JSONField(name = "Address")//, ordinal = 1)
	String Address;
	
	@JSONField(name = "NumAnalog")
	int  analog;

	@JSONField(name="Data", format="dd/MM/yyyy HH:mm:ss" , ordinal = 2)
	private Date date;
	@JSONField(name = "DecodificaRegValoreCanaleAnalogica")
	private List<DecodificaRegValoreCanaleAnalogica> listdec = new  ArrayList<DecodificaRegValoreCanaleAnalogica>();
	
	int index = 2;
	
	public MessageRegAnalogica(byte[] range, Date date) {
		this.date=date;

		
		Address = String.format("%02x", range[0]);
		analog = range[1];
		int d = 1;
		for(int i=0;  i<=(analog/2); i++) {
			DecodificaRegValoreCanaleAnalogica dec = new DecodificaRegValoreCanaleAnalogica(range[i+2],d);
			d = d +2;
			listdec.add(dec);
			
		}
		index = (analog/2) +2;
		
	}

	

	public int getLastIndex() {
		return index;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public int getAnalog() {
		return analog;
	}



	public void setAnalog(int analog) {
		this.analog = analog;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public List<DecodificaRegValoreCanaleAnalogica> getListdec() {
		return listdec;
	}



	public void setListdec(List<DecodificaRegValoreCanaleAnalogica> listdec) {
		this.listdec = listdec;
	}



	@Override
	public String toString() {
		return (Address != null ? Address + ", " : "") + analog + ", " + (date != null ? date + ", " : "")
				+ (listdec != null ? listdec : "");
	}
	
	
}
