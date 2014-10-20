package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Cos extends Command{

	public Cos(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String args[]) throws ParsingException{

		try{

			return String.valueOf(Math.cos(Double.parseDouble(args[0])));
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

	
}