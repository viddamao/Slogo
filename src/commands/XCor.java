package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class XCor extends Command {

	public XCor(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			Turtle turtle = m.getTurtle();
			return String.valueOf(turtle.getPosition().x);

		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
