package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;

public class HideTurtle extends CommandTurtles{

	public HideTurtle(Turtle m) {
		super(m);
	}

	
	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			t.setVisible(false);
			return "0";
		}catch(Exception e){
			throw new ParsingException(e);
		}
	}

}
