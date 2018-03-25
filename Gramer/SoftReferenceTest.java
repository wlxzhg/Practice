import java.lang.ref.*;

public class SoftReferenceTest {
	public static void main(String[] args) {
		SoftReference soft = new SoftReference(new Integer(100));
		Integer a = (Integer)soft.get();
		System.out.println(a);
	}
}