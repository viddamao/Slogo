package exceptions;

public class SyntaxErrorException extends ParsingException {

    public SyntaxErrorException() {
	super();
    }

    public SyntaxErrorException(Exception e) {
	super(e);
    }

    public SyntaxErrorException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Syntax Error For the input program";
    }
}
