package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaAnalogica;
import cnr.isti.data.input.protocollo.decode.DecodificaDiagnostica;
import cnr.isti.data.input.protocollo.decode.DecodificaDigitalInputs;
import cnr.isti.data.input.protocollo.decode.DecodificaDigitalOutput;
import cnr.isti.data.input.protocollo.decode.DecodificaTDiagnostica;


public class MessageDiretto {

	@JSONField(name = "Address")//, ordinal = 1)
	String Address;
	@JSONField(name = "Diagnostica")
	DecodificaDiagnostica diagnostica;
	
	@JSONField(name = "DDiagnostica")
	DecodificaTDiagnostica Tdiagnostica;
	
	@JSONField(name = "NumDigiInput")
	int diginput;
	@JSONField(name = "NumAnalog")
	int  analog;
	@JSONField(name = "NumDigiOutput")
	int digoutout;
	
	@JSONField(serialize = false)
	int lastindex =  0;
	
	@JSONField(name = "DigiInput")
	DecodificaDigitalInputs DigiInput;
	@JSONField(name = "Analog")
	List<DecodificaAnalogica> analogs = new ArrayList<>();
	
	@JSONField(name = "DigiOutput")
	DecodificaDigitalOutput DigiOutput;
	
	@JSONField(name="Data", format="dd/MM/yyyy HH:mm:ss" , ordinal = 2)
	private Date date;

	@JSONField(name="millisecond")
	private long millisencod;

	public MessageDiretto(byte[] range, Date date) {
		analogs.add(new DecodificaAnalogica());
		this.date=date;

		this.millisencod=date.getTime();
		Address = String.format("%02x", range[0]);
		byte[] bitdiagnostica = Arrays.copyOfRange(range, 1, 5);
		
		diagnostica= new DecodificaDiagnostica(bitdiagnostica);
		
		Tdiagnostica= new DecodificaTDiagnostica(bitdiagnostica, range[0]);
		
		diginput =  range[5]*8;
		analog = range[6];
		digoutout = range[7]*8;
		
		List<Integer> diginputs = new ArrayList<>();
		for(int i =0 ; i<(diginput/8); i++) {
			diginputs.add(new Integer(range[i+8]));
			
		}
		DigiInput = new DecodificaDigitalInputs(range[0], diginputs);
		
		for(int i =0 ; i<analog; i++) {
			byte[] win = Arrays.copyOfRange(range, (3*i)+(diginput/8)+8, (3*i)+(diginput/8)+8+3);
			//analogs.add(new Integer(range[i+diginput+8]));
			DecodificaAnalogica es = new DecodificaAnalogica(range[0],win);
			analogs.add(es);
			
		}
		int index = 0;
		List<Integer> digoutouts = new ArrayList<>();
		for(int i =0 ; i<(digoutout/8); i++) {
			index = i+(diginput/8)+(analog*3)+8;
			digoutouts.add(new Integer(range[index]));
			
		}
		DigiOutput = new DecodificaDigitalOutput(range[0], digoutouts);
		lastindex=  index;
		//dett4 = String.format("%02x", range[5]);
        //System.out.println();
       

	}


    
	

	public int getLastindex() {
		return lastindex;
	}





	





	public DecodificaTDiagnostica getTdiagnostica() {
		return Tdiagnostica;
	}





	public void setTdiagnostica(DecodificaTDiagnostica tdiagnostica) {
		Tdiagnostica = tdiagnostica;
	}





	@Override
	public String toString() {
		return (Address != null ? "Address: " + Address + ",  " : "")
				+ (diagnostica != null ? "bitdiagnostica: " + diagnostica + ",  " : "")
				+ "diginput: " + diginput + ",  analog: " + analog + ",  digoutout: " + digoutout + ",  "
				+ (DigiInput != null ? "diginputs: " + DigiInput + ",  " : "")
				+ (analogs != null ? "analogs: " + System.lineSeparator() + analogs + ",  " : "")
				+ (DigiOutput != null ? "digoutouts: " + DigiOutput + ",  " : "") + System.lineSeparator();
	}





	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}





	public long getMillisencod() {
		return millisencod;
	}





	public void setMillisencod(long millisencod) {
		this.millisencod = millisencod;
	}





	public DecodificaDiagnostica getDiagnostica() {
		return diagnostica;
	}





	public void setDiagnostica(DecodificaDiagnostica diagnostica) {
		this.diagnostica = diagnostica;
	}





	public int getDiginput() {
		return diginput;
	}





	public void setDiginput(int diginput) {
		this.diginput = diginput;
	}





	public int getAnalog() {
		return analog;
	}





	public void setAnalog(int analog) {
		this.analog = analog;
	}





	public int getDigoutout() {
		return digoutout;
	}





	public void setDigoutout(int digoutout) {
		this.digoutout = digoutout;
	}





	public DecodificaDigitalInputs getDigiInput() {
		return DigiInput;
	}





	public void setDigiInput(DecodificaDigitalInputs digiInput) {
		DigiInput = digiInput;
	}





	public List<DecodificaAnalogica> getAnalogs() {
		return analogs;
	}





	public void setAnalogs(List<DecodificaAnalogica> analogs) {
		this.analogs = analogs;
	}





	public DecodificaDigitalOutput getDigiOutput() {
		return DigiOutput;
	}





	public void setDigiOutput(DecodificaDigitalOutput digiOutput) {
		DigiOutput = digiOutput;
	}





	public void setLastindex(int lastindex) {
		this.lastindex = lastindex;
	}





	public Date getDate() {
		return date;
	}





	public void setDate(Date date) {
		this.date = date;
	}


	

	
	
}
