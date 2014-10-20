package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Sin extends Command{

	public Sin(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException {
		try{

			return String.valueOf(Math.sin(Double.parseDouble(args[0])));
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
