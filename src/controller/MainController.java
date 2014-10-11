package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import simulationObjects.Turtle;
import commands.Command;
import compiler.Compiler;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	private Compiler compiler = new Compiler();
	private Turtle turtle;
	private ArrayList<String> history = new ArrayList<String>();

	private Map<String, ArrayList<Command<Turtle, Void>>> cache = new HashMap<String, ArrayList<Command<Turtle, Void>>>();

	
    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
    	history.add(input);
    	ArrayList<Command<Turtle, Void>> commands;

    	if(cache.containsKey(input)) {
    		commands = cache.get(input);
    	} else {
    		commands = compiler.compile(input);
        	cache.put(input, commands);
    	}

    	for(Command<Turtle, Void> c : commands) {
    		c.run(turtle);
    	}
    }
    
    public Turtle getTurtle() throws FileNotFoundException {
    	return new Turtle(turtle);
    }
    
    public ArrayList<String> getHistory() {
    	return new ArrayList<String>(history);
    }
}
