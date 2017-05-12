package io.github.vstollen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	Tape tape = new Tape();
	
	Reader reader;
	
	Scanner scr = new Scanner(System.in);

	public static void main(String[] args) {
		
		//Checks if there is an argument
		if (args.length != 1) {
			throw corruptFile();
		}
			
		String path = args[0];
		
		Main main = new Main(path);
		
		main.process();
		
		try {
			main.reader.close();
			main.scr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Main(String path) {
		try {
			this.reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			throw corruptFile();
		}
	}
	
	void process() {
		int c = -2;
		try {
			while ((c = reader.read()) != -1) {
				processChar((char) c);
			}
			
		} catch (FileNotFoundException e) {
			throw corruptFile();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void loop() {
		int c = -2;
		char nextChar = '#';
		boolean loopClosed = false;
		List<Character> loopCode = new ArrayList<Character>();
		
		try {
			while ((c = reader.read()) != -1) {
				nextChar = (char) c;
				if (nextChar == ']') {
					loopClosed = true;
					break;
				}else {
					loopCode.add(nextChar);
				}
			}
			
			if (loopClosed == false) {
				throw new RuntimeException("Never closed loop! Missing ']' statement.");
			}
			
			while (tape.getCurrent() != 0) {
				for (int i = 0; i < loopCode.size(); i++) {
					processChar(loopCode.get(i));
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void processChar(char c) {
		if (c == '>') {
			tape.stepRight();
		}else if (c == '<') {
			tape.stepLeft();
		}else if (c == '+') {
			tape.increase();
		}else if (c == '-') {
			tape.decrease();
		}else if (c == '.') {
			System.out.println((char) tape.getCurrent());
		}else if (c == ',') {
			tape.setCurrent((int) scr.next().charAt(0));
		}else if (c == '[') {
			loop();
		}
	}
	
	static RuntimeException corruptFile(){
		return new RuntimeException("File not found!\nUsage: java -jar brainfuck-compiler.jar <PATH>");
	}

}
