package com.xatu.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Solution001的测试类
 */
import org.junit.Test;
import com.xatu.offer.Solution001;
import com.xatu.stack.Solution;
import com.xatu.util.ListNode;

public class Test1 {
	Solution001 s = new Solution001();

	/**
	 * 测试两个数的求和
	 */
	//@Test
	public void test001() {
		int sum = s.Add(5, 6);
		System.out.println(sum);
	}
   //————————————————————————————————————————————————————————//
	/**
	 * 测试1+2+3.。。。+n的和
	 */
	//@Test
	public void test002() {
		int sum = s.sum01(100);
		System.out.println(sum);
	}
	//————————————————————————————————————————————————————————//
	/**
	 * 测试有序数组中两个数的和为S，并且输出的两个数乘积最小
	 */
	//@Test
	public void test003() {
		int[] array= {2,3,4,5,6,7,8};
		List<Integer> result=s.FindNumbersWithSum(array, 10);
		Iterator<Integer> it=result.iterator();
		while (it.hasNext()) {
	     Integer i=it.next();
	     System.out.println(i);
		}
	} 
	
	/**
	 *测试超过数组长度一般的数 
	 */
	//@Test
	public void test004() {
		int[] array= {2,2,2,2,3,3,3};
		int result=s.Soluntion(array);
		System.out.println(result);
	}
	/**
	 * 测试输入一个字符串，遇到空格添加20%；
	 */
	//@Test
	public void test005() {
		StringBuffer str=new StringBuffer("we are family");
		String str1=s.replaceSpace(str);
		System.out.println(str1);
	}
	/**
	 * 测试逆向打印出链表
	 */
	//@Test
	public void test006() {
		ListNode a=new ListNode(1);
		a.next=new ListNode(2);
		a.next.next=new ListNode(3);
		ArrayList<Integer> b=s.printListFromTailToHead(a);
        System.out.println(b.get(0)+"----"+b.get(1)+"----"+b.get(2));
	}
	/**
	 * 用两个栈实现队列操作
	 */
	@Test
	public void test007() {
		Solution si=new Solution();
		si.push(2);
		si.push(3);
		si.push(4);
		si.push(5);
		System.out.println(si.pop());
		System.out.println(si.pop());				
		System.out.println(si.pop());
	}	
}
