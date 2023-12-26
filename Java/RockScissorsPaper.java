/*
----------------
가위바위보게임
----------------
가위(1) 바위(2) 보(3) 종료(0)>1
COM : 바위
YOU : 가위
결과 : 졌습니다.

*/


class RockScissorsPaper{

   public static void main(String[] args){
	
	System.out.println("-------------------------");
	System.out.println("가위,바위,보 게임");
	System.out.println("-------------------------");
	
	boolean result = true;

	while(result){
		double ran = Math.random();	
		int a = (int)(ran*3.0);
		
		System.out.print("가위(1) 바위(2) 보(3) 종료(0)>");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int i = sc.nextInt();
		if(i==0){
			System.out.print("이용해주셔서 감사합니다.");
			break;
		}
		System.out.print("COM : ");
		switch(a){
			case 0:
				System.out.println("가위");
				break;
			case 1:
				System.out.println("바위");
				break;
			case 2:
				System.out.println("보");
				break;
			default:
				System.out.println("오류");
		}

		System.out.print("YOU : ");
		switch(i){
			case 1:
				System.out.println("가위");
				break;
			case 2:
				System.out.println("바위");
				break;
			case 3:
				System.out.println("보");
				break;
			default:
				System.out.println("잘못입력");
		}
	System.out.print("결과 : ");
	if(i==1 && a==1)
		System.out.println("졌습니다.");
	else if(i==1 && a==2)
		System.out.println("이겼습니다.");
	else if(i==2 && a==0)
		System.out.println("이겼습니다.");
	else if(i==2 && a==2)
		System.out.println("졌습니다.");
	else if(i==3 && a==0)
		System.out.println("졌습니다.");
	else if(i==3 && a==1)
		System.out.println("이겼습니다.");
	else
		System.out.println("비겼습니다.");

	}

   }


}