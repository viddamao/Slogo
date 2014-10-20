package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class ShowingP extends Command {

	public ShowingP(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{

		try { 
			Turtle turtle = m.getTurtle();
			return String.valueOf(turtle.getVisible() ? 1:0);
			
		}catch(Exception e){
			 throw new InvalidArgumentsException(e);
		}
	}

	
}
