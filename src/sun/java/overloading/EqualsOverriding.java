package sun.java.overloading;

import java.util.HashSet;
import java.util.Set;

public class EqualsOverriding{


	private String name;
	public EqualsOverriding(String name){
		this.name = name;
	}
	@Override
	public boolean equals(Object o) {
		return name.equals(((EqualsOverriding)o).name);
	}

	public boolean equals(EqualsOverriding o){
		return true;
	}
	public int hashCode(){
		return name.hashCode();
	}


	public static void main(String[] args) {
		Set<EqualsOverriding> temp = null;//new HashSet<EqualsOverriding>();
		EqualsOverriding a1 = new EqualsOverriding("test");
		EqualsOverriding a2 = new EqualsOverriding("test");
//		temp.add(a1);
//		temp.add(a2);
		System.out.println(temp);
	}

}
