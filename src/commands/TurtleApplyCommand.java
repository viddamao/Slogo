package commands;

import simulationObjects.Turtle;

public abstract class TurtleApplyCommand extends Command {
	@Override
	public CommandType getCommandType() {
		return Command.CommandType.MATH;
	}
	
	public abstract void apply(Turtle turtle);
}
