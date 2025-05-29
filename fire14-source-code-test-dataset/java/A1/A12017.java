

import java.io.IOException;
import java.io.InputStream;

public class Input {

	static final int BUFFER_SIZE = 65535;
	static final int STRING_SIZE = 1024;

	InputStream in;
	byte[] buffer;
	byte[] strBuffer;
	int pos;

	public Input(InputStream in) {
		this.in = in;
		this.buffer = new byte[BUFFER_SIZE];
		this.strBuffer = new byte[STRING_SIZE];
		this.pos = BUFFER_SIZE;
	}

	void skipWhitespace() throws IOException {
		byte b;
		do {
			b = readByte();
		} while (b <= ' ');
		--pos;
	}

	public byte readByte() throws IOException {
		if (pos == BUFFER_SIZE) {
			in.read(buffer);
			pos = 0;
		}
		return buffer[pos++];
	}

	public int readInt() throws IOException {
		skipWhitespace();
		int number = 0;
		int digit = readByte();
		int sign = 1;
		if (digit == '-') {
			sign = -1;
		} else {
			number = digit - '0';
		}

		digit = readByte();
		while (digit >= '0') {
			number *= 10;
			number += digit - '0';
			digit = readByte();
		}

		return sign * number;
	}

	public long readLong() throws IOException {
		skipWhitespace();
		long number = 0;
		int digit = readByte();
		int sign = 1;
		if (digit == '-') {
			sign = -1;
		} else {
			number = digit - '0';
		}

		digit = readByte();
		while (digit >= '0') {
			number *= 10;
			number += digit - '0';
			digit = readByte();
		}

		return sign * number;
	}
	
	public double readDouble() throws IOException {
		skipWhitespace();
		double number = 0;
		int digit = readByte();
		double sign = 1;
		if (digit == '-') {
			sign = -1;
		} else {
			number = digit - '0';
		}

		digit = readByte();
		while (digit >= '0') {
			number *= 10;
			number += digit - '0';
			digit = readByte();
		}
		if (digit == '.' || digit == ',') {
			digit = readByte();
			double remainder = 0;
			int depth = 0;
			while (digit >= '0') {
				remainder *= 10;
				remainder += digit - '0';
				depth++;
				digit = readByte();
			}
			if (depth == 1) {
				number += remainder / 10;
			} else {
				number += remainder / (Math.pow(10, depth));
			}

		}
		return sign * number;
	}
	public String readString() throws IOException {
		skipWhitespace();
		int length = 0;
		do {
			strBuffer[length++] = readByte();
		} while (strBuffer[length - 1] > ' ');
		return new String(strBuffer, 0, length - 1);
	}

}
