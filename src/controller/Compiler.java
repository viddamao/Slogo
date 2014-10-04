package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

import exceptions.ParsingException;

public class Compiler {
    private InfoSheet myInfoSheet = new InfoSheet();
    private ResourceBundle ourProperties;

    @SuppressWarnings("resource")
    private void initializeKeywordTable() throws ParsingException {

	List<String> keywordTable = new ArrayList<>();
	ourProperties = ResourceBundle.getBundle("messages", Locale.US);
	/*Scanner s = new Scanner(new BufferedReader(new FileReader(
		ourProperties.getString("keywordTablePath"))));
	while (s.hasNext()) {
	    keywordTable.add(s.next());
	}*/
	myInfoSheet.setKeywordTable(keywordTable);

    }

    private String scanner(String inputBuffer) throws ParsingException {

	return inputBuffer;
    }

    private void driver() throws ParsingException {
	scanner("ab c");

    }

    public static void main(String[] args) throws ParsingException {

	Compiler myCompiler = new Compiler();
	myCompiler.initializeKeywordTable();
	myCompiler.driver();
    }

}
