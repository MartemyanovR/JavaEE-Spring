package io;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {

		
		try (RandomAccessFile in = new RandomAccessFile("C://eclipse-workspace//README.txt","r")){
			
			int i = (int)in.length();
			byte[] b = new byte[i];
			//in.skipBytes(1);
			in.readFully(b,3,b.length-9);
			String srt = new String(b);
			System.out.println(srt);
			
		}
	/*	
		
		EmployeeIO[] staff = new EmployeeIO[3];		
		 staff[0] = new EmployeeIO("Carl Cracker", 75000, 1987, 12, 15);
		 staff[1] = new EmployeeIO("Harry Hacker", 50000, 1989, 10, 1);
		 staff[2] = new EmployeeIO("Tony Tester", 40000, 1990, 3, 15);
		
		 try (DataOutputStream out = new DataOutputStream(new FileOutputStream("C://eclipse-workspace//README.txt"))) {
			 // сохранить все записи о сотрудниках в файле README.txt
			 for (EmployeeIO e : staff)
				 writeData(out, e);
	     }
		 
		 try (RandomAccessFile in = new RandomAccessFile("C://eclipse-workspace//README.txt", "r")) {				 
			// извлечь все записи в новый архив 
			// определить размер массива			
			int n = (int)(in.length() / EmployeeIO.RECORD_SIZE);
			System.out.println(n);
			EmployeeIO[] newStaff = new EmployeeIO[n];
		     // прочитать записи о сотрудниках в обратном порядке for (int i = n - 1; i >= 0; i—)
			 for (int i = n - 1; i >= 0; i--) {
			//	 newStaff [i] = new EmployeeIO();
				 in.seek(i * EmployeeIO.RECORD_SIZE);
				 System.out.println(in.getFilePointer());
				 newStaff[i] = readData(in);
			}
			 // вывести вновь прочитанные записи от сотрудниках for (Employee е : newStaff)
		    for (EmployeeIO е : newStaff) {
				 System.out.println(е);
		    }
		 }	*/
	}
	
	/*
	 * Записывает сведения о сотрудниках в поток вывода данных
	 * @param out Поток вывода данных
	 * @param е Сотрудник */			  
	 public static void writeData(DataOutput out, EmployeeIO e) throws IOException {				 
		 DataIO.writeFixedString(e.getName(), EmployeeIO.NAME_SIZE, out); 
		 /*
		 *метод не использует кодировку UTF-8. Если вы написали double с помощью writeDoble (),
		 * то вы должны прочитать его с помощью метода readDouble DataInputStream.
		 *  Эти файлы не предназначены для изменения или чтения вручную.
		 *   Если вы хотите изложить его в простой форме, то придерживайтесь метода writeUTF.
		 
		 String sal = String.valueOf(e.getSalary());
		 out.writeUTF(sal);*/
		 out.writeDouble(e.getSalary());
		 GregorianCalendar calendar = new GregorianCalendar();
		 calendar.setTime(e.getHireDay());
		 out.writeInt(calendar.get(Calendar.YEAR));
		 out.writeInt(calendar.get(Calendar.MONTH) + 1);
		 out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	 }
	 /*
	  * 
	 * Читает сведения о сотрудниках из потока ввода данных
	 * @param in Поток ввода данных
	 * @return Возвращает сотрудника */
				 
	 public static EmployeeIO readData(DataInput in) throws IOException {
		 String name = DataIO.readFixedString(EmployeeIO.NAME_SIZE, in);
		 double salary = in.readDouble();
		 int у = in.readInt();
		 int m = in.readInt();
		 int d = in.readInt();
		 return new EmployeeIO(name, salary, у, m - 1, d);
	}	
}
