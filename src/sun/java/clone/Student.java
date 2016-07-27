package sun.java.clone;

import java.util.ArrayList;
import java.util.List;

public class Student implements Cloneable{

	// Contained object
	private Subject subj;
	private String name;

	public Subject getSubj() {
		return subj;
	}
	private void setSubject(Subject subject){
		this.subj = subject;
	}
	public String getName() {
		return name;
	}

	public void setName(String s) {
		name = s;
	}

	public Student(String s, String sub) {
		name = s;
		subj = new Subject(sub);
	}

	public Student clone() {
		// shallow copy
		try {
			Student std = (Student)super.clone();
			std.setSubject(subj.clone());
			return std;//(Student)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public static void main(String[] args) {
		Student std = new Student("vipin", "java");
		Student stdClone = std.clone();
		stdClone.getSubj().setName("jfjdkfjkdjf");
		System.out.println(std.getSubj().getName()+stdClone.getSubj().getName());

	}

}
