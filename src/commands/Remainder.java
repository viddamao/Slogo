package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Remainder extends Command{

	public Remainder(Turtle t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			double remainder = Double.parseDouble(args[0]);
			
			for(int i = 1; i <= args.length -1 ; i ++){
				remainder %= Double.parseDouble(args[i]);
			}
			
			if(remainder == -0.0){
				return String.valueOf(Math.abs(remainder));
			}
			return String.valueOf(remainder);
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
