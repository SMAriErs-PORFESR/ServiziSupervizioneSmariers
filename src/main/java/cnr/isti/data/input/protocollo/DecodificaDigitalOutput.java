package cnr.isti.data.input.protocollo;

import java.util.ArrayList;
import java.util.List;

import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaDigitalOutput {

	List<Boolean> Output = new ArrayList<>();

	public DecodificaDigitalOutput(List<Integer> diginputs) {
		for (Integer i : diginputs) {
			for (int d = 1; d <= 8; d++) {
				int result = Service.bitExtracted(i, 1, d);
				if (result == 0) {
					Output.add(new Boolean(false));
				} else {
					Output.add(new Boolean(true));
				}
			}

		}
	}

	@Override
	public String toString() {
		String result = System.lineSeparator();
		int i = 1;
		for(Boolean b: Output) {
			result+= "["+TableDigitalOutput.getDesc(i)+" : "+b.toString()+"]"+System.lineSeparator();
			i++;
		}
		return result;
	}
	
	

}
