package exceptions;

@SuppressWarnings("serial")
public class ParsingException extends Exception {

    public ParsingException() {
	super();
    }

    public ParsingException(Exception e) {
	super(e);
    }

    public ParsingException(String s) {
	super(s);
    }

    public String printMessage() {
	return "Parsing Exception";
    }

}
