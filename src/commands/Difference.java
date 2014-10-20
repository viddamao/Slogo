package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Difference extends Command{

	public Difference(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String args[]) throws ParsingException{
		// TODO Auto-generated method stub
		
		try{

			double sub = Double.parseDouble(args[0]);
			
			for(int i = 1; i <= args.length -1 ; i ++){
				sub -= Double.parseDouble(args[i]);
			}
			return String.valueOf(sub);
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}



}
