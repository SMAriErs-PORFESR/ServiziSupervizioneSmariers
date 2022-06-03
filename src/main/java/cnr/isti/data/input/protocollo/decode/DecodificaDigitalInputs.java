package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.config.LoadTableIO;
import cnr.isti.data.input.protocollo.Triple;
import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaDigitalInputs {

	@JSONField(name = "Inputs")
	List<Triple<String, Integer, Integer>> Inputs = new ArrayList<Triple<String, Integer, Integer>>();
	

	public DecodificaDigitalInputs(byte address, List<Integer> diginputs) {
		int k = 1;
		LoadTableIO io = new LoadTableIO();
		 Map<String, String> listinput = io.getTable(address, 1);
		for (Integer i : diginputs) {
			for (int d = 1; d <= 8; d++) {
				int result = Service.bitExtracted(i, 1, d);
				Inputs.add(new Triple<String, Integer, Integer>( listinput.get(k) ,result, k));
				/*if (result == 0) {
					Inputs.add(new Triple( TableDigitalInput.getDesc(k) ,new Boolean(false), k));
				} else {
					Inputs.add(new Triple( TableDigitalInput.getDesc(k) ,new Boolean(true),k ));
				}*/
				
				k++;
			}

		}
	}
	
	






	public List<Triple<String, Integer, Integer>> getInputs() {
		return Inputs;
	}







	public void setInputs(List<Triple<String, Integer, Integer>> inputs) {
		Inputs = inputs;
	}


	@Override
	public String toString() {
		String stringa = "[";
		for (Triple<String, Integer, Integer> triple : Inputs) {
			
			stringa+=  ""+triple.getT()+","+triple.getV()+","+triple.getZ()+System.lineSeparator();
		}
		return stringa+"]";
	}
		
	

}
