package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Pow extends Command{

	public Pow(Turtle m) {
		super(m);
		
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			return String.valueOf(Math.pow(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}


}