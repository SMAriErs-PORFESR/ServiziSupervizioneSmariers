package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import cnr.isti.data.input.protocollo.util.Service;

public class DecodificaAnalogica {
	
	int tipo;
	int canale;
	int segno;
	long valore;
	
	public DecodificaAnalogica(byte[] msg) {
		byte spacca = msg[0];
		tipo = Service.bitExtracted(spacca, 1, 1);
		segno = Service.bitExtracted(spacca, 1, 8);
		canale = Service.bitExtracted(spacca, 6, 2);
		byte[] v = Arrays.copyOfRange(msg, 1, 3);

		valore = Service.TwobytesToLong(v);
		
		//System.out.println();
		
	}

	@Override
	public String toString() {
		return System.lineSeparator() +"tipo: " + tipo + ",  canale: " + TableAnalog.getDesc(canale) + ",  segno: " + segno + ",  valore: " + valore ;
	}

	
	
	

}
