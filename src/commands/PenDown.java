package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;

public class PenDown extends CommandTurtles{

	public PenDown(Turtle m) {
		super(m);
	}


	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			t.getPen().setActive(true);

			return "1";
		}catch(Exception e){
			throw new ParsingException(e);
		}
	}

}
