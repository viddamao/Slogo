package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class YCor extends Command {

	public YCor(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			Turtle turtle = m.getTurtle();
			return String.valueOf(turtle.getPosition().y);

		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
