package cnr.isti.data.input.protocollo.decode;

import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaRegValoreCanaleAnalogica {
	
	
	int n = 0;
	int n1 = 0;
	int analogica_n_allarme = 0;
	int analogica_n_warning = 0;
	int analogica_n_errore = 0;
	int offline_n = 0;
	int analogica_n1_allarme = 0;
	int analogica_n1_warning = 0;
	int analogica_n1_errore = 0;
	int offline_n1 = 0;
	String descrizione_n;
	String descrizione_n1;
	
	
	
	public DecodificaRegValoreCanaleAnalogica(byte msg, int n) {
		this.n= n;
		this.n1= n+1;
		analogica_n_allarme = Service.bitExtracted(msg,1,1);
		analogica_n_warning= Service.bitExtracted(msg,1,2); 
		analogica_n_errore = Service.bitExtracted(msg,1,3);
		offline_n = Service.bitExtracted(msg,1,4);
		analogica_n1_allarme= Service.bitExtracted(msg,1,5);
		analogica_n1_warning= Service.bitExtracted(msg,1,6);
		analogica_n1_errore= Service.bitExtracted(msg,1,7);
		offline_n1= Service.bitExtracted(msg,1,8);
		descrizione_n =  TableAnalog.getDesc(n);
		descrizione_n1 =  TableAnalog.getDesc(n1);
	}



	public String getDescrizione_n() {
		return descrizione_n;
	}



	public void setDescrizione_n(String descrizione_n) {
		this.descrizione_n = descrizione_n;
	}



	public String getDescrizione_n1() {
		return descrizione_n1;
	}



	public void setDescrizione_n1(String descrizione_n1) {
		this.descrizione_n1 = descrizione_n1;
	}



	public int getN() {
		return n;
	}



	public void setN(int n) {
		this.n = n;
	}



	public int getN1() {
		return n1;
	}



	public void setN1(int n1) {
		this.n1 = n1;
	}



	public int getAnalogica_n_allarme() {
		return analogica_n_allarme;
	}



	public void setAnalogica_n_allarme(int analogica_n_allarme) {
		this.analogica_n_allarme = analogica_n_allarme;
	}



	public int getAnalogica_n_warning() {
		return analogica_n_warning;
	}



	public void setAnalogica_n_warning(int analogica_n_warning) {
		this.analogica_n_warning = analogica_n_warning;
	}



	public int getAnalogica_n_errore() {
		return analogica_n_errore;
	}



	public void setAnalogica_n_errore(int analogica_n_errore) {
		this.analogica_n_errore = analogica_n_errore;
	}



	public int getOffline_n() {
		return offline_n;
	}



	public void setOffline_n(int offline_n) {
		this.offline_n = offline_n;
	}



	public int getAnalogica_n1_allarme() {
		return analogica_n1_allarme;
	}



	public void setAnalogica_n1_allarme(int analogica_n1_allarme) {
		this.analogica_n1_allarme = analogica_n1_allarme;
	}



	public int getAnalogica_n1_warning() {
		return analogica_n1_warning;
	}



	public void setAnalogica_n1_warning(int analogica_n1_warning) {
		this.analogica_n1_warning = analogica_n1_warning;
	}



	public int getAnalogica_n1_errore() {
		return analogica_n1_errore;
	}



	public void setAnalogica_n1_errore(int analogica_n1_errore) {
		this.analogica_n1_errore = analogica_n1_errore;
	}



	public int getOffline_n1() {
		return offline_n1;
	}



	public void setOffline_n1(int offline_n1) {
		this.offline_n1 = offline_n1;
	}



	@Override
	public String toString() {
		return analogica_n_allarme + ", " + analogica_n_warning + ", " + analogica_n_errore + ", " + offline_n + ", "
				+ analogica_n1_allarme + ", " + analogica_n1_warning + ", " + analogica_n1_errore + ", " + offline_n1;
	}

	
	
	

}
