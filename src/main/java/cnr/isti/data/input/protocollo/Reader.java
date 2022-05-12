package cnr.isti.data.input.protocollo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

import org.apache.logging.log4j.Logger;
import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;

import cnr.isti.data.input.protocollo.decode.DecodeMessage;
import cnr.isti.data.input.protocollo.decode.EsitiScarico;
import cnr.isti.data.input.protocollo.util.Service;

public class Reader {
	
	DecodeMessage dm ;

	private static Logger log = LogManager.getLogger(Reader.class);

	String STX; // 1 0x14 inizio messaggio

	String ADD_CD; // 1 da 1 a 254 indirizzo CD (default = 1)

	String ADD_CD_NEG; // 1 negato di ADD_CD indirizzo CD negato

	String ADD_PER; // 1 da 1 a 254 indirizzo Periferica

	String ADD_PER_NEG; // 1 negato di ADD_PER indirizzo Periferica negato

	String TAG; // 1 Da 0x00 a 0xFF Tipologia pacchetto

	long TIME_INFO; // 4 Data/Ora Informazione data

	int LEN; // 2 Da 0 a 15 Identificativo seriale (direttrice) fisica o logica CD

	int IDSERIAL;

	String c; // da 2 a 2033 dati

	String CRC16; // 2 codice per la rilevazione d’errore

	String ETX; // 1 0x17 fine messaggio

	public void Read(byte[] message) throws IOException {
		STX = String.format("%02x", (message[0]));// 1
		ADD_CD = String.format("%02x", (message[1]));// 1
		ADD_CD_NEG = String.format("%02x", (message[2]));// 1
		ADD_PER = String.format("%02x", (message[3]));// 1
		ADD_PER_NEG = String.format("%02x", (message[4]));// 1
		TAG = String.format("%02x", (message[5]));// 1

		byte[] Time = Arrays.copyOfRange(message, 6, 10);// 4
		TIME_INFO = Service.bytesToLong(Time);
		Service.getTime(TIME_INFO);

		int len1 = message[10] & 0xff;// 1

		byte len2 = message[11];// 1

		int lowNibble = len2 & 0x0f;
		int highNibble = len2 >>> 4;
		
		byte [] v =  { message[10],(byte) lowNibble};
		
		//byte [] v1 =  {(byte) lowNibble, message[10], 0, 0 };
		LEN = Service.TwobytesToint(v) ;

		IDSERIAL = lowNibble;

		int fine = 12 + LEN;

		byte[] msg = Arrays.copyOfRange(message, 12, fine);// 2 + LEN Max 2033

		if (msg.length > 10) {
			this.readmsg(msg,Service.getDateTime(TIME_INFO),(message[5]) );
		}

		String hex = Hex.encodeHexString(msg);
		if (hex.length() < 5) {
			int esito = Integer.parseInt(hex, 16);

			EsitiScarico es = EsitiScarico.getEsitiScarico(esito);
		}
		int last = fine + 2;

		byte[] crc = Arrays.copyOfRange(message, fine, last);// 2

		byte[] var = Arrays.copyOfRange(message, 1, fine);//

		int CRC_Calcolato = Service.CRC(var);
		byte[] recCRC = Service.intToBytes(CRC_Calcolato);
		if (Arrays.equals(recCRC, crc)) {
			log.info("CRC OK");
		} else {
			log.info("CRC KO");
		}

		log.info(CRC_Calcolato);

		byte fnl = message[2 + LEN + 4]; // 1

	}

	private void readmsg(byte[] msg, Date d , byte tag) {

		dm = new DecodeMessage(msg, d, tag);
		log.info(dm);
	/*	byte[] range = Arrays.copyOfRange(msg, 2, msg.length);

		String ind = String.format("%02x", range[0]);
		String cod = String.format("%02x", range[1]);
		String dett1 = String.format("%02x", range[2]);
		String dett2 = String.format("%02x", range[3]);
		String dett3 = String.format("%02x", range[4]);
		String dett4 = String.format("%02x", range[5]);
		long d = Service.bytesToLong(Arrays.copyOfRange(range, 6, 10));
		String data = Service.getTime(d);
		int cent = range[10];*/
		//System.out.println("End");
	}

	
	
	public DecodeMessage getDm() {
		return dm;
	}

	public void setDm(DecodeMessage dm) {
		this.dm = dm;
	}

	@Override
	public String toString() {
		return (STX != null ? "STX: " + STX + ",  " : "") + (ADD_CD != null ? "ADD_CD: " + ADD_CD + ",  " : "")
				+ (ADD_CD_NEG != null ? "ADD_CD_NEG: " + ADD_CD_NEG + ",  " : "")
				+ (ADD_PER != null ? "ADD_PER: " + ADD_PER + ",  " : "")
				+ (ADD_PER_NEG != null ? "ADD_PER_NEG: " + ADD_PER_NEG + ",  " : "")
				+ (TAG != null ? "TAG: " + TAG + ",  " : "") + "TIME_INFO: " + Service.getTime(TIME_INFO) + ",  LEN: " + LEN
				+ ",  IDSERIAL: " + IDSERIAL + ",  " + (c != null ? "c: " + c + ",  " : "")
				+ (CRC16 != null ? "CRC16: " + CRC16 + ",  " : "") + (ETX != null ? "ETX: " + ETX : "")+ System.lineSeparator();
	}
	
	

}
