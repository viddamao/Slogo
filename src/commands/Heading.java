package commands;

import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;
import simulationObjects.Turtle;


public class Heading extends Command {

	public Heading(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{

		try{
			Turtle turtle = m.getTurtle();
			//returning heading of the last turtle in the active list
			return String.valueOf(turtle.getRotation());
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
