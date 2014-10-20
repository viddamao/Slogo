package commands;

import simulationObjects.Turtle;
import exceptions.InvalidArgumentsException;
import exceptions.ParsingException;

public class Product extends Command{

	public Product(Turtle m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doCommand(String[] args) throws ParsingException{
		try{
			double product = Double.parseDouble(args[0]);
			for(int i = 1; i < args.length; i++){
				product *= Double.parseDouble(args[i]);
			}
			return String.valueOf(product);
		}
		catch(Exception e){
			throw new InvalidArgumentsException(e);
		}
	}

}
