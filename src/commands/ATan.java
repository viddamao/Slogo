package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class ATan extends Command{

	public ATan(Turtle m) {
		super(m);
		}
	
	@Override
	public String doCommand(String args[]) throws ParsingException{
		try{

			return String.valueOf(Math.atan(Double.parseDouble(args[0])));
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}


}