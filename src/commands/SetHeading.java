package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class SetHeading extends CommandTurtles{

	public SetHeading(Turtle m) {
		super(m);
	}

	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			double curAngle = 0;
			double desiredAngle =0;
			curAngle = t.getRotation();
			desiredAngle = Double.parseDouble(args[0]);
			t.setRotation(desiredAngle);
			return String.valueOf(desiredAngle - curAngle);
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
