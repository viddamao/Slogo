package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseTable {
    public static String[][] myOperation = new String[137][63];
    public static int[][] nextState = new int[137][63];

    @SuppressWarnings("resource")
    public static void initializeTable() {
	try {
	    BufferedReader in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\parsetable.txt"));
	    String currentNode = "";
	    for (int i = 0; i < 137; i++) {
		String inputBuffer = in.readLine();
		String[] currentLine = inputBuffer.split(" ");
		for (int j = 0; j < 63; j++) {
		    currentNode = currentLine[j];
		    myOperation[i][j] = currentNode.substring(0, 1);

		    switch (currentNode.charAt(0)) {
		    case 'a':
			break;
		    case 'x':

			break;
		    case 's':
			nextState[i][j] = Integer.parseInt(currentNode
				.substring(1));

			break;

		    case 'r':
			nextState[i][j] = Integer.parseInt(currentNode
				.substring(1));

			break;
		    default:
			nextState[i][j] = Integer.parseInt(currentNode
				.substring(0));
			myOperation[i][j] = "g";

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
