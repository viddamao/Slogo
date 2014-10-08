package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import simulationObjects.Turtle;
import commands.Command;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	private Compiler compiler = new Compiler();
	private Turtle turtle = new Turtle();
	private ArrayList<String> history = new ArrayList<String>();
	private Map<String, ArrayList<Command>> cache = new HashMap<String, ArrayList<Command>>();
	
    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
    	history.add(input);
    	ArrayList<Command> commands;
    	if(cache.containsKey(input)) {
    		commands = cache.get(input);
    	} else {
    		commands = compiler.compile(input);
        	cache.put(input, commands);
    	}
    	for(Command c : commands) {
    		c.apply(turtle);
    	}
    }
    
    public Turtle getTurtle() {
    	return new Turtle(turtle);
    }
    
    public ArrayList<String> getHistory() {
    	return new ArrayList<String>(history);
    }
}
