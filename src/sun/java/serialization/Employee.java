package sun.java.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int i;
	Employee(int i){
		this.i = i;
	}
	
	private void writeObject(ObjectOutputStream ods) throws IOException{
		ods.writeInt(i);
	}
	
	private void readObject(ObjectInputStream ois) throws IOException{
		int i = ois.readInt();
	}
	private void readObjectNoData(){
		
	}
	private Object readResolve(){
		return this;
	}

}
