package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.util.Service;

public class Message {

	@JSONField(name = "Address")
	String ind;
	@JSONField(name = "CodiceEvento")
	String cod;
	@JSONField(name = "Dett.evento1")
	String dett1;
	@JSONField(name = "Dett.evento2")
	String dett2;
	@JSONField(name = "Dett.evento3")
	String dett3;
	@JSONField(name = "Dett.evento4")
	String dett4;
	@JSONField(name="DataECM")
	long data;
	@JSONField(name="millisencod")
	int cent;

	public Message(byte[] range) {

		ind = String.format("%02x", range[0]);
		cod = String.format("%02x", range[1]);
		dett1 = String.format("%02x", range[2]);
		dett2 = String.format("%02x", range[3]);
		dett3 = String.format("%02x", range[4]);
		dett4 = String.format("%02x", range[5]);
		data = Service.bytesToLong(Arrays.copyOfRange(range, 6, 10));

		cent = range[10];

	}
	
	

	public String getInd() {
		return ind;
	}



	public void setInd(String ind) {
		this.ind = ind;
	}



	public String getCod() {
		return cod;
	}



	public void setCod(String cod) {
		this.cod = cod;
	}



	public String getDett1() {
		return dett1;
	}



	public void setDett1(String dett1) {
		this.dett1 = dett1;
	}



	public String getDett2() {
		return dett2;
	}



	public void setDett2(String dett2) {
		this.dett2 = dett2;
	}



	public String getDett3() {
		return dett3;
	}



	public void setDett3(String dett3) {
		this.dett3 = dett3;
	}



	public String getDett4() {
		return dett4;
	}



	public void setDett4(String dett4) {
		this.dett4 = dett4;
	}



	public int getCent() {
		return cent;
	}



	public void setCent(int cent) {
		this.cent = cent;
	}



	public void setData(long data) {
		this.data = data;
	}



	public String getData() {
		return Service.getTime(data);
	}

	@Override
	public String toString() {
		return (ind != null ? "ind=" + ind + ", " : "") + (cod != null ? "cod=" + cod + ", " : "")
				+ (dett1 != null ? "dett1=" + dett1 + ", " : "") + (dett2 != null ? "dett2=" + dett2 + ", " : "")
				+ (dett3 != null ? "dett3=" + dett3 + ", " : "") + (dett4 != null ? "dett4=" + dett4 + ", " : "")
				+ "data=" + Service.getTime(data) + ", cent=" + cent + System.lineSeparator();
	}

}
