package io;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class DataIO {
	
	public static String readFixedString(int size, DataInput in) 
			throws IOException {
		StringBuffer b = new StringBuffer(size);
		int i = 0;
		boolean more = true;
		while (more && i < size) {
			char ch = in.readChar();
		    i++;
		    if (ch == 0) more = false;
		    else b.append(ch);
		}
		in.skipBytes(2 * (size - i));
		return b.toString();
	}
	
	/*
	 * записывает указанное количество кодовых единиц, отсчитывая от начала символьной строки.
	 * (Если кодовых единиц слишком мало, символьная строка дополняется нулевыми значениями.)
	 */
	public static void writeFixedString(String s, int size, DataOutput out)
			throws IOException {
		//этот метод отбрасывает доп старших  8 бит
//		out.writeBytes(s);
		
		//добовляет доп символ в начале строки		
		//out.writeUTF(s);
	//	добовляется пробел к каждому символу
		int i;
		for (i = 0; i < size; i++) {  
			char ch = 0;
		    if (i < s.length())
		    	ch = s.charAt(i);
		    out.writeChar(ch);
        }
	}

}
