package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaDigitalInputs {

	@JSONField(name = "Inputs")
	List<Triple<String, Boolean, Integer>> Inputs = new ArrayList<Triple<String, Boolean, Integer>>();
	

	public DecodificaDigitalInputs(List<Integer> diginputs) {
		for (Integer i : diginputs) {
			for (int d = 1; d <= 8; d++) {
				int result = Service.bitExtracted(i, 1, d);
				if (result == 0) {
					Inputs.add(new Triple( TableDigitalInput.getDesc(i) ,new Boolean(false), i));
				} else {
					Inputs.add(new Triple( TableDigitalInput.getDesc(i) ,new Boolean(true),i ));
				}
			}

		}
	}
	
	

	



	@Override
	public String toString() {
		return (Inputs != null ? "Inputs: " + Inputs : "");
	}







	public List<Triple<String, Boolean, Integer>> getInputs() {
		return Inputs;
	}







	public void setInputs(List<Triple<String, Boolean, Integer>> inputs) {
		Inputs = inputs;
	}



		
	

}
