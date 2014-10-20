package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Quotient extends Command{

	public Quotient(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			double quotient = Double.parseDouble(args[0]);

			for(int i = 1; i <= args.length -1 ; i ++){
				quotient /= Double.parseDouble(args[i]);
			}
			return String.valueOf(quotient);
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
