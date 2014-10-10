package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import simulationObjects.Turtle;
import commands.Command;
import compiler.TokenFinder.Type;
import exceptions.ParsingException;
import exceptions.SyntaxErrorException;
import exceptions.UnbalancedBracketsException;

public class Compiler {
    public Compiler() {

    }

    private ParseTable myParseTable=new ParseTable();
    @SuppressWarnings("rawtypes")
    public ArrayList<HashMap> move = new ArrayList<HashMap>();
    @SuppressWarnings("rawtypes")
    public ArrayList<HashMap> nextState = new ArrayList<HashMap>();
    private List<SymbolTableEntry> symbolTable = new ArrayList<>();
    Stack<Integer> state = new Stack<Integer>();
    Stack<String> symbol = new Stack<String>();
    private String[] lhs;
    private int[] rhs;

    private Type[] scanner(String inputBuffer) throws ParsingException {
	String[] split = inputBuffer.split(" ");
	Type[] tokens = TokenFinder.tokenize(split);
	bracketPairCheck(tokens);
	symbolTableGeneration(split, tokens);
	/*for (int i = 0; i < tokens.length; i++) {
	    System.out.print(symbolTable.get(i).getType());
	    System.out.print(" ");
	    System.out.print(symbolTable.get(i).getName());
	    System.out.print(" ");
	    System.out.println(symbolTable.get(i).getValue());

	}*/

	return tokens;
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


   
    private Stack<Integer> interpreter(String input) throws ParsingException {
	try{
	Stack<Integer> sequence = new Stack<Integer>();
	String lookahead = "", temp = "", program=input;
	int currentstate = 0, temp1 = 0;
	program = program.concat("$");
	lookahead = program.split(" ")[0];
	program = program.substring(program.indexOf(" ")+1);
	
	state.push(0);
	while (!program.equals("")) {

	    currentstate = state.peek();
	    if (move.get(currentstate).get(lookahead).equals("s")) {

		currentstate = (Integer) nextState.get(currentstate).get(
			lookahead);
		state.push(currentstate);
		symbol.push(lookahead);
		lookahead = program.substring(0, 1);
		program = program.substring(1);

	    }

	   
	    currentstate = state.peek();
	    if (move.get(currentstate).get(lookahead).equals("r")) {
		int i = 0;
		sequence.push((Integer) nextState.get(currentstate).get(
			lookahead));
		temp = lhs[(Integer) nextState.get(currentstate).get(lookahead)];
		temp1 = rhs[(Integer) nextState.get(currentstate)
			.get(lookahead)];

		while (i < temp1) {
		    currentstate = (Integer) state.pop();
		    symbol.pop();
		    i++;
		}

		symbol.push(temp);
		currentstate = (Integer) nextState.get(state.peek()).get(
			symbol.peek());
		state.push(currentstate);

	    }

	    currentstate = state.peek();
	    if (move.get(currentstate).get(lookahead).equals("m")) {

		currentstate = (Integer) nextState.get(state.peek()).get(
			symbol.peek());

	    }

	    currentstate = state.peek();
	    if (move.get(currentstate).get(lookahead).equals("a")) {
		System.out.println("ACCEPT");
		return sequence;
	    }

	    currentstate = state.peek();
	    if (move.get(currentstate).get(lookahead).equals("x")) {
		throw new SyntaxErrorException();
	    }
	    
	}
	return null;
	}
	catch (NullPointerException e){
	  System.out.println(state);  
	}
	return null;
    }

    public static void main(String[] args) throws Exception {
	String inputString = "FD 50";
	Compiler myCompiler=new Compiler();
	myCompiler.compile(inputString);
    }

  
    private void initialize() {
	
	myParseTable.initializeTable();
	move = myParseTable.getOperation();
	nextState=myParseTable.getNextState();
	lhs=myParseTable.getLHS();
	rhs=myParseTable.getRHS();	
	for (int i=0;i<60;i++){
	    
	}

    }

    public ArrayList<Command<Turtle, Void>> compile(String input)
	    throws ParsingException {
	initialize();
	scanner(input);
	interpreter(input);
	// "add 20;"
	final int val = 20;

	ArrayList<Command<Turtle, Void>> ret = new ArrayList<Command<Turtle, Void>>();
	Command<Turtle, Void> c = new Command<Turtle, Void>() {
	    @Override
	    public Void run(Turtle turtle) {
		turtle.setPosition(turtle.getPosition().x + val,
			turtle.getPosition().y);
		return null;
	    }
	};
	ret.add(c);

	return ret;
    }

}
