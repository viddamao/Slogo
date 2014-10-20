package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Random extends Command{
	//does not include the input number as a random output. its from 0 to but not including the parameter
	
	public Random(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String doCommand(String[] args) throws ParsingException {
		try{
			java.util.Random rand = new java.util.Random();
			double randNum = Double.parseDouble(args[0])*rand.nextDouble();
			
			return String.valueOf(randNum);
			
		}catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
