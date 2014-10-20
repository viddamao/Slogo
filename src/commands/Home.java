package commands;

import simulationObjects.Turtle;
import exceptions.ParsingException;

public class Home extends CommandTurtles{

	public Home(Turtle m) {
		super(m);
	}

	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{

			double curX = t.getPosition().x;
			double curY = t.getPosition().y;

			double distance = Math.sqrt(Math.pow(curX, 2)+Math.pow(curY, 2));

			t.setPosition((double)0,(double) 0);
			t.setRotation(90);

			return String.valueOf(distance);
		}catch(Exception e){
			throw new ParsingException(e);
		}
	}

}
