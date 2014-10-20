package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;


public abstract class Command{
	
	public static final String DEFAULT_ERROR = "Error: invalid arguments.";
	
	Turtle m;
	
	public Command(Turtle m){
		this.m = m;
	}
	
	
	

	public abstract String doCommand(String[] args) throws ParsingException;
	
}
