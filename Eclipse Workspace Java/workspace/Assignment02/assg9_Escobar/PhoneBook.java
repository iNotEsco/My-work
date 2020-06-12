package assg9_Escobar;

import java.io.*;
import java.util.*;

public class PhoneBook{

	private	BinarySearchTree<Person, String> book;
	private boolean modded;
	
	/**
	 * Default constructor
	 */
	
	public PhoneBook(){

		book = new BinarySearchTree<Person, String>();

	}
	public BinarySearchTree<Person, String> getBT(){
		return book;
	}
	public void insert(Person p){
		getBT().insert(p);
		modded = true;
	}
	public void delete(String name){
		getBT().delete(name);
		modded = true;
	}
	public Person find(String name){
		return getBT().retrieve(name);
	}
	public void change(String name, String newNum){
		Person temp = getBT().retrieve(name);
		temp.setNum(newNum);
		modded = true;
	}
	public void loadBook(){
		loadTree();
		modded = false;
	}
	private void loadTree(){
		Scanner input = null;
		try {
			input = new Scanner(new File("phoneBook.txt"));
		} catch (FileNotFoundException e) {
			System.out.print("ERROR: Can not read file \"phoneBook.txt\" for input");
			System.exit(1);
		}
		while(input.hasNextLine()){
			String[] parts = input.nextLine().split("\\s+");
			insert(new Person(parts[0] + " " + parts[1], parts[2]));
		}
	}

	public void printBook(){
		printTree(book.root);
		System.out.println("\n");
	}
	private static void printTree(TreeNode<Person> b){
		System.out.print("( ");
		if(b.item != null){
			if(b.leftChild != null){
				printTree(b.leftChild);
			}

			System.out.print(" , " + b.item + " , ");

			if(b.rightChild != null){
				printTree(b.rightChild);
			}	
			System.out.print(" )");
		}
	}
	private static void printTreeToFile(TreeNode<Person> b, PrintWriter output){
		if(b.item != null){
			if(b.leftChild != null){
				printTreeToFile(b.leftChild, output);
			}			
			output.println(b.item);
			if(b.rightChild != null){
				printTreeToFile(b.rightChild, output);
			}	
		}

	}
	public void saveFile(){
		if(modded){
			PrintWriter output = null;
			try {
				output = new PrintWriter(new FileWriter("phoneBook.txt"));
			} catch (IOException e) {
				System.out.println("ERROR: Can not open phoneBook.txt");
				System.exit(1);
			}
			printTreeToFile(getBT().root, output);
			output.close();
		}
	}

}
