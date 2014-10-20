package exceptions;

public class InvalidArgumentsException extends ParsingException {

    public InvalidArgumentsException() {
	super();
    }

    public InvalidArgumentsException(Exception e) {
	super(e);
    }

    public InvalidArgumentsException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Invalid Argument Exception";
    }
}
