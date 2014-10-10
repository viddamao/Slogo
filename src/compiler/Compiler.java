package compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import simulationObjects.Turtle;
import commands.Command;
import compiler.AST.Node;
import compiler.TokenFinder.Type;
import exceptions.ParsingException;
import exceptions.SyntaxErrorException;
import exceptions.UnbalancedBracketsException;

public class Compiler {
    public Compiler() {

    }

    private ParseTable myParseTable = new ParseTable();
    public ArrayList<HashMap<String, String>> move = new ArrayList<>();
    public ArrayList<HashMap<String, Integer>> nextState = new ArrayList<>();
    private List<SymbolTableEntry> symbolTable = new ArrayList<>();
    private Queue<Node> syntaxTree = new LinkedList<Node>();
    Stack<Integer> state = new Stack<Integer>();
    Stack<String> symbol = new Stack<String>();
    private String[] lhs;
    private int[] rhs;

    
    /**
     * 
     * @param inputBuffer
     * @return
     * @throws ParsingException
     */
    private String scanner(String inputBuffer) throws ParsingException {
	String[] split = inputBuffer.split(" ");
	Type[] tokens = TokenFinder.tokenize(split);
	symbolTableGeneration(split, tokens);
	System.out.println(tokens.length);
	for (int i = 0; i < tokens.length; i++) {
	    if (tokens[i] == Type.CONSTANT)
		inputBuffer=inputBuffer.replaceFirst(split[i],"CONSTANT");
	    if (tokens[i] == Type.VARIABLE)
		inputBuffer=inputBuffer.replaceFirst(split[i],"VARIABLE");
	}

	return inputBuffer;
    }

    
    /**
     * 
     * 
     * 
     * @param split
     * @param tokens
     */
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

    
   
    /**
     * 
     * Use the modified inputBuffer to construct a derivation list to get the program
     * 
     * @param   String modified inputBuffer
     * @return	Stack<Integer> derivation Rules
     * @throws ParsingException
     */
    private Stack<Integer> interpreter(String input) throws ParsingException {
	try {
	    Stack<Integer> sequence = new Stack<Integer>();
	    String lookahead = "", currentLHS = "", program = input;
	    int currentState = 0, currentRHS = 0;
	    program = program.concat(" $");

	    lookahead = program.split(" ")[0];
	    program = program.substring(program.indexOf(" ") + 1);

	    state.push(0);
	    while (!program.equals("")) {

		System.out.println(program);
		System.out.println(lookahead);
		System.out.println(currentState);
		System.out.println(state);
		System.out.println(symbol);
		System.out.println();

		currentState = state.peek();
		if (move.get(currentState).get(lookahead).equals("s")) {

		    currentState = nextState.get(currentState).get(lookahead);
		    state.push(currentState);
		    symbol.push(lookahead);
		    lookahead = program.split(" ")[0];
		    program = program.substring(program.indexOf(" ") + 1);

		}

		System.out.println(program);
		System.out.println(lookahead);
		System.out.println(currentState);
		System.out.println(state);
		System.out.println(symbol);
		System.out.println();

		currentState = state.peek();
		if (move.get(currentState).get(lookahead).equals("r")) {
		    int i = 0;
		    sequence.push((Integer) nextState.get(currentState).get(
			    lookahead));
		    currentLHS = lhs[(Integer) nextState.get(currentState).get(
			    lookahead)];
		    currentRHS = rhs[(Integer) nextState.get(currentState).get(
			    lookahead)];

		    while (i < currentRHS) {
			currentState = (Integer) state.pop();
			symbol.pop();
			i++;
		    }

		    symbol.push(currentLHS);
		    currentState = (Integer) nextState.get(state.peek()).get(
			    symbol.peek());
		    state.push(currentState);

		}

		currentState = state.peek();
		if (move.get(currentState).get(lookahead).equals("m")) {

		    currentState = (Integer) nextState.get(state.peek()).get(
			    symbol.peek());

		}

		currentState = state.peek();
		if (move.get(currentState).get(lookahead).equals("a")) {
		    System.out.println("ACCEPT");
		    return sequence;
		}

		currentState = state.peek();
		if (move.get(currentState).get(lookahead).equals("x")) {
		    throw new SyntaxErrorException();
		}

	    }
	    return null;
	} catch (NullPointerException e) {
	    System.out.println("Null Pointer");
	    System.out.println(state);
	}
	return null;
    }

    public static void main(String[] args) throws Exception {
	String inputString = "FD 50 LT 90";
	Compiler myCompiler = new Compiler();
	myCompiler.compile(inputString);
    }

    
    /**
     * 
     * initilize tables needed for parsing
     */
    private void initialize() {

	myParseTable.initializeTable();
	move = myParseTable.getOperation();
	nextState = myParseTable.getNextState();
	lhs = myParseTable.getLHS();
	rhs = myParseTable.getRHS();

    }

    
    private void generateAST(Stack<Integer> sequence){
	
	
    }
    
    /**
     * 
     * take the input passed from MainController
     * and compile the input program
     * 
     * 
     * @param input
     * @return
     * @throws ParsingException
     */
    public ArrayList<Command<Turtle, Void>> compile(String input)
	    throws ParsingException {
	initialize();
	generateAST(interpreter(scanner(input)));
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
