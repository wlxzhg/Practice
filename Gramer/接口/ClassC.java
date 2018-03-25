public class ClassC implements B{
	public int doSomething(String name) {
		return name.length();
	}

	public String func3(Integer num) {
		return "func3";
	}

	public void func2() {
		int a = 1;
		int b = 1 << 30;
		System.out.println(b);
	}

	public int func1(int a) {
		return a << 1;
	}

	public static void main(String[] args) {
		ClassC c = new ClassC();
		String s = c.func3(10);
		c.func2();
		int b = c.func1(34); 
		int a = c.doSomething("hello");

		System.out.print(a + "\n" + b + "\n" + s);
	}
}