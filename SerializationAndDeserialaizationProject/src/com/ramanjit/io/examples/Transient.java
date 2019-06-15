package com.ramanjit.io.examples;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class employee1 implements Serializable {
	transient int empNo = 10;
	String empName = "Raman";
	transient final String empPassWord = "xyz";
	transient static String street = "sangrur";
}

class Transient {

	public static void main(String[] args) throws Exception {
		employee1 empObj = new employee1();

		FileOutputStream fos = new FileOutputStream("TransientData.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(empObj);
		FileInputStream fis = new FileInputStream("TransientData.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		employee1 empObj1 = (employee1) ois.readObject();
		// Before Serialization
		System.out
				.println(empObj.empNo + "....." + empObj.empName + "..." + empObj.empPassWord + "..." + empObj.street);
		// After Serialization
		System.out.println(
				empObj1.empNo + "....." + empObj1.empName + "..." + empObj.empPassWord + "..." + empObj.street);

	}

}
