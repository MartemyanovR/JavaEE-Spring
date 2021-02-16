package genericsHexlet;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	public T data;
	
	public Node(T data) {
		this.data = data;
	}
	
	public void setData(T data) {
		System.out.println("Node.setData");
		this.data = data;
	}

	public static void main(String[] args) {
		List<String> strings = (List) new ArrayList<Integer>();
		strings.add("_");
		Object[] str = new String[5];
		str[0] = "hi";
		//str[1] = 1;	
		
		Node.MyNode<Integer> mn = new Node.MyNode<>(1);
		Node<Integer> n = mn;
		n.setData(1);  //A raw type, throws ClassCastException
		Integer x = mn.data;
		

	}
	
	public static class MyNode<T> extends Node<Integer> {
		
		public MyNode(Integer data) {
			super(data);
		}
		
		public void setData(Integer data) {
			System.out.println("MyNode.setData()");
			super.setData(data);
		}
	}

}
