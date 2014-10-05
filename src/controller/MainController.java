package controller;

import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class MainController {

    private Compiler compiler = new Compiler();

    public String passInput(String input) throws ParsingException,
	    UnbalancedBracketsException {

	return compiler.compile(input);

    }
    

}
