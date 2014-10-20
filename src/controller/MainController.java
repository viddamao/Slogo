package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulationObjects.Turtle;
import commands.Command;
import compiler.Compiler;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	
	private Compiler compiler = new Compiler();
	private Turtle turtle;
	private List<String> history;

    private Map<String, ArrayList<Command<Turtle, Void>>> cache = new HashMap<String, ArrayList<Command<Turtle, Void>>>();

    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
	history.add(input);
	ArrayList<Command<Turtle, Void>> commands;

	if (cache.containsKey(input)) {
	    commands = cache.get(input);
	} else {
	    commands = compiler.compile(input);
	    cache.put(input, commands);
	}

	for (Command<Turtle, Void> c : commands) {
	    c.run(turtle);
	}
    }

    public Turtle getTurtle() {
	return new Turtle(turtle);
    }
    
    public List<String> getHistory() {
    	return new ArrayList<String>(history);
    }
}
