package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Minus extends Command{

	public Minus(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
		return String.valueOf((Double.parseDouble(args[0])*(-1.0)));
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}


}
