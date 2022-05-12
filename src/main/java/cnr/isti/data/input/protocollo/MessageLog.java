package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import cnr.isti.data.input.protocollo.decode.DecodificaAnalogica;
import cnr.isti.data.input.protocollo.util.Service;

public class MessageLog {

	String ind;
	DecodificaAnalogica idcanale;
	String valore;
	long data;
	int cent;

	/**
	 * 
	 */
	public MessageLog(byte[] range) {
		ind = String.format("%02x", range[0]);
		byte[] cod = Arrays.copyOfRange(range, 1, 6);

		idcanale = new DecodificaAnalogica(cod);

		byte[] Time = Arrays.copyOfRange(range, 6, 10);// 4
		data = Service.bytesToLong(Time);
		// Service.getTime(TIME_INFO);
		cent = range[10];

	}

	public String getData() {
		return Service.getTime(data);
	}

	@Override
	public String toString() {
		return (ind != null ? "ind: " + ind + ",  " : "") + (idcanale != null ? "idcanale: " + idcanale + ",  " : "")
				+ (valore != null ? "valore: " + valore + ",  " : "") + "data: " + data + ",  cent: " + cent;
	}

}
