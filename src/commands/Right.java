package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Right extends CommandTurtles{

	public Right(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			double newRot = 0;
			for (String rotDegrees : args){
				newRot += Double.parseDouble(rotDegrees);
			}

			double rot = t.getRotation();
			t.setRotation(rot - newRot);

			return String.valueOf(newRot);
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
