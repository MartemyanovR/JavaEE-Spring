package io.writerReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseFile {
	
	public static void main(String[] args) {
		File file = new File("C:\\eclipse-workspace\\logTest.txt");
		
		try(BufferedReader br  = new BufferedReader( new FileReader(file));
				FileWriter bw = new FileWriter(file, true)) { 
			String part;
			StringBuilder sb = new StringBuilder();			
			while((part = br.readLine()) != null) {
				System.out.println(part);
				char[] copyStr = part.toCharArray();
				char[] ch = new char[part.length()];									
				int low = 0;
				for(int i = 0; i < part.length(); i++) {			
					if(!Character.isLetterOrDigit(copyStr[i]) || i+1 == part.length()) {
						int n=low;
						for(int j = i-1; j>=n ; j--) {
							ch[low++] = copyStr[j];
						}
						ch[low++] = copyStr[i];
					}
				}	
				sb.append(String.copyValueOf(ch)+"\n");
			}			
			System.out.println("\n"+sb);
			
			bw.write(new String(sb));
		} catch (FileNotFoundException  e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}

		
	/*	try(FileReader fr = new FileReader(file);
				BufferedReader br  = new BufferedReader(fr)) {
			String part;
			StringBuilder sb = new StringBuilder();
			while((part = br.readLine()) != null) {
				System.out.println(part);
				sb.append(part + "\n");				
			}			
			System.out.println("\n" + sb.reverse());
			
			
			
		} catch (FileNotFoundException  e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		*/
		}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	String s = "1234,56789,7654 4545315.3/213,.12345678 12345 ";		
char[] copyStr = s.toCharArray();
char[] ch = new char[s.length()];	
int low = 0;
for(int i = 0; i < s.length(); i++) {			
	if(!Character.isLetterOrDigit(copyStr[i]) || i+1 == s.length()) {
		int n=low;
		for(int j = i-1; j>=n ; j--) {
			ch[low++] = copyStr[j];
		}
		ch[low++] = copyStr[i];
	}
}	
s = String.copyValueOf(ch);
System.out.println(s);
*/

}
