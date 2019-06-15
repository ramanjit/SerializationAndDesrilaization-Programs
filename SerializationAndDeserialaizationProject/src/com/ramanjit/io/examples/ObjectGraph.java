/*			Object Graph in Serialization

*/

package com.ramanjit.io.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Department implements Serializable{
	Role r = new Role();
}

class Role  implements Serializable{
	Employee e = new Employee();
}

class Employee implements Serializable{
	int id = 20;
}

public class ObjectGraph {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Department d = new Department();
		FileOutputStream fos = new FileOutputStream("ObjectGraph");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d);
		
		FileInputStream fis = new FileInputStream("ObjectGraph");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Department d1 = (Department)ois.readObject();
		System.out.println(d1.r.e.id);
		
		
		
		
		
	}

}
