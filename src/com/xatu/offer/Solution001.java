package com.xatu.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.xatu.util.ListNode;

public class Solution001 {
	/**
	 * 不使用+。—。*。/四则运算解决两个数的和
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public int Add(int x, int y) {
		int sum;
		int carry;

		while (true) {
			sum = x ^ y;
			carry = (x & y) << 1;
			y = carry;
			x = sum;
			if (y == 0) {
				break;
			}
		}
		return sum;
	}

	/**
	 * 不使用for，while等关键字实现1--n的和
	 */
	public static int sum01(int n) {
		int sum = n;
		boolean ans = (n > 0) && ((sum += sum01(n - 1)) > 0);
		return sum;
	}

	/**
	 * 在一个递增数组中找两个数的和为sum 输出乘积最小的两个数
	 * 
	 * @param array
	 * @param sum
	 * @return
	 */
	public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == sum) {
					list.add(array[i]);
					list.add(array[j]);
					list.add(array[i] * array[j]);
				}
			}
			if (!list.isEmpty())
				lists.add(list);
		}
		if (lists.size() == 0)
			return new ArrayList<Integer>();
		// if(lists.size() ==1) return lists.get(0);
		Collections.sort(lists, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(2).compareTo(o2.get(2));
			}
		});
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> temp = lists.get(0);
		for (int i = 0; i < temp.size() - 1; i++) {
			result.add(temp.get(i));
		}
		return result;
	}

	/**
	 * 查找数组中数值超过一半数组长度的数，没有返回0
	 */
	public int Soluntion(int[] array) {
		int length = array.length;
		if (array == null || length <= 0) {
			return 0;
		}
		if (length == 1) {
			return array[1];
		}
		int[] tempArray = new int[length];
		for (int i = 0; i < length; i++) {
			tempArray[i] = array[i];
		}
		for (int i = 0; i < length; i++) {
			// 后面需要用零来代表抹除数字，所以对0时做特殊处理
			if (tempArray[i] == 0) {
				continue;
			}
			for (int j = i + 1; j < length; j++) {
				if (tempArray[i] != tempArray[j] && tempArray[j] != 0) {
					tempArray[i] = 0;// 此处用0代表抹去该数字
					tempArray[j] = 0;
					break;
				}
			}
		}
//		for (int i = 0; i < length; i++) {
//			System.out.println(tempArray[i]);
//		}
		// 找出未被抹去的数字
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (tempArray[i] != 0) {
				result = tempArray[i];
				break;
			}
		}
		int times = 0;
		for (int i = 0; i < length; i++) {
			if (result == array[i]) {
				times++;
			}
		}
		if (times * 2 < length) {
			result = 0;
		}
		return result;
	}
	/**
	 * 在一个字符串中遇到空格添加20%进去
	 */
	public String replaceSpace(StringBuffer str) {
	       int len=str.length();
	       int count=0;
	       for(int i=0;i<str.length();i++){
	           if(str.charAt(i)==' ')
	               count++;
	       }
	       int newLen=2*count+len;
	       int index=newLen-1;
	       char []ptr=new char[newLen];
	       while(len>0){
	           if(str.charAt(len-1)!=' '){
	               ptr[index--]=str.charAt(len-1);
	           }else{
	               ptr[index--]='0';
	               ptr[index--]='2';
	               ptr[index--]='%';
	           }     
	           --len;
	       }
	        return new String(ptr);
	    }
	 /**
	 * 输入一个链表，从尾到头打印链表每个节点的值。
	 * @param listNode
	 * @return
	 */
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	        ArrayList<Integer> a = new ArrayList<Integer>();  
	        ListNode temp = listNode;  
	       while(temp != null){  
	            a.add(new Integer(temp.val));  
	            temp = temp.next;  
	        }  
	        Integer b ;  
	        for(int i=0; i<a.size()/2;i++){  
	            b = a.get(i);  
	            a.set(i, a.get(a.size()-i-1));  
	           a.set(a.size()-i-1,b);  
	       }  
	       return a;  
	    }
}
