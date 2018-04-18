package com.xatu.pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * 用栈去识别缺少的符号位
 */
public class statck {
  public static void main(String[] args) {
	boolean T=false;
	boolean flag=true;
	String S[]=new String[100];
    List<String> list=new ArrayList<String>();
    List<String> list2=new ArrayList<String>();
	Scanner sc=new Scanner(System.in);
	while(flag) {
		String a = sc.nextLine();//输入符号集合
		if("(".equals(a)) {
			list.add(a);
		}
		else if(")".equals(a)){
			list.add(a);
		}
		else {
			flag=false;
			break;
		}
	}
    
    if(1<=list.size()&&list.size()<=50) {
    	T=true;
    }
    while(T) {
    	//对符号进行匹配操作
    	for(int i=0;i<list.size();i++) {
    		S[i]=list.get(i);
    	}
    	for(int i=0;i<S[i].length();i++) {
    		//栈为空时压入栈操作
    		if(list2.size()==0) {
    			list2.add(S[i]);
    		}
    		if(list2.get(list2.size()-1).equals(S[i+1])) {
    			list2.remove(list2.size()-1);
    		}
    		else {
    			list2.add(S[i]);
    		}
    	}
    }
    System.out.println(list2.size());
  }
}
