package JUnitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import compiler.TokenFinder;
import compiler.TokenFinder.Type;

public class TokenFinderTest {

    @SuppressWarnings("static-access")
    @Test
    public void testConstant() {
	TokenFinder myTokenFinder = new TokenFinder();
	Type myType=myTokenFinder.stringType("123");
	assertEquals(true,equals(myType,Type.CONSTANT));
	myType=myTokenFinder.stringType("-1");
	assertEquals(true,equals(myType,Type.CONSTANT));
	
    }
    
    @SuppressWarnings("static-access")
    @Test
    public void testVariable() {
	TokenFinder myTokenFinder = new TokenFinder();
	Type myType=myTokenFinder.stringType("123");
	assertEquals(false,equals(myType,Type.VARIABLE));
	myType=myTokenFinder.stringType(":t");
	assertEquals(true,equals(myType,Type.VARIABLE));
	
    }
    
    @SuppressWarnings("static-access")
    @Test
    public void testCommand() {
	TokenFinder myTokenFinder = new TokenFinder();
	Type myType=myTokenFinder.stringType("123");
	assertEquals(false,equals(myType,Type.COMMAND));
	myType=myTokenFinder.stringType(":t");
	assertEquals(false,equals(myType,Type.COMMAND));
	myType=myTokenFinder.stringType("forward");
	assertEquals(true,equals(myType,Type.COMMAND));	
    }
    private boolean equals(Type myType, Type type) {
	return (myType.equals(type))?true:false;
    }

}
