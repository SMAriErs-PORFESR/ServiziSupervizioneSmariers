package cnr.isti.data.input.protocollo.util;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Base64;

//import javax.xml.bind.DatatypeConverter;

public class Service {

	public static void CRC(String message) {
		int crc = 0xFFFF; // initial value
		int polynomial = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)

		// byte[] testBytes = "123456789".getBytes("ASCII");

		byte[] bytes = message.getBytes();

		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i) & 1) == 1);
				boolean c15 = ((crc >> 15 & 1) == 1);
				crc <<= 1;
				if (c15 ^ bit)
					crc ^= polynomial;
			}
		}

		crc &= 0xffff;
		System.out.println("CRC16-CCITT = " + Integer.toHexString(crc));
	}

	public static int CRC(byte[] bytes) {
		int crc = 0x00; // initial value
		int polynomial = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)

		// byte[] testBytes = "123456789".getBytes("ASCII");

		for (byte b : bytes) {
			for (int i = 0; i < 8; i++) {
				boolean bit = ((b >> (7 - i) & 1) == 1);
				boolean c15 = ((crc >> 15 & 1) == 1);
				crc <<= 1;
				if (c15 ^ bit)
					crc = (crc) ^ polynomial;
			}
		}

		crc &= 0xffff;
		System.out.println("CRC16-CCITT = " + crc + " " + Integer.toHexString(crc));
		return crc;
	}

	public static int bitExtracted(int number, int k, int p) {
		return (((1 << k) - 1) & (number >> (p - 1)));
	}

	public static String getTime(long time) {
		Instant epoch = Instant.parse("2000-01-01T00:00:00.00Z");
		Instant later = epoch.plusSeconds(time);

		ZoneOffset offset = ZoneOffset.of("+01:00");

		OffsetDateTime odt = later.atOffset(offset);

		// LocalDate ld = odt.toLocalDate() ;
		// Times = later.getEpochSecond();
		// Date Datas = Date.from(later);
		// log.info("datas"+Datas);

		long Timestamp = odt.toInstant().toEpochMilli();
		Timestamp ts = new Timestamp(Timestamp);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		// System.out.println(formatter.format(ts));

		return formatter.format(ts);
	}

	public static final byte[] integerToTwoBytes(int value) throws IOException {
		byte[] result = new byte[2];
		if ((value > Math.pow(2, 31)) || (value < 0)) {
			throw new IOException("Integer value " + value + " is larger than 2^31");
		}
		result[0] = (byte) ((value >>> 8) & 0xFF);
		result[1] = (byte) (value & 0xFF);
		return result;
	}

	public static byte[] intToBytes(int x) {
		byte[] bytes = new byte[2];

		for (int i = 0; x != 0; i++, x >>>= 8) {
			bytes[i] = (byte) (x & 0xFF);
		}

		return bytes;
	}

	public static int CRCE(byte[] list) {
		int iCRC = 0x0000;
		for (int t = 0; t < list.length; t++) {
			iCRC = CRCECM(iCRC, list[t]);
		}

		return iCRC;
	}

	public static int CRCECM(int iCRC, int iNew_val) {
		// initial value
		int MTT = 0x1021; // 0001 0000 0010 0001 (0, 5, 12)

		iNew_val <<= 8;
		for (int sLoopCRC = 0; sLoopCRC < 8; sLoopCRC++) {
			if (((iCRC ^ iNew_val) & 0x8000) != 0) {
				iCRC = (iCRC << 1) ^ MTT;
			} else {
				iCRC <<= 1;
			}

			iNew_val <<= 1;
		}

		return iCRC;
	}

	public static String getMacString(byte[] macAddress) {
		StringBuilder retval = new StringBuilder(17);

		boolean isFirst = true;
		for (byte b : macAddress) {
			if (!isFirst) {
				// retval.append(":");
			} else {
				isFirst = false;
			}
			retval.append(String.format("%02x", b & 0xff));
		}
		return retval.toString();
	}

	public static short bytesToShort(byte[] bytes) {
		return (short) (ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getShort() & 0xFFL); // & 0xFF
	}

	public static short bytesToInt(byte[] bytes) {
		return (short) (ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFF);
	}

	public static short byteToInt(byte[] byt) {
		byte[] bytes = { byt[0], 0, 0, 0 };
		return (short) (ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFF);
	}

	public static long bytesToLong(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt() & 0xFFFFFFFFL;

	}
	
	public static long bytesToLong2(byte[] bytes) {
		byte[] k = { bytes[0], bytes[1],  bytes[2],  bytes[3],0,0, 0, 0 };
		return ByteBuffer.wrap(k).order(ByteOrder.LITTLE_ENDIAN).getLong();

	}

	public static float bytesToFloat(byte[] bytes) {
		return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getFloat();

	}

	public static byte[] longToByteArray(final long i) {

		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.putLong(0, i).order(ByteOrder.LITTLE_ENDIAN);
		buffer.flip();

		return buffer.array();

	}

	public static byte[] longToByte(long value) {
		byte[] data = new byte[4];
		data[3] = (byte) (value >>> 24);
		data[2] = (byte) (value >>> 16);
		data[1] = (byte) (value >>> 8);
		data[0] = (byte) (value);

		return data;
	}

	public static int TwobytesToint(byte[] bytes) {
		byte[] k = { bytes[0], bytes[1], 0, 0 };
		int l = (ByteBuffer.wrap(k).order(ByteOrder.LITTLE_ENDIAN).getInt() /* & 0xFFFFFF */);
		return l;
	}
	
	public static int TwobytesTointb(byte[] bytes) {
		byte[] k = { bytes[1], bytes[0], 0, 0 };
		int l = (ByteBuffer.wrap(k).order(ByteOrder.LITTLE_ENDIAN).getInt() /* & 0xFFFFFF */);
		return l;
	}

	public static float TwobytesToFloat(byte[] bytes) {
		byte[] k = { bytes[0], bytes[1], 0, 0 };
		float l = ByteBuffer.wrap(k).order(ByteOrder.LITTLE_ENDIAN).getFloat();
		return l;
	}
	
	public static long TwobytesToLong(byte[] bytes) {
		byte[] k = { bytes[0], bytes[1], 0, 0,0,0 ,0,0};
		long l = ByteBuffer.wrap(k).order(ByteOrder.LITTLE_ENDIAN).getLong();
		return l;
	}

	public static byte[] getBytefromBase64(String in) {

		return Base64.getDecoder().decode(in);

	}

	public static byte[] toByteArray(String s) {
		return new byte[22]; // DatatypeConverter.parseHexBinary(s);
	}
	/*
	 * for (byte b : bytes) { for (int i = 0; i < 8; i++) { boolean bit = ((b >>
	 * (7-i) & 1) == 1); boolean c15 = ((crc >> 15 & 1) == 1); crc <<= 1; if (c15 ^
	 * bit) crc ^= polynomial; } }
	 * 
	 * crc &= 0xffff; System.out.println("CRC16-CCITT = " + crc); return
	 * Integer.toHexString(crc); }
	 */

	public static byte[] parseMacAddress(String macAddress) {
		String[] bytes = splitInEqualParts(macAddress, 6);
		byte[] parsed = new byte[bytes.length];

		for (int x = 0; x < bytes.length; x++) {
			BigInteger temp = new BigInteger(bytes[x], 16);
			byte[] raw = temp.toByteArray();
			parsed[x] = raw[raw.length - 1];
		}
		return parsed;
	}

	private static String[] splitInEqualParts(final String s, final int n) {
		if (s == null) {
			return null;
		}
		final int strlen = s.length();
		if (strlen < n) {
			// this could be handled differently
			throw new IllegalArgumentException("String too short");
		}
		final String[] arr = new String[n];
		final int tokensize = strlen / n + (strlen % n == 0 ? 0 : 1);
		for (int i = 0; i < n; i++) {
			arr[i] = s.substring(i * tokensize, Math.min((i + 1) * tokensize, strlen));
		}
		return arr;
	}

	public static long getTimes() {

		Instant epoch = Instant.parse("2000-01-01T00:00:00.00Z");
		Instant timetosend = Instant.now().minusSeconds(epoch.getEpochSecond());

		ZoneOffset offset = ZoneOffset.of("+00:00");

		OffsetDateTime odt = timetosend.atOffset(offset);

		return odt.toInstant().getEpochSecond(); // timetosend.getEpochSecond();
	}
}
