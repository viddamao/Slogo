package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Towards extends CommandTurtles{

	public Towards(Turtle m) {
		super(m);
	}


	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			double dAngle = 0;

			double headingX = Double.parseDouble(args[0]) - t.getPosition().x ;
			double headingY = Double.parseDouble(args[1]) - t.getPosition().y;

			dAngle = Math.atan2(headingY,headingX) * 180/Math.PI;

			t.setRotation(dAngle);


			return String.valueOf(dAngle);

		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
