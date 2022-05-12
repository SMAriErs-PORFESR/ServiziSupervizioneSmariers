package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson2.JSON;

import cnr.isti.data.input.protocollo.Message;
import cnr.isti.data.input.protocollo.MessageDiretto;

public class DecodeMessage {

	List<Message> listamessaggi = new ArrayList<>();
	List<MessageDiretto> lmd = new ArrayList<>();

	public DecodeMessage(byte[] msg, Date date) {
		byte[] range = Arrays.copyOfRange(msg, 2, msg.length);

		int cicli = range.length / 11;
		int d = 0;

		if (msg[0] == 0x0) {
			for (int i = 1; i <= cicli; i++) {
				byte[] win = Arrays.copyOfRange(range, 11 * d, 11 * i);
				Message e = new Message(win);
				listamessaggi.add(e);
				d++;
			}
		}
		
		if (msg[0] == 0x74) {
			int index = 0;
			while (index<range.length) {
				byte[] r = Arrays.copyOfRange(range, index  , range.length );
				if(r.length>10) {
				MessageDiretto md = new MessageDiretto(r, date);
				String jsonOutput= JSON.toJSONString(md);
				System.out.println(jsonOutput);
				lmd.add(md);
				index += md.getLastindex()+1;
        	
		        	
		        }else break;
			}
			
		}
		

	}

	@Override
	public String toString() {
		return (listamessaggi != null ? "listamessaggi: " + listamessaggi + ",  " : "")
				+ (lmd != null ? "lmd: " + lmd : "");
	}

	

	

}
