package day10;

class Ex19{

  public static void main(String[] args){
	Ex19 me = new Ex19();
	me.func01();
  }

  public void func01(){
	System.out.println("�θ�Ŭ������ ���");
  }

  public void func03(){
	System.out.println("�θ�Ŭ���� ���");
  }

}

public class Ex08 extends day10.Ex19{
  int su1=1234;

  public static void main(String[] args){

	Ex08 me = new Ex08();
	me.func01();
	me.func02();
	//Ex08.func03();//(x)
	//Ex09.func03();//(o)
	me.func03();

  }

  public void func02(){
	System.out.println("�ڽ�Ŭ������ ���");
  }

  public void func03(){
	System.out.println("�޼��� �������̵�...");
  }

}











