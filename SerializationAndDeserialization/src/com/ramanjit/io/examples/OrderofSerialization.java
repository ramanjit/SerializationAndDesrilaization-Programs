package com.ramanjit.io.examples;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat implements Serializable {
	int i = 10;
}

class Dog implements Serializable {
	int i = 20;
}

class Rat implements Serializable {
	int i = 30;
}

class OrderofSerialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Rat r1 = new Rat();
		FileOutputStream fos = new FileOutputStream("Order.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(d1);
		oos.writeObject(c1);
		oos.writeObject(r1);

		FileInputStream fis = new FileInputStream("Order.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Dog d2 = (Dog) ois.readObject();
		Cat c2 = (Cat) ois.readObject();
		Rat r2 = (Rat) ois.readObject();
		System.out.println("Order of serialization   " + d1.i + "...." + c1.i + "...." + r1.i);
		System.out.println("Order of deserialization " + d2.i + "...." + c2.i + "...." + r2.i);

	}
}
