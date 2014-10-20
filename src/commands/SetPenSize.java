package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class SetPenSize extends CommandTurtles{

	public SetPenSize(Turtle m) {
		super(m);
	}

	
	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			
			t.getPen().setWidth(Double.parseDouble(args[0]));

			return args[0];
		}catch (Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
