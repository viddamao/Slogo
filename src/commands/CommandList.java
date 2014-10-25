package commands;

import exceptions.InvalidArgumentsException;
import simulationObjects.Point;
import simulationObjects.Turtle;

public class CommandList {
	
	public static Command<Turtle, Void> forwardCommand(double forwardBy) {
	    	final double copyVal = forwardBy;
		return new Command<Turtle, Void>() {
			@Override
			public String run(Turtle params) {
				double x_pos = params.getPosition().x;
				double y_pos = params.getPosition().y;
				double radians = Math.toRadians(params.getRotation());

				double new_x = x_pos - Math.cos(radians)*copyVal;
				double new_y = y_pos - Math.sin(radians)*copyVal;
				params.setPosition(new Point(new_x, new_y));
				return String.valueOf(forwardBy);

			}
		};
	}
	
	public static Command<Turtle, Void> turnCommand(final double rot) {
		return new Command<Turtle, Void>() {
			@Override
			public String run(Turtle params) {
			    	System.out.println(params.getRotation());
			    	System.out.println(rot);
			    	
				params.setRotation(params.getRotation() + rot);
				return String.valueOf(params.getRotation() + rot);
			}
		};
	}

	public static Command<Turtle, Void> SetXY(double val1, double val2) {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    	double curX = params.getPosition().x;
			double curY = params.getPosition().y;
			
			double desiredX = val1;
			double desiredY = val2;
			
			double d = Math.sqrt(Math.pow(curX-desiredX, 2) + Math.pow(curY-desiredY, 2));
			
			params.setPosition(new Point(val1,val2));
			return String.valueOf(d);
		}
	};
	}

	public static Command<Turtle, Void> towards(double val1, double val2) {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
			double dAngle = 0;

			double headingX = val1 - params.getPosition().x ;
			double headingY = val2 - params.getPosition().y;

			dAngle = Math.atan2(headingY,headingX) * 180/Math.PI;

			params.setRotation(dAngle);


			return String.valueOf(dAngle);

		
		}
	};
	}

	public static Command<Turtle, Void> clearScreen() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    	double curX = params.getPosition().x;
			double curY = params.getPosition().y;

			double distance = Math.sqrt(Math.pow(curX, 2)+Math.pow(curY, 2));
			params.getPen().clearLines();
			params.setPosition(new Point(370.0, 300.0));
			params.setRotation(90);
			
			return String.valueOf(distance);

		
		}
	};
	}

	public static Command<Turtle, Void> xCor() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    return String.valueOf(params.getPosition().x);

		
		}
	};
	   
	}

	public static Command<Turtle, Void> yCor() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    return String.valueOf(params.getPosition().y);
		}
	};
	}

	public static Command<Turtle, Void> heading() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    return String.valueOf(params.getRotation());
		}
	};
	}

	public static Command<Turtle, Void> penDownP() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    return String.valueOf(params.getPen().getActive());		
		}
	};
	}

	public static Command<Turtle, Void> showingP() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    return String.valueOf(params.getVisible());	
		}
	};
	}

	public static Command<Turtle, Void> penDown() {
	    return new Command<Turtle, Void>() {
		@Override
		public String run(Turtle params) {
		    params.getPen().setActive(true);

			return "1";	
		}
	};
	}

	public static Command<Turtle, Void> penUp() {
	    return new Command<Turtle, Void>() {
	  		@Override
	  		public String run(Turtle params) {
	  		    params.getPen().setActive(false);

	  			return "0";	
	  		}
	  	};
	}

	public static Command<Turtle, Void> showTurtle() {
	    return new Command<Turtle, Void>() {
  		@Override
  		public String run(Turtle params) {
  		  params.setVisible(true);

  		return "1";
  		}
  	};
	   
	}

	public static Command<Turtle, Void> hideTurtle() {
	    return new Command<Turtle, Void>() {
  		@Override
  		public String run(Turtle params) {
  		  params.setVisible(false);

  		return "0";
  		}
  	};
	}
	
	
	public static Command<Turtle, Void> setPenWidth(double val) {
	    return new Command<Turtle, Void>() {
  		@Override
  		public String run(Turtle params) {
  		  params.getPen().setWidth(val);

			return String.valueOf(val);
  		}
  	};
	}
}
