package compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseTable {
    @SuppressWarnings("rawtypes")
    public static ArrayList<HashMap> myOperation = new ArrayList<>();
    @SuppressWarnings("rawtypes")
    public static ArrayList<HashMap> nextState = new ArrayList<>();
    private static String[] key=new String[64];

    @SuppressWarnings({ "resource" })
    public static void initializeTable() {
	try {
	    BufferedReader in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\parse_table_keys.txt"));
	    for (int i=0;i<63;i++)
		key[i]=in.readLine();
	    
	    
	    in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\parse_table.txt"));
	    String currentNode = "";
	    for (int i = 0; i < 137; i++) {
		String inputBuffer = in.readLine();
		String[] currentLine = inputBuffer.split(" ");
		HashMap<String, String> opTemp=new HashMap<>();
		HashMap<String, Integer> nextTemp=new HashMap<>();
		
		
		for (int j = 0; j < 63; j++) {
		    currentNode = currentLine[j];
		    opTemp.put(key[i], currentNode.substring(0, 1));
		   

		    switch (currentNode.charAt(0)) {
		    case 'a':
			
			break;
		    case 'x':

			break;
		    case 's':

		    case 'r':
			nextTemp.put(key[i], Integer.parseInt(currentNode
				.substring(1)));

			break;
		    default:
			nextTemp.put(key[i], Integer.parseInt(currentNode
				.substring(1)));
			opTemp.remove(key[i]);
			opTemp.put(key[i], "g");

		    }
		}
	    }

	} catch (FileNotFoundException e) {
	    System.out.println("Parse Table file not found");
	} catch (IOException e) {
	    System.out.println("Parse Table error");
	}

    }

}
