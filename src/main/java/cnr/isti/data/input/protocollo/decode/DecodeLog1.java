package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cnr.isti.data.input.protocollo.MessageLog;

public class DecodeLog1 {

	List<MessageLog> listmlog = new ArrayList<>();

	/**
	 * 
	 */
	public DecodeLog1(byte[] range) {
		int cicli = range.length / 11;
		int d = 0;

		for (int i = 1; i <= cicli; i++) {
			byte[] win = Arrays.copyOfRange(range, 11 * d, 11 * i);
			MessageLog mlog = new MessageLog(win);
			listmlog.add(mlog);
			d++;

		}
	}

}
