package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;

public class ShowTurtle extends CommandTurtles{

	public ShowTurtle(Turtle m) {
		super(m);
	}

	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			
			t.setVisible(true);

			return "1";
		}catch(Exception e){
			throw new ParsingException(e);
		}
	}

}
