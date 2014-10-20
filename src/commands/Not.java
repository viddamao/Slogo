package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Not extends Command{

	public Not(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{

		try{
			return String.valueOf((Double.parseDouble(args[0]) == 0.0) ? 1:0);
			
		}catch(Exception e){
		
			throw new InvalidArgumentsException(e);
		}
	}

}
