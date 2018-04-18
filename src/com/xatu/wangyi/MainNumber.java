package com.xatu.wangyi;

/**
 * @author Administrator
 *
 */
public class MainNumber {
	    //暴力枚举
	    public String PrintMinNumber1(int [] numbers) {
	    	StringBuilder []stringBuilder=new StringBuilder[numbers.length];
	    	for (int i = 0; i < numbers.length; i++) {
				
			}
			return null;
	    }
	    //算法优化
	    public String PrintMinNumber2(int [] numbers) {
			return null;
	    }
	    public static String f(int array[]){
	        for(int i=0;i<array.length-1;i++){
	            int big=0;
	            for(int  j=0;j<array.length-i;j++){
	                if(compare(String.valueOf(array[j]),String.valueOf(array[big]))>0){
	                    big=j;
	                }
	            }
	            if(big!=array.length-i-1){
	                int temp=array[big];
	                array[big]=array[array.length-i-1];
	                array[array.length-i-1]=temp;
	            }
	        }
	        String []string = new String[array.length];
	        for (int i = 0; i < array.length; i++) {
				string[i]=Integer.toString(array[i]);
			}
            StringBuilder stringBuilder=new StringBuilder();
            for(String str:string) {
            	stringBuilder.append(str);
            }
            return stringBuilder.toString();
	    }
	    public static int compare(String a, String b){
	        String  left=a+b;
	        String  right=b+a;
	        for(int i=0;i<left.length()-1;i++){
	            if(left.charAt(i)>right.charAt(i)){
	                return 1;
	            }else if(left.charAt(i)<right.charAt(i)){
	                return -1;
	            }
	        }
	        return 0;
	    }

	    public static void main(String args []){
	        int array[]=/*{23,345, 121,42,1}*/{3,32,321,4};
	        String f = f(array);
	        System.out.println(f);
	    }
}
