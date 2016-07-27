
public class TestNullPointer {
	
	public static void main(String args[]){
		Runnable test1 = () -> System.out.println("hello");
		test1.run();
		Runnable test = new Runnable(){

			@Override
			public void run() {
				System.out.println("dfj");
				
			}
			
	};

}
}
