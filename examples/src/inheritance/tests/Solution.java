package inheritance.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		int b = 1;
		int i = b = 50;
		System.out.println(b);
		ArrayList<Integer> listI = new ArrayList<Integer>();
		listI.add(1);
		List list = listI;
		list.add("!");
		System.out.println(list.get(1));
		//вносить и выводить можем, но как только нам нужно сделать что то конкретное, то ClassCast
		Integer in = listI.get(1);
		System.out.println(listI.get(1).intValue());

	}

}
