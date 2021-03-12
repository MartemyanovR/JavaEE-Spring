package tasks.leetcode;

import java.util.Random;

/*
 * Программа берет 2 исходных списка(случайного размера), заполняет их случайными числами от 1 до 9,
 * после складывает в результирующий список. Если результат больше 10, то единицу перебрасываем на следующую ноду.
 */
public class AddTwoNumbers {	
	public static void main(String[] args) {
		Solution l1 = new Solution();
		l1.insert();
		l1.displayList("1");
		Solution l2 = new Solution();
		l2.insert();
		l2.displayList("2");
		Solution ll_res = new Solution();
		ll_res = ll_res.merge(l1, l2);
		ll_res.displayList("result");
	}
	
	public static class Solution {
		private  ListNode first;
		private  ListNode last;
		private  Random countList = new Random();
		private  Random randomValue = new Random();
		
		public Solution() {
			first = null;
			last = null;
		}
		
		public Solution merge(Solution l1, Solution l2) {
			Solution ll_res = new Solution();
			ListNode node1 = l1.first;
			ListNode node2 = l2.first;
			int bit = 0;
			
			while(node1 != null && node2 != null) {				
				int sum = node1.val + node2.val + bit;
				if(sum<= 9) {
					insertMerge(ll_res, sum);
					bit=0;
				} else {
					insertMerge(ll_res, sum%10);
					bit = 1;
				}
				node1 = node1.next;
				node2 = node2.next;
			}
			if(node1 == null && node2 == null) {
				if (bit == 0) {
					return ll_res;
				} else {
					insertMerge(ll_res, bit);
					return ll_res;
				}				
			} else if(node1 == null) {
				copy(node2,ll_res, bit);
			} else 
				copy(node1,ll_res, bit);
			
			return ll_res;
		}
		
		private void copy(ListNode src, Solution dst, int bit) {
			int b = bit;			
			while(src != null) {
				src.val += b;
				if(src.val <= 9) {
					insertMerge(dst, src.val);
					b=0;
				} else {
					insertMerge(dst, src.val % 10);
				}				
				src = src.next;					
			}		
			if(b != 0) {
				insertMerge(dst, b);
			}
		}
		
		private void insertMerge(Solution ll_res, int i) {
			ListNode node = new ListNode(i);
			if(ll_res.first == null) {
				ll_res.first = node;
				ll_res.last = node;								
			} else {
				ll_res.last.next = node;
				ll_res.last = node;
			}
		}
	
		public void insert() {
			int count = countList.nextInt(100);
			while(count-- >0) {
				ListNode node = new ListNode(randomValue.nextInt(10));
				node.next = first;
				first = node;
			}			
		}
		
		public void displayList(String s) {
			System.out.print("List" +  s + ": ");
			ListNode current = first; 
			while(current != null) {
				current.displayLink(); 
				current = current.next; 
			}
			System.out.println("");
		}
	}
	
	public static class ListNode {
		int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	    public void displayLink() { System.out.print(val + " "); }
	}

}
