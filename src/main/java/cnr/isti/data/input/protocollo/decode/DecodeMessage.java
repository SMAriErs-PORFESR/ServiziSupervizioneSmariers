package cnr.isti.data.input.protocollo.decode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.annotation.JSONField;

import cnr.isti.data.input.protocollo.MessageWAD;
import cnr.isti.data.input.protocollo.MessageDiretto;
import cnr.isti.data.input.protocollo.MessageGroup;
import cnr.isti.data.input.protocollo.MessageLog;
import cnr.isti.data.input.protocollo.MessagePresenza;

public class DecodeMessage {

	private static Logger log = LogManager.getLogger(DecodeMessage.class);

	@JSONField(name = "ListMessage")
	List<MessageWAD> listamessaggi = new ArrayList<>();
	@JSONField(name = "ListaRealtime")
	List<MessageDiretto> lmd = new ArrayList<>();
	@JSONField(name = "ListamLog")
	List<MessageLog> listmlog = new ArrayList<>();
	@JSONField(name = "ListamGroup")
	List<MessageGroup> listmgroup = new ArrayList<>();

	public DecodeMessage(byte[] msg, Date date, byte tag, String add, String addper) {
		byte[] range = Arrays.copyOfRange(msg, 2, msg.length);
		int cicli = range.length / 11;
		int d = 0;
		//Presenza
		if (msg[0] == 0x0 & tag<=0x32) {
			MessagePresenza msp = new MessagePresenza(range, date, add,addper);
			log.info(msp);
		}
		
		//T_REQ_WARNING, T_REQ_ALARM, T_REQ_DATA
		if (msg[0] == 0x0 & tag>0x32) {

			for (int i = 1; i <= cicli; i++) {
				byte[] win = Arrays.copyOfRange(range, 11 * d, 11 * i);
				MessageWAD e = new MessageWAD(win);
				listamessaggi.add(e);
				d++;
			}
		}
		//T_REQ_GROUP_STD 
		if(msg[0] == 0x80) {
			int index = 0;
			while (index < range.length) {
				byte[] r = Arrays.copyOfRange(range, index, range.length);
				if (r.length > 10) {
					MessageGroup msggroup = new  MessageGroup (r);
					listmgroup.add(msggroup);
					index += msggroup.getLastindex() + 1;
				} else
					break;
			}
		}
		//T_REQ_DATA_LOG1
		if (msg[0] == 0x92) {
			for (int i = 1; i <= cicli; i++) {
				byte[] win = Arrays.copyOfRange(range, 11 * d, 11 * i);
				MessageLog mlog = new MessageLog(win);
				listmlog.add(mlog);
				d++;

			}
		}
		//T_REQ_BOARD_STD
		if (msg[0] == 0x74 & tag == 0x41) {
			int index = 0;
			while (index < range.length) {
				byte[] r = Arrays.copyOfRange(range, index, range.length);
				if (r.length > 10) {
					MessageDiretto md = new MessageDiretto(r, date);
					//String jsonOutput = JSON.toJSONString(md);
					//log.info(jsonOutput);
					lmd.add(md);
					index += md.getLastindex() + 1;

				} else
					break;
			}

		}

	}

	public List<MessageWAD> getListamessaggi() {
		return listamessaggi;
	}

	public void setListamessaggi(List<MessageWAD> listamessaggi) {
		this.listamessaggi = listamessaggi;
	}

	public List<MessageDiretto> getLmd() {
		return lmd;
	}

	public void setLmd(List<MessageDiretto> lmd) {
		this.lmd = lmd;
	}
	

	
	public List<MessageLog> getListmlog() {
		return listmlog;
	}

	public void setListmlog(List<MessageLog> listmlog) {
		this.listmlog = listmlog;
	}

	@Override
	public String toString() {
		return (listamessaggi != null ? "listamessaggi: " + listamessaggi + ",  " : "")
				+ (lmd != null ? "lmd: " + lmd + ",  " : "") + (listmlog != null ? "listmlog: " + listmlog : "");
	}

}
