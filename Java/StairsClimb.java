package tst;

import java.util.Scanner;

public class StairsClimb {
	
	public static void main(String[] args) {
		int N; // 전체 계단 수
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		int[] max_sum = new int[N]; // 오른 계단 합
		int[] stair = new int[N]; // 각 계단당 값

		for(int i = 0; i<N; i++) {
			stair[i] = sc.nextInt();
		}

		max_sum[0] = stair[0]; // 1계단 합
		max_sum[1] = stair[0] + stair[1]; // 1, 2 계단 합
		max_sum[2] = Math.max(stair[0] + stair[2] , stair[1] + stair[2]); //1,3 or 2,3계단 중 최대값

		for(int i = 3; i<N; i++) {
			max_sum[i] = Math.max(max_sum[i-3] + stair[i-1] + stair[i], max_sum[i-2] + stair[i]);
		} // N-2 계단에서 N으로 감 (N-2계단까지의 합 + N계단의 값) or N-1 계단에서 N으로 감 (N-3계단까지의 합 + N-1계단의 값 + N계단의 값) 중 최대값
		System.out.println(max_sum[N-1]);
	}
}