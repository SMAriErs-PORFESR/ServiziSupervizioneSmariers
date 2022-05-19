package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.decode.DecodificaDiagnostica;

public class MessageGroup {

    int lastindex = 0;
    
    @JSONField(name = "Address")
	String Address;
    @JSONField(name = "Diagnostica")
	DecodificaDiagnostica diagnostica;
    
    @JSONField(name = "NumGroup")
	int numgroup;
    @JSONField(name = "Groups")
	List<Integer> groups = new ArrayList<>();

	public MessageGroup(byte[] range) {

		Address = String.format("%02x", range[0]);
		byte[] bitdiagnostica = Arrays.copyOfRange(range, 1, 5);
		diagnostica= new DecodificaDiagnostica(bitdiagnostica);
		numgroup =  range[5];
		for(int i =1 ; i<numgroup; i++) {
			groups.add(new Integer(range[i+6]));
			
		}
		lastindex=  (numgroup)+6;

	}
	
	

	public int getLastindex() {
		return lastindex;
	}



	public String getAddress() {
		return Address;
	}



	public void setAddress(String address) {
		Address = address;
	}



	public DecodificaDiagnostica getDiagnostica() {
		return diagnostica;
	}



	public void setDiagnostica(DecodificaDiagnostica diagnostica) {
		this.diagnostica = diagnostica;
	}



	public int getNumgroup() {
		return numgroup;
	}



	public void setNumgroup(int numgroup) {
		this.numgroup = numgroup;
	}



	public List<Integer> getGroups() {
		return groups;
	}



	public void setGroups(List<Integer> groups) {
		this.groups = groups;
	}



	@Override
	public String toString() {
		return (Address != null ? "Address: " + Address + ",  " : "")
				+ (diagnostica != null ? "diagnostica: " + diagnostica + ",  " : "") + "numgroup: " + numgroup + ",  "
				+ (groups != null ? "groups: " + groups : "");
	}

	


	

}
