package string;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringConstruction {
//Стринг
	public static void main(String[] args) throws UnsupportedEncodingException {
		int[] i = {0x4521,0xFF19,0xFF14,0xFF10,0x0039};
		char[] ch = {'f','F','f','F'}; 
		char[] ch2 = Character.toChars(0xFF19);
		char[] ch3 = Character.toChars(0x10FFD1);
		byte[] b = new byte[]{2,35,74,85,113,127,-105,-23};
		byte[] b2;
		StringBuilder sb = new StringBuilder();
		sb.append(ch);
		String str0 = "a";
		String str = new String(ch);
		String str1 = new String(sb);
		String str2 = new String(i,0,5);
		String str3 = new String(ch2);
		String str5 = new String(ch3);
		String str4 = new String(b);
		System.out.println(str + " " + str1 + " " + str2 + " " + str3 + " " + str4);	
		System.out.println(str3.codePointAt(0));
		System.out.println(str5.codePointAt(0) + " " +  str5.length());
		char[] ch4 = new char[5];
		str.getChars(0, 2, ch4, 3);
		System.out.println(ch4);
		b2 = str.getBytes();
		System.out.println(Arrays.toString(b2));
		String eqStr =  " ";
		String eqStr1 = null;
		System.out.println(eqStr.equals(sb));
		System.out.println(eqStr1.concat(eqStr));
		
		
		
		
	}

}
