package cnr.isti.data.input.protocollo;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Arrays;

import cnr.isti.data.input.protocollo.util.Service;
import org.apache.commons.codec.binary.Hex;

public class DecodificaDiagnostica {
	
	int ALLARMECRITICO = 0;
	int PRESENZAEVENTI = 0;
	int PRESENZAALLARMI = 0;
	int PRESENZAWARNING = 0;
	int PRESENZALOG = 0;
	int ATTIVITA = 0;
	int ERRORECOM = 0;
	
	
	
	public DecodificaDiagnostica(byte[] msg) {
		
		ALLARMECRITICO = Service.bitExtracted(msg[0],1,1);
	    PRESENZAEVENTI = Service.bitExtracted(msg[0],1,2);
		PRESENZAALLARMI = Service.bitExtracted(msg[0],1,3);
		PRESENZAWARNING = Service.bitExtracted(msg[0],1,5);
		PRESENZALOG = Service.bitExtracted(msg[0],1,4);
		ATTIVITA = Service.bitExtracted(msg[0],1,8);
		ERRORECOM = Service.bitExtracted(msg[1],1,1);

		
	}

	public boolean isEventi() {
		if(PRESENZAEVENTI==1)return true;
		return false;
	}
	
	public boolean isAttivita() {
		if(ATTIVITA==1)return true;
		return false;
	}

	public boolean isWarning() {
		if(PRESENZAWARNING==1)return true;
		return false;
	}

	public boolean isAllarmi() {
		if(PRESENZAALLARMI==1)return true;
		return false;
	}
	
	public boolean isCritico() {
		if(ALLARMECRITICO==1)return true;
		return false;
	}
	
	public boolean isLog() {
		if(PRESENZALOG==1)return true;
		return false;
	}
	
	public boolean isError() {
		if(ERRORECOM==1)return true;
		return false;
	}

	@Override
	public String toString() {
		return "ALLARMECRITICO: " + ALLARMECRITICO + ",  PRESENZAEVENTI: " + PRESENZAEVENTI
				+ ",  PRESENZAALLARMI: " + PRESENZAALLARMI
				+ ",  PRESENZAWARNING: " + PRESENZAWARNING + ",  PRESENZALOG: "
				+ PRESENZALOG + ",  ATTIVITA: " + ATTIVITA + ",  ERRORECOM: "
				+ ERRORECOM+" "+System.lineSeparator();
	}
	
	
	

}
