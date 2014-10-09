package commands;

public abstract class Command {
	public enum CommandType {
		TURTLE_APPLY, TURTLE_QUERY, MATH, LOGIC
	}
	
	public abstract CommandType getCommandType();
}
