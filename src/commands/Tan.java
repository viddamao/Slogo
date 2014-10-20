package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Tan extends Command{

	public Tan(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{

			return String.valueOf(Math.tan(Double.parseDouble(args[0])));
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}