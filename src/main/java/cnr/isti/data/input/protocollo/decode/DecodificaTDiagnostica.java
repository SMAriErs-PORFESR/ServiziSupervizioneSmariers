package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.config.LoadTable;
import cnr.isti.data.input.protocollo.Triple;
import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaTDiagnostica {

	@JSONField(name = "List")
	List<Triple<String, Integer, Integer>> Diagnostica = new ArrayList<Triple<String, Integer, Integer>>();
	

	public DecodificaTDiagnostica(byte[] diginputs, byte  address) {
		int k = 1;
		LoadTable lt = new LoadTable(); 
		for (int i = 0; i < diginputs.length; i++) {
			for (int d = 1; d <= 8; d++) {
				int result = Service.bitExtracted(diginputs[i], 1, d);
				Diagnostica.add(new Triple<String, Integer, Integer>( lt.getDiagnosticaDesc(address, k) ,result,k));
				/*if (result == 0) {
					Inputs.add(new Triple( TableDigitalInput.getDesc(k) ,new Boolean(false), k));
				} else {
					Inputs.add(new Triple( TableDigitalInput.getDesc(k) ,new Boolean(true),k ));
				}*/
				
				k++;
			}

		}
	}
	
	
	





	public List<Triple<String, Integer, Integer>> getDiagnostica() {
		return Diagnostica;
	}








	public void setDiagnostica(List<Triple<String, Integer, Integer>> diagnostica) {
		Diagnostica = diagnostica;
	}








	@Override
	public String toString() {
		String stringa = "[";
		for (Triple<String, Integer, Integer> triple : Diagnostica) {
			
			stringa+=  ""+triple.getT()+","+triple.getV()+","+triple.getZ()+System.lineSeparator();
		}
		return stringa+"]";
	}
		
	

}
