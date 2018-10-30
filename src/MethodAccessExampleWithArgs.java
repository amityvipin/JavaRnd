import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

public class MethodAccessExampleWithArgs {
	private final int i;

	public MethodAccessExampleWithArgs(int i_) {
		i = i_;
	}

	private void bar(int j, String msg) {
		System.out.println("Private Method 'bar' successfully accessed : " + i + ", " + j + " : " + msg + "!");
	}

	// Using Reflection
	public static Method makeMethod() {
		Method meth = null;

		try {
			Class[] argTypes = new Class[] { int.class, String.class };

			meth = MethodAccessExampleWithArgs.class.getDeclaredMethod("bar", argTypes);

			meth.setAccessible(true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return meth;
	}

	// Using method handles
	public static MethodHandle makeMh() {
		MethodHandle mh;

		MethodType desc = MethodType.methodType(void.class, int.class, String.class);

		try {
			mh = MethodHandles.lookup().findVirtual(MethodAccessExampleWithArgs.class, "bar", desc);
			System.out.println("mh=" + mh);
		} catch (Exception e) {
			throw (AssertionError) new AssertionError().initCause(e);
		}
		return mh;
	}
}