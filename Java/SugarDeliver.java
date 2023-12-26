package tst;

import java.util.Scanner;

public class SugarDeliver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, kg_5, kg_3;
		N = sc.nextInt(); //전체 kg
		kg_3 = 0; // 3kg로 묶은 봉지 개수
		if(N<3||N>5000) {
			System.out.println(-1); //3미만 5000초과는 안됨
		}
		else {
			while(N%5!=0) { // 5의 배수가 나올때까지 반복
				N = N-3; // 3을 한번씩 뺴줌
				kg_3++; // 3kg로 묶는 봉지의 수를 하나씩 더해줌
				if(N<5 & N!=0 & N!=3) { // 0과3이 아닌 5이하의 자연수에서 끝
					break;
				}
			}
			kg_5 = N/5;
			if(N<5 && N>0) {
				System.out.println(-1);
			}
			else {
			System.out.println(kg_5 + kg_3);
			}
		}
	}
}
/* 5로 많이 묶어야 봉지가 적어짐
 * 전체에서 3으로 하나씩 빼면서 5의배수가 성립하면 최소봉지 개수가 된다.
 * 
 * */
