package com.ramanjit.io.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MainApplication {
	public static void serializeObject(final Customer customer) {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("src/data.txt");
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customer);
			System.out.println("***** Object Serialized Sucessfully*****");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static Customer DeserializeObject() {
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		Customer customer = null;
		try {
			fileInputStream = new FileInputStream("src/data.txt");
			objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			customer = (Customer) object;
			System.out.println("Deserialization done!!!");
			System.out.println(customer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I am from main method");
		System.out.println("**********************");
		System.out.println("1) Serialize the object");
		System.out.println("2) Deserialize the object");
		System.out.println("3) Exit");
		Scanner scanner = new Scanner(System.in); // Get user input; System.in
													// repersent keyboard
		Customer customer = new Customer("001", "Raman", "PassWord", 77058, "Houston");
		Customer customer2 = null;
		System.out.println("Enter the choice : ");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:

			serializeObject(customer);
			break;
		case 2:
			customer2 = DeserializeObject();
			if (customer == customer2) {
				System.out.println("same memory location");
			} else {
				System.out.println("Deserialization return new memory location");
			}

			break;
		case 3:
			System.exit(0); // graceful execution of JVM
			break;
		}
		scanner.close();
		System.out.println("**********************");
		System.out.println("End of main method");
	}

}
