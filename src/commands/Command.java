package commands;

import simulationObjects.Turtle;

public interface Command {
	public void apply(Turtle turtle);
}
