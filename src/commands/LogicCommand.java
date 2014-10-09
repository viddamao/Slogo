package commands;

public abstract class LogicCommand extends Command {
	@Override
	public CommandType getCommandType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract boolean getResult();
}
