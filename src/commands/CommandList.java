// This entire file is part of my masterpiece.
// Zachary Podbela

package commands;

import simulationObjects.Point;
import simulationObjects.Turtle;

public class CommandList {

    /**
     * Generate command to move a turtle in the direction it is facing. Used for commands FD and BK.
     * 
     * @param 	forwardBy				the amount the command should move the turtle forward
     * @return 	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> forwardCommand(final double forwardBy) {
		final double copyVal = forwardBy;
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
				double x_pos = params.getPosition().x;
				double y_pos = params.getPosition().y;
				double radians = Math.toRadians(params.getRotation());
		
				double new_x = x_pos - Math.cos(radians) * copyVal;
				double new_y = y_pos - Math.sin(radians) * copyVal;
				params.setPosition(new Point(new_x, new_y));
				return null;
		    }
		};
    }

    /**
     * Generate command to turn a turtle and change the direction it is facing. Used for commands LT and RT.
     * 
     * @param 	clockwiseDegrees		the number of degrees the command should turn the turtle clockwise
     * @return 	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> turnCommand(final double clockwiseDegrees) {
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
		    	params.setRotation(params.getRotation() + clockwiseDegrees);
		    	return null;
		    }
		};
    }

    /**
     * Generate command to move a turtle to a specific x,y location. Used for command SETXY.
     * 
     * @param 	x						the x coordinate the turtle should be set to
     * @param 	y						the y coordinate the turtle should be set to
     * @return 	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> SetXY(final double x, final double y) {
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
		    	params.setPosition(new Point(x, y));
				return null;
		    }
		};
    }

    /**
     * Generate command to turn a turtle towards a specific x,y location. Used for command TOWARDS.
     * 
     * @param 	x						the x coordinate the turtle should turn towards
     * @param 	y						the y coordinate the turtle should turn towards
     * @return 	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> towards(final double x, final double y) {
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
				double dAngle = 0;
				double headingX = x - params.getPosition().x;
				double headingY = y - params.getPosition().y;
				dAngle = Math.atan2(headingY, headingX) * 180 / Math.PI;
				params.setRotation(dAngle);
				return null;
		    }
		};
    }

    /**
     * Command to clear the screen and reset a turtle to the origin
     * 
     * @return 	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> clearScreen() {
    	return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
				params.setPosition(new Point(370.0, 300.0));
				params.setRotation(90);
				return null;
		    }
    	};
    }

    /**
     * Generate command to query a turtle for its current x,y coordinates. Used for commands XCOR and YCOR.
     * 
     * @return 	Command<Turtle, Point> 	the generated command
     */
    public static Command<Turtle, Point> xCor() {
		return new Command<Turtle, Point>() {
		    @Override
		    public Point run(Turtle params) {
		    	return params.getPosition();
		    }
		};
    }

    /**
     * Generate command to query a turtle for its current heading in degrees. Used for command HEADING.
     * 
     * @return 	Command<Turtle, Double> 	the generated command
     */
    public static Command<Turtle, Double> heading() {
		return new Command<Turtle, Double>() {
		    @Override
		    public Double run(Turtle params) {
				return Double.valueOf(params.getRotation());
		    }
		};
    }

    /**
     * Return command to query a turtle for its current pen state.
     * 
     * @return	Command<Turtle, Boolean> 	the command
     */
    public static Command<Turtle, Boolean> isPenDownCommmand() {
		return new Command<Turtle, Boolean>() {
		    @Override
		    public Boolean run(Turtle params) {
		    	return Boolean.valueOf(params.getPen().getActive());
		    }
		};
    }

    /**
     * Return command to query a turtle for its current visibility.
     * 
     * @return	Command<Turtle, Boolean> 	the command
     */
    public static Command<Turtle, Boolean> isVisibleCommand() {
		return new Command<Turtle, Boolean>() {
		    @Override
		    public Boolean run(Turtle params) {
		    	return Boolean.valueOf(params.getVisible());
		    }
		};
    }

    /**
     * Generate command to change the state of a turtle's pen.
     * 
     * @param 	newVisibility	the new visibility to apply to the turtle parameter
     * @return	Command<Turtle, Void> 	the command
     */
    public static Command<Turtle, Void> penState(final boolean isPenDown) {
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
		    	params.getPen().setActive(isPenDown);
				return null;
		    }
		};
    }

    /**
     * Generate command to change a turtle's visibility property
     * 
     * @param 	newVisibility	the new visibility to apply to the turtle parameter
     * @return	Command<Turtle, Void> 	the command
     */
    public static Command<Turtle, Void> visibility(final boolean newVisibility) {
    	return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
		    	params.setVisible(newVisibility);
		    	return null;
		    }
		};
    }

    /**
     * Generate command to change a turtle's pen width property
     * 
     * @param 	width 	a double representing the new pen width
     * @return	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> setPenWidth(final double width) {
		return new Command<Turtle, Void>() {
		    @Override
		    public Void run(Turtle params) {
		    	params.getPen().setWidth(width);
		    	return null;
		    }
		};
    }
    
    /**
     * Used to generate a Command<Turtle, Void> that repeats another Command<Turtle, Void>
     * a certain number of times. Used for command REPEAT.
     * 
     * @param 	command		a Command<Turtle, Void> object that will be repeated
     * @param 	repeats		the number of times to repeat the nested command
     * @return	Command<Turtle, Void> 	the generated command
     */
    public static Command<Turtle, Void> repeatCommand(final Command<Turtle, Void> command, final int repeats) {
    	return new Command<Turtle, Void>() {
    		@Override
    	    public Void run(Turtle turtle) {
    			for(int i = 0; i < repeats; i++) {
    				command.run(turtle);
    			}
				return null;
    		}
    	};
    }
}
