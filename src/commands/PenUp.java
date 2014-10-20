package commands;

import exceptions.ParsingException;
import simulationObjects.Turtle;


public class PenUp extends CommandTurtles{

	public PenUp(Turtle m) {
		super(m);
	}

	
	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			t.getPen().setActive(false);

			return "0";
		}catch(Exception e){
			throw new ParsingException(e);
		}
	}

}
