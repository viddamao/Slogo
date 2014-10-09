package commands;

import simulationObjects.Turtle;

public abstract class TurtleQuery extends Command {
	@Override
	public CommandType getCommandType() {
		return Command.CommandType.MATH;
	}
	
	public abstract double query(Turtle turtle);
}
