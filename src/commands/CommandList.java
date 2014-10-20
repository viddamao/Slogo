package commands;

import simulationObjects.Turtle;

public class CommandList {
	
	public static Command<Turtle, Void> forwardCommand(double forwardBy) {
	    	final double copyVal = forwardBy;
		return new Command<Turtle, Void>() {
			@Override
			public Void run(Turtle params) {
				double x_pos = params.getPosition().x;
				double y_pos = params.getPosition().y;
				double radians = Math.toRadians(params.getRotation());

				double new_x = x_pos - Math.cos(radians)*copyVal;
				double new_y = y_pos - Math.sin(radians)*copyVal;
				params.setPosition(new_x, new_y);
				return null;
			}
		};
	}
	
	public static Command<Turtle, Void> turnCommand(final double clockwiseDegrees) {
		return new Command<Turtle, Void>() {
			@Override
			public Void run(Turtle params) {
				params.setRotation(params.getRotation() + clockwiseDegrees);
				return null;
			}
		};
	}
}
