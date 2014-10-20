package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Sum extends Command{

	public Sum(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			double sum = 0;
			for(String s : args){
				sum += Double.parseDouble(s);
			}
			return String.valueOf(sum);
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}
	
}
