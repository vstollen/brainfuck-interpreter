package io.github.vstollen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) {
		
		//Checks if there is an argument
		if (args.length != 1) {
			throw corruptFile();
		}
		
		
		String path = args[0];
		
		try {
			Reader reader = new BufferedReader(new FileReader(path));
			
			
			
		} catch (FileNotFoundException e) {
			throw corruptFile();
		}
	}
	
	static RuntimeException corruptFile(){
		return new RuntimeException("File not found!\nUsage: java -jar brainfuck-compiler.jar <PATH>");
	}

}
