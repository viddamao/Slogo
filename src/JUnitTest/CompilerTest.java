package JUnitTest;

import static org.junit.Assert.assertEquals;
import controller.Compiler;
import controller.TokenFinder.Type;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CompilerTest {

    Compiler compiler = new Compiler();
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGrammarException() {
	exception.expect(IllegalArgumentException.class);
	exception.expectMessage("Grammatically Error");
	// * is not an acceptable variable name
	String testInput = "fd *";
	compiler.compile(testInput);
    }

    @Test
    public void testSyntaxException() {
	exception.expect(IllegalArgumentException.class);
	exception.expectMessage("Syntactically Error");
	String testInput = "fd 12 13";
	compiler.compile(testInput);
    }

    @Test
    public void testScanner() {
	String testInput = "fd 12 13";
	Type[] tokens = compiler.compile(testInput);
	assertEquals(tokens[0], Type.COMMAND);
    }

}
