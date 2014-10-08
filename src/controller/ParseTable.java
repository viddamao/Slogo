package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseTable {
    private static String[][] myTable = new String[65][138];

    public static void initializeTable(){
	try {
	    BufferedReader in = new BufferedReader(new FileReader(".\\src\\properties\\parsetable.txt"));
	   // System.out.print(in.readLine());
	    for (int i=0;i<138;i++){
		String inputBuffer=in.readLine();
		System.out.print(inputBuffer);    	
		for (int j=0;j<63;j++){
		    
		    myTable[i][j]=inputBuffer.split(" ")[j];
		}
	    }
	    for (int i=0;i<138;i++){
		for (int j=0;j<63;j++){
		    System.out.print(myTable[i][j]);
		}
		System.out.println();
	    }
	    
	    
	} catch (FileNotFoundException e) {
	    System.out.println("Parse Table file not found");
	} catch (IOException e) {
	    System.out.println("Parse Table error");
	} 
    
    }

    public static void main(String[] args) {
	initializeTable();
    }

}
