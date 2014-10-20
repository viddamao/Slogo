package compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import simulationObjects.Turtle;
import compiler.AST;
import commands.Command;
import compiler.TokenFinder.Type;
import exceptions.ParsingException;
import exceptions.SyntaxErrorException;

public class Compiler {
    public Compiler() {

    }

    private ParseTable myParseTable = new ParseTable();
    public ArrayList<HashMap<String, String>> move = new ArrayList<>();
    public ArrayList<HashMap<String, Integer>> nextState = new ArrayList<>();
    private static List<SymbolTableEntry> symbolTable = new ArrayList<>();
    private HashMap<String, String> grammar = new HashMap<>();
    private HashMap<String, String> dictionary = new HashMap<>();

    Stack<Integer> state = new Stack<Integer>();
    Stack<String> symbol = new Stack<String>();
    private String[] lhs = new String[61];
    private int[] rhs;
    private String language = "";

    /**
     * 
     * @param inputBuffer
     * @return
     * @throws ParsingException
     */
    private String scanner(String inputBuffer) throws ParsingException {
	inputBuffer = inputBuffer.toUpperCase();
	if (language != "English")
	    inputBuffer = translateToEnglish(inputBuffer);
	String[] split = inputBuffer.split(" ");
	Type[] tokens = TokenFinder.tokenize(split);

	for (int i = 0; i < split.length; i++) {
	    if (grammar.containsKey(split[i])) {
		inputBuffer = inputBuffer.replaceFirst(split[i],
			grammar.get(split[i]));
		split[i] = grammar.get(split[i]);
	    }
	}

	symbolTableGeneration(split, tokens);
	for (int i = 0; i < tokens.length; i++) {
	    if (tokens[i] == Type.CONSTANT)
		inputBuffer = inputBuffer.replaceFirst(split[i], "CONSTANT");
	    if (tokens[i] == Type.VARIABLE)
		inputBuffer = inputBuffer.replaceFirst(split[i], "VARIABLE");
	}
	return inputBuffer;
    }

    private String translateToEnglish(String inputBuffer) {
	String[] split = inputBuffer.split(" ");

	for (int i = 0; i < split.length; i++) {
	    if (dictionary.containsKey(split[i])) {
		inputBuffer = inputBuffer.replaceFirst(split[i],
			dictionary.get(split[i]));
	    }
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
		symbolTable.add(currentEntry);
		break;
	    case CONSTANT:
		currentEntry.setValue(Double.parseDouble(split[i]));
		symbolTable.add(currentEntry);
		break;
	    default:
		break;

	    }

	}

    }

    /**
     * 
     * Use the modified inputBuffer to construct a derivation list to get the
     * program
     * 
     * @param String
     *            modified inputBuffer
     * @return Stack<Integer> derivation Rules
     * @throws ParsingException
     */
    private Stack<Integer> interpreter(String input) throws ParsingException {
	System.out.println(input);

	Stack<Integer> sequence = new Stack<Integer>();
	String lookahead = "", currentLHS = "", program = input;
	String entry_action = "";
	int currentState = 0, currentRHS = 0, entry_next = 0;
	program = program.concat(" $");

	lookahead = program.split(" ")[0];
	program = program.substring(program.indexOf(" ") + 1);
	state.push(0);
	entry_action = move.get(currentState).get(lookahead);
	entry_next = nextState.get(currentState).get(lookahead);
	  
	while (!program.equals("")) {

	    System.out.println();
	    System.out.println(currentState);
	    System.out.println(lookahead);
	    System.out.println(entry_action);
	    System.out.println(entry_next);

	    switch (entry_action) {
	    case "a":
		System.out.println("ACCEPT");
		return sequence;
	    case "x":
		throw new SyntaxErrorException();
	    case "s":
		symbol.push(lookahead);
		currentState = entry_next;
		state.push(currentState);

		lookahead = program.split(" ")[0];
		program = program.substring(program.indexOf(" ") + 1);

		break;

	    case "r":

		sequence.push(entry_next);
		currentLHS = lhs[entry_next];
		currentRHS = rhs[entry_next];
		System.out.println(currentLHS);
		System.out.println(currentRHS);

		int i = 0;
		while (i < currentRHS) {
		    state.pop();
		    symbol.pop();
		    i++;
		}

		symbol.push(currentLHS);
		currentState = (Integer) nextState.get(state.peek()).get(
			symbol.peek());
		state.push(currentState);
		break;

	    case "m":

		currentState = (Integer) nextState.get(state.peek()).get(
			symbol.peek());
		break;

	   
	    }
	    entry_action = move.get(currentState).get(lookahead);
	    entry_next = nextState.get(currentState).get(lookahead);
		
	}

	return null;

    }

    /**
     * 
     * initilize tables needed for parsing
     */
    private void initialize() {
	initGrammar();
	myParseTable.initializeTable();
	move = myParseTable.getOperation();
	nextState = myParseTable.getNextState();
	lhs = myParseTable.getLHS();
	rhs = myParseTable.getRHS();
	

    }

    private void initGrammar() {
	try {

	    String language = "English", currentLine = "", key = "", value = "";
	    grammar.clear();

	    @SuppressWarnings("resource")
	    BufferedReader in = new BufferedReader(new FileReader(
		    ".\\src\\dictionary\\English.txt"));
	    while (in.ready()) {
		currentLine = in.readLine();
		key = currentLine.split(" ")[0];
		value = currentLine.split(" ")[1];
		grammar.put(key, value);
	    }

	    if (language != "English") {
		in = new BufferedReader(new FileReader(".\\src\\dictionary\\"
			+ language + ".txt"));
		while (in.ready()) {
		    currentLine = in.readLine();
		    key = currentLine.split(" ")[1].toUpperCase();
		    value = currentLine.split(" ")[0].toUpperCase();
		    dictionary.put(key, value);
		}
	    }

	} catch (FileNotFoundException e) {
	    System.out.println("Grammar File Not Found");
	} catch (IOException e) {
	    e.printStackTrace();
	}

    }

    public static void main(String[] args) throws Exception {
	String inputString = "IF AND 0 1 [ FD 50 ]";
	Compiler myCompiler = new Compiler();
	myCompiler.compile(inputString);
    }

    /**
     * 
     * take the input passed from MainController and compile the input program
     * 
     * 
     * @param input
     * @return
     * @throws ParsingException
     */
    public Command<Turtle, Void> compile(String input)
	    throws ParsingException {

	initialize();
	Stack<Integer> sequence = interpreter(scanner(input));

	//System.out.println(input);
	System.out.println();
	// for (int i=0;i<symbolTable.size();i++){
	// System.out.println(symbolTable.get(i).getValue());}

	Stack<Integer> reversedStack = new Stack<>();
	try {
	    while (!sequence.empty()) {
		System.out.println(sequence.peek());
		reversedStack.push(sequence.pop());

	    }
	} catch (NullPointerException e) {
	    System.out.println("Null Pointer~");

	}

	
	AST myAST = new AST();
	System.out.println("-------------------");
	return myAST.traverse(myAST.generate(reversedStack));
    }

    public List<SymbolTableEntry> getSymbolTable() {
	return symbolTable;
    }

}
