package commands;

import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;
import simulationObjects.Turtle;


public class EqualP extends Command {

	public EqualP(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			
			return String.valueOf((Double.parseDouble(args[0]) == Double.parseDouble(args[1]))? 1:0);

		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
