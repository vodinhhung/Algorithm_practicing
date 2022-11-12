package tutorial.javabasic.javastructure;

public class Fieldsampletest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fieldsample ob1 = new Fieldsample("Value1");
		System.out.println("ob1.myValue1 = " +ob1.myValue1);
		System.out.println("ob1.MY_STATIC_FIELD = " + ob1.MY_STATIC_FIELD);
		System.out.println("Fieldsample.MY_STATIC_FIELD = " + Fieldsample.MY_STATIC_FIELD);
		
		Fieldsample ob2 = new Fieldsample("Value2");
		System.out.println("ob2.myValue1 = " + ob2.myValue1);
		System.out.println("ob2.My_STATIC_FIELD = " +ob1.MY_STATIC_FIELD);
		
		ob1.MY_STATIC_FIELD = 200;
		System.out.println("ob2.MY_STATIC_FIELD = " +ob2.MY_STATIC_FIELD);
		
	}

}
