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
	
	
	
	public MessageRegAnalogica(byte[] range, Date date) {
		this.date=date;

		
		Address = String.format("%02x", range[0]);
		analog = range[1];
		int d = 1;
		for(int i=2; (i<range.length & i<analog); i++) {
			DecodificaRegValoreCanaleAnalogica dec = new DecodificaRegValoreCanaleAnalogica(range[i],d);
			d = d +1;
			listdec.add(dec);
		}
		
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
