package com.xatu.offer;
/**
 * 邮局站点的选定问题
 * @author 马志
 *
 */
public class off02 {
	public int test(int arr[]) {
		int s = 0;
		int o = 0;
		int min = 1006;
		for (int i = 0; i < 6; i++) {
			for (int j = i + 1; j < 6; j++) {
				s = 0;
				for (int a = 0; a < 6; a++) {
					int m = Math.abs(arr[a] - arr[i]);
					int n = Math.abs(arr[a] - arr[j]);
					int x;
					if (m == n) {
						x = m;
					} else {
						x = m < n ? m : n;
					}
					s += x;
				}
				o = s;
				if (o < min)
					min = o;
				System.out.println(o);
			}
		}
		return min;
	}
}
