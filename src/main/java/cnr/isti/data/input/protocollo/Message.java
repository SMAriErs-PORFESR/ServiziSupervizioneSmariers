package cnr.isti.data.input.protocollo;

import java.util.Arrays;

import cnr.isti.data.input.protocollo.util.Service;

public class Message {

	String ind;
	String cod;
	String dett1;
	String dett2;
	String dett3;
	String dett4;
	long data;
	int cent;

	public Message(byte[] range) {

		ind = String.format("%02x", range[0]);
		cod = String.format("%02x", range[1]);
		dett1 = String.format("%02x", range[2]);
		dett2 = String.format("%02x", range[3]);
		dett3 = String.format("%02x", range[4]);
		dett4 = String.format("%02x", range[5]);
		data = Service.bytesToLong(Arrays.copyOfRange(range, 6, 10));

		cent = range[10];

	}

	public String getData() {
		return Service.getTime(data);
	}

	@Override
	public String toString() {
		return (ind != null ? "ind=" + ind + ", " : "") + (cod != null ? "cod=" + cod + ", " : "")
				+ (dett1 != null ? "dett1=" + dett1 + ", " : "") + (dett2 != null ? "dett2=" + dett2 + ", " : "")
				+ (dett3 != null ? "dett3=" + dett3 + ", " : "") + (dett4 != null ? "dett4=" + dett4 + ", " : "")
				+ "data=" + Service.getTime(data) + ", cent=" + cent + System.lineSeparator();
	}

}
