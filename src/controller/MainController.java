package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulationObjects.Point;
import simulationObjects.Turtle;
import commands.Command;
import compiler.Compiler;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	
	private Compiler compiler = new Compiler();
	private Turtle turtle = new Turtle();
	private List<String> history = new ArrayList<String>();

    private Map<String, ArrayList<Command<Turtle, Void>>> cache = new HashMap<String, ArrayList<Command<Turtle, Void>>>();

    public void MainController() {
    	turtle.setPosition(new Point(50, 50));
    }
    
    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
		history.add(input);
		ArrayList<Command<Turtle, Void>> commands;
	
		if (cache.containsKey(input)) {
		    commands = cache.get(input);
		} else {
			commands = new ArrayList<Command<Turtle, Void>>();
		    commands.add(compiler.compile(input));
		    cache.put(input, commands);
		}
	
		for (Command<Turtle, Void> c : commands) {
		    c.run(turtle);
		}
    }

    public Turtle getTurtle() {
    	turtle.setPosition(turtle.getPosition().x+100, turtle.getPosition().y+100);
    	return new Turtle(turtle);
    }
    
    public List<String> getHistory() {
    	return new ArrayList<String>(history);
    }
}
