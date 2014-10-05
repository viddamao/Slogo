package controller;

import java.util.Stack;

import controller.TokenFinder.Type;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class Compiler {
    private static Compiler myCompiler;

    private void scanner(String inputBuffer) throws ParsingException {
	String[] split = inputBuffer.split(" ");
	Type[] tokens = TokenFinder.tokenize(split);
	for (int i = 0; i < tokens.length; i++) {
	    System.out.print(split[i]);
	    System.out.print(" ");
	    System.out.println(tokens[i]);

	}
	System.out.println(bracketPairCheck(tokens));

    }

    private boolean bracketPairCheck(Type[] tokens)
	    throws UnbalancedBracketsException {

	Stack<Type> brackets = new Stack<>();
	for (int i = 0; i < tokens.length; i++) {
	    switch (tokens[i]) {
	    case LIST_START:
		brackets.push(Type.LIST_START);
		break;
	    case LIST_END:
		if (brackets.peek()!=Type.LIST_START)
		    throw new UnbalancedBracketsException();
		brackets.pop();
		break;
	    case PARENS_START:
		brackets.push(Type.PARENS_START);
		break;
	    case PARENS_END:
		if (brackets.peek()!=Type.PARENS_START)
		    throw new UnbalancedBracketsException();
		brackets.pop();
		break;
	    default:
	    }

	}
	if (brackets.isEmpty())
	    return true;
	throw new UnbalancedBracketsException();
    }

    public static void main(String[] args) throws Exception {
	String inputString = "fd 50 [ ( ) ( ) ]";
	myCompiler = new Compiler();
	myCompiler.scanner(inputString);
    }

}
