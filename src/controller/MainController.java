package controller;

import java.util.ArrayList;

import simulationObjects.Turtle;
import commands.Command;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {
	private Compiler compiler = new Compiler();
	private Turtle turtle = new Turtle();
	
    public void passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {
    	ArrayList<Command> commands = compiler.compile(input);
    	for(Command c : commands) {
    		c.apply(turtle);
    	}
    }
    
    public Turtle getTurtle() {
    	return turtle.clone();
    }
}
