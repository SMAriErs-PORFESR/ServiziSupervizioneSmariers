package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaDigitalOutput {
	
	
	@JSONField(name = "Outputs")
	List<Triple<String, Boolean, Integer>>  Outputs = new ArrayList<Triple<String, Boolean, Integer>>();

	public DecodificaDigitalOutput(List<Integer> diginputs) {
		int  k = 1;
		for (Integer i : diginputs) {
			for (int d = 1; d <= 8; d++) {
				int result = Service.bitExtracted(i, 1, d);
				if (result == 0) {
					Outputs.add(new Triple( TableDigitalOutput.getDesc(k),new Boolean(false),k));
				} else {
					Outputs.add(new Triple( TableDigitalOutput.getDesc(k),new Boolean(true),k));
				}
				k++;
			}
			
		}
	}

	@Override
	public String toString() {
		String stringa = "[";
		for (Triple<String, Boolean, Integer> triple : Outputs) {
			
			stringa+=  ""+triple.getT()+","+triple.getV()+","+triple.getZ()+System.lineSeparator();
		}
		return stringa+"]";
	}

	public List<Triple<String, Boolean, Integer>> getOutputs() {
		return Outputs;
	}

	public void setOutputs(List<Triple<String, Boolean, Integer>> outputs) {
		Outputs = outputs;
	}

	

	
	

}
