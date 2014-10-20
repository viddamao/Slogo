package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class SetXY extends CommandTurtles{

	public SetXY(Turtle m) {
		super(m);
	}

	
	@Override
	public String execute(Turtle t, String[] args) throws ParsingException {
		try{
			
			double curX = t.getPosition().x;
			double curY = t.getPosition().y;
			
			double desiredX = Double.parseDouble(args[0]);
			double desiredY = Double.parseDouble(args[1]);
			
			double d = Math.sqrt(Math.pow(curX-desiredX, 2) + Math.pow(curY-desiredY, 2));
			
			t.setPosition(desiredX, desiredY);
			return String.valueOf(d);
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
