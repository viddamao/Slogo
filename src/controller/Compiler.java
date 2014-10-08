package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import controller.TokenFinder.Type;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class Compiler {
    public Compiler() {

    }

    public static Compiler myCompiler;
    private List<SymbolTableEntry> symbolTable = new ArrayList<>();

    private void scanner(String inputBuffer) throws ParsingException {
	String[] split = inputBuffer.split(" ");
	Type[] tokens = TokenFinder.tokenize(split);
	bracketPairCheck(tokens);
	symbolTableGeneration(split, tokens);
	for (int i = 0; i < tokens.length; i++) {
	    System.out.print(symbolTable.get(i).getType());
	    System.out.print(" ");
	    System.out.print(symbolTable.get(i).getName());
	    System.out.print(" ");
	    System.out.println(symbolTable.get(i).getValue());

	}
    }

    private void symbolTableGeneration(String[] split, Type[] tokens) {
	for (int i = 0; i < split.length; i++) {
	    SymbolTableEntry currentEntry = new SymbolTableEntry();
	    currentEntry.setType(tokens[i]);
	    currentEntry.setName(split[i]);

	    switch (tokens[i]) {
	    case VARIABLE:
		currentEntry.setValue(0);
		break;
	    case CONSTANT:
		currentEntry.setValue(Double.parseDouble(split[i]));
		break;
	    default:
		break;

	    }

	    symbolTable.add(currentEntry);

	}

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
		if (brackets.peek() != Type.LIST_START)
		    throw new UnbalancedBracketsException();
		brackets.pop();
		break;
	    case PARENS_START:
		brackets.push(Type.PARENS_START);
		break;
	    case PARENS_END:
		if (brackets.peek() != Type.PARENS_START)
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

    private void interpreter() {

    }

    public static void main(String[] args) throws Exception {
	String inputString = ":t 50";
	myCompiler = new Compiler();
	myCompiler.scanner(inputString);
    }

    public Type[] compile(String input) {
	// TODO Auto-generated method stub
	return null;
    }

}
