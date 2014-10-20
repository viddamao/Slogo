package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Log extends Command{

	public Log(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{

			return String.valueOf(Math.log(Double.parseDouble(args[0])));
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

	
}