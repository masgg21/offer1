package com.xatu.wangyi;

import java.util.Scanner;

public class Choir {
	
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		while(s.hasNextInt()){
			int n = s.nextInt(); //ѧ������
			int[] ability = new int[n];
			for(int i = 0; i < n; i++){
				ability[i] = s.nextInt();
			}
			int k = s.nextInt();
			int d = s.nextInt();
			
			//maxProduct[i][j]��ʾ�Ե�i����Ϊ��β���ϳ��ŵ�����Ϊj+1ʱ���ϳ������������˻�
			long[][] maxProduct = new long[n][k]; 
			//minProduct[i][j]��ʾ�Ե�i����Ϊ��β���ϳ��ŵ�����Ϊj+1ʱ���ϳ�����С�������˻�
			long[][] minProduct = new long[n][k];
			
			//�ϳ�����ֻ��һ����
			for(int i = 0; i < n; i++){
				maxProduct[i][0] = ability[i];
				minProduct[i][0] = ability[i];
			}
			
			long max = Long.MIN_VALUE;
			for(int i = 0; i < n; i++){
				for(int j = 1; j < k; j++){
					for(int p = i-1; p >= Math.max(i-d,0); p--){
						maxProduct[i][j] = Math.max(maxProduct[i][j],
								           maxProduct[p][j-1]*ability[i]);
						maxProduct[i][j] = Math.max(maxProduct[i][j],
						           minProduct[p][j-1]*ability[i]);
						minProduct[i][j] = Math.min(minProduct[i][j],
						           minProduct[p][j-1]*ability[i]);
						minProduct[i][j] = Math.min(minProduct[i][j],
						           maxProduct[p][j-1]*ability[i]);
					}
				}
			  max = Math.max(max, maxProduct[i][k-1]);
			}
			
			System.out.println(max);
			
		}
		
	}

	
	

}