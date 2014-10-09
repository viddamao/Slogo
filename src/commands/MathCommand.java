package commands;

public abstract class MathCommand extends Command {
	@Override
	public CommandType getCommandType() {
		return Command.CommandType.MATH;
	}
	
	public abstract double getResult();
}
