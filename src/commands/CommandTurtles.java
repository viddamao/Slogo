package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;

public abstract class CommandTurtles extends Command {

	public CommandTurtles(Turtle m) {
		super(m);
	}
	
	public String doCommand(String args[]) throws ParsingException{
		String result = "";
		Turtle t = m.getTurtle();
			result = execute ( t, args);

		return result;
	}
	
	public abstract String execute(Turtle t, String[] args) throws ParsingException ;

}
