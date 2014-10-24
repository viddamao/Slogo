package commands;

import exceptions.InvalidArgumentsException;
import simulationObjects.Point;
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

	public static Command<Turtle, Void> SetXY(double val1, double val2) {
	    return new Command<Turtle, Void>() {
		@Override
		public Void run(Turtle params) {
			params.setPosition(new Point(val1,val2));
			return null;
		}
	};
	}

	public static Command<Turtle, Void> towards(double val1, double val2) {
	    return new Command<Turtle, Void>() {
		@Override
		public Void run(Turtle params) {
			double dAngle = 0;

			double headingX = val1 - params.getPosition().x ;
			double headingY = val2 - params.getPosition().y;

			dAngle = Math.atan2(headingY,headingX) * 180/Math.PI;

			params.setRotation(dAngle);


			return null;

		
		}
	};
	}

	public static Command<Turtle, Void> clearScreen() {
	    return new Command<Turtle, Void>() {
		@Override
		public Void run(Turtle params) {
		    	double curX = params.getPosition().x;
			double curY = params.getPosition().y;

			double distance = Math.sqrt(Math.pow(curX, 2)+Math.pow(curY, 2));

			params.setPosition((double)0, (double)0);
			params.setRotation(90);
			
			return null;

		
		}
	};
	}
	
}
