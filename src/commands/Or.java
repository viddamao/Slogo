package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Or extends Command {

	public Or(Turtle m) {
		super(m);
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
		
			return String.valueOf(((Double.parseDouble(args[0]) != 0.0) || (Double.parseDouble(args[1]) != 0.0))? 1:0);

		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

	
}