package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cnr.isti.data.input.protocollo.util.Service;

public class MessageGroup {

	String Address;
	byte[] bitdiagnostica;
	int numgroup;
	List<Integer> groups = new ArrayList<>();

	public MessageGroup(byte[] range) {

		Address = String.format("%02x", range[0]);
		bitdiagnostica = Arrays.copyOfRange(range, 1, 5);
		numgroup =  range[6];
		for(int i =1 ; i<numgroup; i++) {
			groups.add(new Integer(range[i+6]));
			
		}

	}


	

}
