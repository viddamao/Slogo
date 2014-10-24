package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import simulationObjects.Point;
import simulationObjects.Turtle;
import commands.Command;
import commands.CommandList;
import compiler.Compiler;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	private int SCENE_WIDTH = 1280;
	private int SCENE_HEIGHT = 720;
	private Compiler compiler = new Compiler();
	private Turtle turtle = new Turtle();
	private List<String> history = new ArrayList<String>();

    private Map<String, ArrayList<Command<Turtle, Void>>> cache = new HashMap<String, ArrayList<Command<Turtle, Void>>>();

    public void MainController() {
    	turtle.setPosition(new Point(SCENE_WIDTH/2, SCENE_HEIGHT/2));
    }
    
    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
		history.add(input);
		ArrayList<Command<Turtle, Void>> commands;
	
		if (false) {
		    commands = cache.get(input);
		} else {
		    commands = new ArrayList<Command<Turtle, Void>>();
		    commands=compiler.compile(input);
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
