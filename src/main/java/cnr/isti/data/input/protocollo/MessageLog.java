package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaAnalogica;
import cnr.isti.data.input.protocollo.util.Service;

public class MessageLog {

	@JSONField(name = "Address")
	String ind;
	@JSONField(name = "Analog")
	DecodificaAnalogica idcanale;
	@JSONField(name = "Valore")
	String valore;
	@JSONField(name = "Data")
	long data;
	@JSONField(name = "centesimi")
	int cent;

	/**
	 * 
	 */
	public MessageLog(byte[] range) {
		ind = String.format("%02x", range[0]);
		byte[] cod = Arrays.copyOfRange(range, 1, 6);

		idcanale = new DecodificaAnalogica(cod);

		byte[] Time = Arrays.copyOfRange(range, 6, 10);// 4
		data = Service.bytesToLong(Time);
		// Service.getTime(TIME_INFO);
		cent = range[10];

	}

	public String getData() {
		return Service.getTime(data);
	}
	
	

	public String getInd() {
		return ind;
	}

	public void setInd(String ind) {
		this.ind = ind;
	}

	public DecodificaAnalogica getIdcanale() {
		return idcanale;
	}

	public void setIdcanale(DecodificaAnalogica idcanale) {
		this.idcanale = idcanale;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
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

	@Override
	public String toString() {
		return (ind != null ? "ind: " + ind + ",  " : "") + (idcanale != null ? "idcanale: " + idcanale + ",  " : "")
				+ (valore != null ? "valore: " + valore + ",  " : "") + "data: " + data + ",  cent: " + cent;
	}

}
