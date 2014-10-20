package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;


public class Forward extends CommandTurtles{

	public Forward(Turtle m) {
		super(m);
	}

	
	@Override
	public String execute(Turtle t, String args[]) throws ParsingException {
		try{
			double pixelsMoved = Double.parseDouble(args[0]);

			double x_pos = t.getPosition().x;
			double y_pos = t.getPosition().y;
			double radians = Math.toRadians(t.getRotation());

			double new_x = x_pos - Math.cos(radians)*pixelsMoved;
			double new_y = y_pos - Math.sin(radians)*pixelsMoved;
			t.setPosition(new_x, new_y);

			return String.valueOf(pixelsMoved);

		} catch (Exception e){
			throw new InvalidArgumentsException(e);
		}

	}


}
