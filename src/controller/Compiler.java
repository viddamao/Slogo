package controller;

import exceptions.ParsingException;

public class Compiler {
    private static Compiler myCompiler;

   
	
   
    private String scanner(String inputBuffer) throws ParsingException {
	String[] inputSplit = inputBuffer.split(" ");
	System.out.println(inputSplit[1]);
	System.out.println(TokenFinder.tokenize(inputSplit)[1]);
	return inputBuffer;
    }


    public static void main(String[] args) throws Exception {
	String inputString = "fd 50";
	myCompiler = new Compiler();
	myCompiler.scanner(inputString);
    }

}
