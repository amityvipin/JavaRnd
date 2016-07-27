package sun.java.serialization;

public final class  Student implements Cloneable{
	private String name;
	private Subject subject;
	public Student(){
		System.out.println("without argument");
	}
	public Student(String stdName, String name){
		this.setName(stdName);
		this.setSubject(new Subject(name));
		System.out.println("without argument");
	}
	
	public static void main(String args[]) throws CloneNotSupportedException{
		Student std = new Student("Vipin", "java");
		Student stClone = (Student)std.clone();
		
		std.getSubject().setName("j2ee");
		System.out.println(std.getName()+":::"+std.getSubject().getName());
		System.out.println(stClone.getName()+":::"+stClone.getSubject().getName());
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
class Subject{
	private String name;
	public Subject(String name){
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
