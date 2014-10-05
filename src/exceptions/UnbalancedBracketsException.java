package exceptions;

public class UnbalancedBracketsException extends ParsingException {

    public UnbalancedBracketsException() {
	super();
    }

    public UnbalancedBracketsException(Exception e) {
	super(e);
    }

    public UnbalancedBracketsException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Unbalanced Brackets Exception";
    }
}
