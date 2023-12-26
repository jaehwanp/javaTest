import java.util.Scanner;

class MakeStar{

    public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	
/*
*****
 ****
  ***
   **
    *

*/

	for(int i = 0; i<a; i++) {
		for(int j = 0; j<a-i; j++){
			System.out.print("*");
		}
		System.out.println();
		for(int k = 0; k<i+1; k++){
			System.out.print(" ");
		}
	}

	System.out.println();

/*	
    *
   ***
  *****
 *******
*********
*/
	int b = sc.nextInt();
	
	for(int i = 0; i<b; i++){
		for(int j = 0; j<b-i; j++){
			System.out.print(" ");
		}
		for(int k = 0; k<i+1; k++){
			System.out.print("*");
		}
		for(int l = 0; l<i; l++){
			System.out.print("*");
		}
		System.out.println();
	}

/*
	
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
*/
	
	int c = sc.nextInt();
	
	for(int i = 0; i<c; i++){
		for(int j = 0; j<c-i; j++){
			System.out.print(" ");
		}
		for(int k = 0; k<i+1; k++){
			System.out.print("*");
		}
		for(int l = 0; l<i; l++){
			System.out.print("*");
		}
		System.out.println();
	}
	for(int i=0; i<c*2+1; i++)
		System.out.print("*");
	System.out.println();
	System.out.print(" ");
	for(int i = 0; i<c; i++) {
		for(int j = 0; j<c-i-1; j++){
			System.out.print("*");
		}
		for(int l = 0; l<c-i; l++){
			System.out.print("*");
		}
		System.out.println();
		for(int k = 0; k<i+2; k++){
			System.out.print(" ");
		}
	}
    }
}
