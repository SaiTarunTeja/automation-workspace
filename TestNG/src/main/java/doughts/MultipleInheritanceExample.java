package doughts;

public class MultipleInheritanceExample {

	public static void main(String[] args) {
		Interface1 implementationClass = new InterfaceImplementationClass();
		implementationClass.show();

	}

}

class InterfaceImplementationClass implements Interface1, Interface2{

	@Override
	public void show() {
		Interface1.super.show();
		Interface2.super.show();
		System.out.println("class");
	}
	
}

interface Interface1{
	default void show() {
		System.out.println("interface1");
	}
}

interface Interface2{
	default void show() {
		System.out.println("interface2");
	}
}