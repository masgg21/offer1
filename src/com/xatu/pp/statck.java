package com.xatu.pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 * ��ջȥʶ��ȱ�ٵķ���λ
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
		String a = sc.nextLine();//������ż���
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
    	//�Է��Ž���ƥ�����
    	for(int i=0;i<list.size();i++) {
    		S[i]=list.get(i);
    	}
    	for(int i=0;i<S[i].length();i++) {
    		//ջΪ��ʱѹ��ջ����
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
