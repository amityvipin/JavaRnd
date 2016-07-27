package sun.java.enums;

import java.io.Serializable;
import java.util.*;



public class Test{
	enum Test1{
		A{
		public String toString(){
			return "abcd";
		}
		public int display(int a, int b){
			return a+b;
		}
		},
		B{
			public String toString(){
				return "abc";
			}

			@Override
			int display(int a, int b) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		
		abstract int display(int a,int b);
	}
	
	public static void main(String args[]){
		System.out.println(Test1.valueOf("B"));

List<Test1> testList = new ArrayList<Test1>();
testList.add(Test1.A);
testList.add(Test1.B);
Collections.sort(testList);
for(Test1 a:testList){
	System.out.println(a);
}
		
	}
}
