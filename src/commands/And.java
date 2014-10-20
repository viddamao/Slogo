package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class And extends Command {

	public And(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String args[]) throws ParsingException{
		try{
		    	double val1=Double.parseDouble(args[0]);
		    	double val2=Double.parseDouble(args[1]);
		    	
			return String.valueOf((val1==1) && (val2==1)? 1:0);

		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

	
}