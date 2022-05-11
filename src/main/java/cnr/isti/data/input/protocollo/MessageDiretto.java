package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MessageDiretto {

	String Address;
	DecodificaDiagnostica diagnostica;
	int diginput;
	int  analog;
	int digoutout;
	
	int lastindex =  0;
	
	List<Integer> diginputs = new ArrayList<>();
	List<DecodificaAnalogica> analogs = new ArrayList<>();
	List<Integer> digoutouts = new ArrayList<>();
	
	

	public MessageDiretto(byte[] range) {

		Address = String.format("%02x", range[0]);
		byte[] bitdiagnostica = Arrays.copyOfRange(range, 1, 5);
		
		diagnostica= new DecodificaDiagnostica(bitdiagnostica);
		
		diginput =  range[5]*8;
		analog = range[6];
		digoutout = range[7]*8;
		
		
		for(int i =0 ; i<(diginput/8); i++) {
			diginputs.add(new Integer(range[i+8]));
			
		}
		//DecodificaDigitalInputs esd = new DecodificaDigitalInputs(diginputs);
		int d = 0;
		for(int i =0 ; i<analog; i++) {
			byte[] win = Arrays.copyOfRange(range, (3*i)+(diginput/8)+8, (3*i)+(diginput/8)+8+3);
			//analogs.add(new Integer(range[i+diginput+8]));
			DecodificaAnalogica es = new DecodificaAnalogica(win);
			analogs.add(es);
			
		}
		int index = 0;
		for(int i =0 ; i<(digoutout/8); i++) {
			index = i+(diginput/8)+(analog*3)+8;
			digoutouts.add(new Integer(range[index]));
			
		}
		lastindex=  index;
		//dett4 = String.format("%02x", range[5]);
        //System.out.println();
       

	}



	

	public int getLastindex() {
		return lastindex;
	}





	@Override
	public String toString() {
		return (Address != null ? "Address: " + Address + ",  " : "")
				+ (diagnostica != null ? "bitdiagnostica: " + diagnostica + ",  " : "")
				+ "diginput: " + diginput + ",  analog: " + analog + ",  digoutout: " + digoutout + ",  "
				+ (diginputs != null ? "diginputs: " + new DecodificaDigitalInputs(diginputs) + ",  " : "")
				+ (analogs != null ? "analogs: " + System.lineSeparator() + analogs + ",  " : "")
				+ (digoutouts != null ? "digoutouts: " + new DecodificaDigitalOutput(digoutouts) + ",  " : "") + System.lineSeparator();
	}


	

	
	
}
