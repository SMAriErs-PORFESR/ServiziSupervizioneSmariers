package cnr.isti.data.input.protocollo;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Hex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cnr.isti.data.input.protocollo.util.Service;



public class Request {

	private static Logger log = LogManager.getLogger(Request.class);
	// REQUEST DATA

	byte STX = 0x14;

	byte ADD_CD = 0x00;

	byte ADD_CD_NEG = (byte) ~(int) ADD_CD;

	byte ADD_PER = 0x00;

	byte ADD_PER_NEG = 0x00;

	byte TAG = 0x31;

	long TIME = Service.getTimes();

	byte[] TIME_INFO = Service.longToByte(TIME);

	byte[] len = { 0x02, 0x40 };

	byte[] MSG = { 0x0, 0x0 };

	byte[] CRC;

	byte EXT = 0x17;

	public byte[] getPresenzaDati(byte Address, byte AddressPeriferica) {

		byte tag = 0x31;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x0, 0x0 });
	}

	public byte[] get_T_REQ_Data(byte Address, byte AddressPeriferica) {

		byte tag = 0x33;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_CRL_Frame(byte Address, byte AddressPeriferica) {

		byte tag = 0x35;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_REQ_Alarm(byte Address, byte AddressPeriferica) {

		byte tag = 0x36;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_CRL_Alarm(byte Address, byte AddressPeriferica) {

		byte tag = 0x38;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_REQ_Warning(byte Address, byte AddressPeriferica) {

		byte tag = 0x50;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_CRL_Warning(byte Address, byte AddressPeriferica) {

		byte tag = 0x52;
		return getDati(Address, AddressPeriferica, tag, new byte[] { 0x00, 0x00 });
	}

	public byte[] get_T_REQ_DATALOG1(byte Address, byte AddressPeriferica) {

		byte tag = 0x39;
		byte[] msg = new byte[] {(byte) 0x92, 0x00 };
		return getDati(Address, AddressPeriferica, tag, msg);
	}

	public byte[] get_T_CRL_FRAMELOG1(byte Address, byte AddressPeriferica) {

		byte tag = 0x43;
		byte[] msg = new byte[] {(byte) 0x93, 0x00 };
		return getDati(Address, AddressPeriferica, tag, msg);
	}
	
	public byte[] get_T_REQ_GROUP_STD(byte Address, byte AddressPeriferica) {

		byte tag = 0x39;
		byte[] msg = new byte[] {(byte) 0x80, 0x00, (byte)0xff,0x00 };
		return getDati(Address, AddressPeriferica, tag, msg);
	}
	
	public byte[] get_T_REQ_BOARD_STD(byte Address, byte AddressPeriferica) {

		byte tag = 0x39;
		byte[] msg = new byte[] {(byte) 0x74, 0x00, (byte)0xff,0x00 };
		return getDati(Address, AddressPeriferica, tag, msg);
	}

	private byte[] getDati(byte Address, byte AddressPeriferica, byte tag, byte[] msg) {

		STX = 0x14;

		ADD_CD = Address;

		ADD_CD_NEG = (byte) ~(int) ADD_CD;

		ADD_PER = AddressPeriferica;

		ADD_PER_NEG = (byte) ~(int) ADD_PER;

		TAG = tag;

		TIME = Service.getTimes();

		TIME_INFO = Service.longToByte(TIME);// new byte[] {0x0,0x0,0x0,0x0} ;//
		
		len[0] = (byte) msg.length;

		MSG = msg;

		try {
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			// outputStream.write( STX );
			outputStream.write(ADD_CD);
			outputStream.write(ADD_CD_NEG);
			outputStream.write(ADD_PER);
			outputStream.write(ADD_PER_NEG);
			outputStream.write(TAG);
			outputStream.write(TIME_INFO);
			outputStream.write(len);
			outputStream.write(MSG);

			byte[] var = outputStream.toByteArray();

			int Calc_CRC = Service.CRC(var);

			byte[] recCRC = Service.intToBytes(Calc_CRC);// = Service.integerToTwoBytes(Calc_CRC);

			// byte[] fd =
			// Service.integerToTwoBytes(ByteBuffer.wrap(recCRC).order(ByteOrder.LITTLE_ENDIAN).getShort());

			outputStream.write(recCRC);
			outputStream.write(EXT);

			ByteArrayOutputStream finaloutputStream = new ByteArrayOutputStream();
			finaloutputStream.write(STX);
			finaloutputStream.write(outputStream.toByteArray());

			byte[] finalmessage = finaloutputStream.toByteArray();

			log.info(Hex.encodeHexString(finalmessage));

			return finalmessage;

		} catch (Exception e) {
			// TODO: handle exception

			return null;
		}

	}

}
