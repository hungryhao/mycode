package com.hungry.others;

class A{

    static{
        System.out.print("1");
    }

    public A(){
        System.out.print("2");
    }
}

class B extends A{

    static{
        System.out.print("a");
    }

    public B(){
        System.out.print("b");
    }
}

public class ClassTest{
	
	public static String test() {
		String a = "a";
		try {
			a = "b";
			return a;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			a = "c";
			System.out.println("\n" + a);
		}
		System.out.println(a);
		return a;
	}

    public static void main(String[] args){
        A ab = new B();
        System.out.println("\n&&&");
        ab = new B();
        String s = test();
        System.out.println("\n" + s);
    }

}
