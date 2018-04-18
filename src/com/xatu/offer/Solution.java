package com.xatu.offer;
public class Solution {
    public static boolean Find(int target, int [][] array) {
         boolean flag=false;
          for(int i=0;i<array.length;i++){
              for(int j=0;j<2;j++){
                int m=array[i][j];
                  if(m==target){
                      flag=true;
                  }
              }
          }
          return flag;
    }
    public static void main(String[] args) {
		int [][]array= {{1,2},{3,4},{5,6}};
		int target=3;
		boolean find = Find(target, array);
		System.out.println(find);
	}
}