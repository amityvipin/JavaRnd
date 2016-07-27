package sun.java.clone;

public class Subject implements Cloneable{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public Subject(String s) {
		name = s;
	}
	public Subject clone() {
		// shallow copy
		try {
			return (Subject)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

}
