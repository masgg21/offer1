package com.xatu.pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		boolean T = false;
		boolean flag = false;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int a = 0, b = 0, c = 0;
		int x[] = new int[100];
		int[] y = new int[100];
		int n = Integer.parseInt(sc.nextLine());// 参加游戏的人数
		if (1 <= n && n <= 50) {
			T = true;
		}
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();// 输入的数字
			if (0 <= x[i] && x[i] <= 100000) {
				flag = true;
			}
		}
		// 数字变换
		if (T && flag) {
			for (int i = 0; i < n; i++) {
				while (x[i] > 0) {
					a = x[i] % 10;
					x[i] = x[i] / 10;
					list.add(a);
				}
				int s = list.size();
				for (int j = 0; j < s; j++) {
					Integer min = Collections.min(list);
					list.remove(min);
					list2.add(min);
				}

				for (Integer integer : list2) {
					sb.append(integer);
				}
				y[i] = Integer.parseInt(sb.toString());
				sb.delete(0, s);
				list.removeAll(list);
				list2.removeAll(list2);
				list3.add(y[i]);
			}
		}
		Integer max = Collections.max(list3);
		System.out.println(max);
	}
}
