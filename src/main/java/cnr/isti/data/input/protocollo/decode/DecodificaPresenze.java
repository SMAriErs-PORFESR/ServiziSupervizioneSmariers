package cnr.isti.data.input.protocollo.decode;



import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaPresenze {
	
	int  ModuloAttivo = 0;
	int  PresenzaEventi  = 0;
	int  PresenzaAllarmi = 0;
	int  PresenzaWarning = 0;
	int  PresenzaLog = 0;
	
	
	public DecodificaPresenze(byte [] decode){
		
		ModuloAttivo = Service.bitExtracted(decode[0],1,1);
		PresenzaEventi = Service.bitExtracted(decode[0],1,5);
		PresenzaAllarmi = Service.bitExtracted(decode[1],1,1);
		PresenzaWarning = Service.bitExtracted(decode[1],1,6);
		PresenzaLog = Service.bitExtracted(decode[1],1,7);
		
	}


	public int getModuloAttivo() {
		return ModuloAttivo;
	}


	public void setModuloAttivo(int moduloAttivo) {
		ModuloAttivo = moduloAttivo;
	}


	public int getPresenzaEventi() {
		return PresenzaEventi;
	}


	public void setPresenzaEventi(int presenzaEventi) {
		PresenzaEventi = presenzaEventi;
	}


	public int getPresenzaAllarmi() {
		return PresenzaAllarmi;
	}


	public void setPresenzaAllarmi(int presenzaAllarmi) {
		PresenzaAllarmi = presenzaAllarmi;
	}


	public int getPresenzaWarning() {
		return PresenzaWarning;
	}


	public void setPresenzaWarning(int presenzaWarning) {
		PresenzaWarning = presenzaWarning;
	}


	public int getPresenzaLog() {
		return PresenzaLog;
	}


	public void setPresenzaLog(int presenzaLog) {
		PresenzaLog = presenzaLog;
	}


	@Override
	public String toString() {
		return "ModuloAttivo: " + ModuloAttivo + ",  PresenzaEventi: " + PresenzaEventi + ",  PresenzaAllarmi: "
				+ PresenzaAllarmi + ",  PresenzaWarning: " + PresenzaWarning + ",  PresenzaLog: " + PresenzaLog;
	}
	
	
	

}
