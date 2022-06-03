package cnr.isti.data.input.protocollo;

import java.util.Arrays;
import java.util.Map;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.config.LoadTableEventi;
import cnr.isti.data.input.protocollo.decode.deprecated.TableCodiceEventi;
import cnr.isti.data.input.protocollo.util.Pair;
import cnr.isti.data.input.protocollo.util.Service;

public class MessageWAD {

	@JSONField(name = "Address")
	String ind;
	@JSONField(name = "CodiceEvento")
	String cod;
	@JSONField(name = "DescrizioneEvento")
	String descrizione;
	@JSONField(name = "TipoEvento")
	String tipo;
	@JSONField(name = "Dettevento1")
	String dett1;
	@JSONField(name = "Dettevento2")
	String dett2;
	@JSONField(name = "Dettevento3")
	String dett3;
	@JSONField(name = "Dettevento4")
	String dett4;
	@JSONField(name="Data")
	long data;
	@JSONField(name="millisecond")
	int cent;

	public MessageWAD(byte[] range) {

		ind = String.format("%02x", range[0]);
		cod = String.format("%02x", range[1]);
		dett1 = String.format("%02x", range[2]);
		dett2 = String.format("%02x", range[3]);
		dett3 = String.format("%02x", range[4]);
		dett4 = String.format("%02x", range[5]);
		LoadTableEventi lte = new LoadTableEventi();
	    Pair<String, String> pair = lte.getDiagnosticaDesc(range[0], range[1] & 0xff);
		data = Service.bytesToLong(Arrays.copyOfRange(range, 6, 10));
		descrizione = pair.getPrimo();//TableCodiceEventi.getDesc(Integer.decode("0x"+cod));
		tipo  = pair.getSecondo();//TableCodiceEventi.getTipo(Integer.decode("0x"+cod));
		cent = range[10];

	}
	
	
	

	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getDescrizione() {
		return descrizione;
	}




	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
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
