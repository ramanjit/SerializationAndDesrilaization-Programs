package com.ramanjit.io.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class SingletonSerialAppMain {
	public static void serializeTheObject(final MySingleton1 singleTonSerial) {
		// Store object in file
		// OPen the file
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectStream = null;
		try {
			fileOutputStream = new FileOutputStream("src/data2.txt");
			objectStream = new ObjectOutputStream(fileOutputStream);
			objectStream.writeObject(singleTonSerial);
			System.out.println("Object serialezed sucessfully");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream = null;
				}
				if (objectStream != null) {
					objectStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static MySingleton1 DoserializeTheObject() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		MySingleton1 singleTonSerial = null;
		try {
			fileInputStream = new FileInputStream("src/data2.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			singleTonSerial = (MySingleton1) object;
			System.out.println("DeSerialization done");
			System.out.println(singleTonSerial);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (objectInputStream != null) {
					objectInputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return singleTonSerial;

	}

	public static void main(String[] args) {
		System.out.println("I am from main method");
		System.out.println("**************");
		System.out.println("1) Serialized the singleton object ");
		System.out.println("2) Deserialized the singleton object");
		System.out.println("3) Exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the choice");
		MySingleton1 singleTonSerial = MySingleton1.getInstance();
		MySingleton1 singleTonSerial1 = null;
		int choice = scanner.nextInt();

		switch (choice) {
		case 1:

			// SingleTonSerialization singleTonSerial =
			// SingleTonSerialization.getInstance();
			serializeTheObject(singleTonSerial);
			break;
		case 2:
			singleTonSerial1 = DoserializeTheObject();
			if (singleTonSerial == singleTonSerial1) {
				System.out.println("Same memory location");
			} else {
				System.out.println("New memery location");
			}

			break;
		default:
			System.exit(0);
			break;
		}
		scanner.close();
		System.out.println("**************");
		System.out.println("End of main method");
	}
}
