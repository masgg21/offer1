package com.xatu.offer;

public class sun {
      public static int sum01(int n) {
    	  int sum=n;
    	  sum+=sum01(n-1);
    	  return sum;
      }
      public static void main(String[] args) {
		  System.out.println(sum01(100));
	}
}
