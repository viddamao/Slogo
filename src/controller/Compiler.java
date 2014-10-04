package controller;

import controller.TokenFinder.Type;
import exceptions.ParsingException;

public class Compiler {
    private static Compiler myCompiler;

   
	
   
    private void scanner(String inputBuffer) throws ParsingException {
	String[] inputSplit = inputBuffer.split(" ");
	System.out.println(inputSplit[1]);
	Type[] tokens=TokenFinder.tokenize(inputSplit);
	
    }


    public static void main(String[] args) throws Exception {
	String inputString = "fd 50";
	myCompiler = new Compiler();
	myCompiler.scanner(inputString);
    }

}
