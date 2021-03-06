package cnr.isti.data.input.protocollo.decode;

import java.util.Arrays;



import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.deprecated.TableAnalog;
import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaAnalogica {
	
	//private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(DecodificaAnalogica.class);
	
	@JSONField(name = "Tipo")
	int tipo = 0;
	@JSONField(name = "Canale")
	int canale = 0;
	@JSONField(name = "Segno")
	int segno = 0;
	@JSONField(name = "Valore")
	long valore = 0;
	@JSONField(name = "Descrizione")
	String descrizione = "";
	@JSONField(name = "Precision")
	double precision = 0;
	@JSONField(name = "Misura")
	String misura= "";
	
	public DecodificaAnalogica() {
		
	}
	
	public DecodificaAnalogica(byte address, byte[] msg, Analog analog) {
		byte spacca = msg[0];
		tipo = Service.bitExtracted(spacca, 1, 1);
		segno = Service.bitExtracted(spacca, 1, 8);
		canale = Service.bitExtracted(spacca, 6, 2);
		byte[] v = Arrays.copyOfRange(msg, 1, 3);

		valore = Service.TwobytesToLong(v);
		
		descrizione =  analog.getDesc(canale);
		
		precision  =  analog.getPrecision(canale);
		
		misura = analog.getMisure(canale);
		
		//System.out.println();
		
	}
	
	
	
	

	public String getMisura() {
		return misura;
	}





	public void setMisura(String misura) {
		this.misura = misura;
	}





	public double getPrecision() {
		return precision;
	}





	public void setPrecision(double precision) {
		this.precision = precision;
	}





	public String getDescrizione() {
		return descrizione;
	}





	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}





	public int getTipo() {
		return tipo;
	}



	public void setTipo(int tipo) {
		this.tipo = tipo;
	}



	public int getCanale() {
		return canale;
	}



	public void setCanale(int canale) {
		this.canale = canale;
	}



	public int getSegno() {
		return segno;
	}



	public void setSegno(int segno) {
		this.segno = segno;
	}



	public long getValore() {
		return valore;
	}



	public void setValore(long valore) {
		this.valore = valore;
	}



	@Override
	public String toString() {
		return System.lineSeparator() +"tipo: " + tipo + ",  canale: " + TableAnalog.getDesc(canale) + ",  segno: " + segno + ",  valore: " + valore ;
	}

	
	
	

}
