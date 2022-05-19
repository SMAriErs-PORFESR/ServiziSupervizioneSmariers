package cnr.isti.data.input.protocollo.decode;

import cnr.isti.data.input.protocollo.util.Service;

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

	public int getALLARMECRITICO() {
		return ALLARMECRITICO;
	}

	public void setALLARMECRITICO(int aLLARMECRITICO) {
		ALLARMECRITICO = aLLARMECRITICO;
	}

	public int getPRESENZAEVENTI() {
		return PRESENZAEVENTI;
	}

	public void setPRESENZAEVENTI(int pRESENZAEVENTI) {
		PRESENZAEVENTI = pRESENZAEVENTI;
	}

	public int getPRESENZAALLARMI() {
		return PRESENZAALLARMI;
	}

	public void setPRESENZAALLARMI(int pRESENZAALLARMI) {
		PRESENZAALLARMI = pRESENZAALLARMI;
	}

	public int getPRESENZAWARNING() {
		return PRESENZAWARNING;
	}

	public void setPRESENZAWARNING(int pRESENZAWARNING) {
		PRESENZAWARNING = pRESENZAWARNING;
	}

	public int getPRESENZALOG() {
		return PRESENZALOG;
	}

	public void setPRESENZALOG(int pRESENZALOG) {
		PRESENZALOG = pRESENZALOG;
	}

	public int getATTIVITA() {
		return ATTIVITA;
	}

	public void setATTIVITA(int aTTIVITA) {
		ATTIVITA = aTTIVITA;
	}

	public int getERRORECOM() {
		return ERRORECOM;
	}

	public void setERRORECOM(int eRRORECOM) {
		ERRORECOM = eRRORECOM;
	}
	
	
	
	

}
