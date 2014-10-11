package compiler;

import Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ASTGenerator {

    private Queue<Node> syntaxTree = new LinkedList<Node>();
    private String[] LHS = new String[61];

    /**
     * 
     * generate AST with the rules provided
     * 
     * @param sequence
     */
    Node generate(Stack<Integer> sequence) {
	ParseTable myParseTable = new ParseTable();
	LHS = myParseTable.getLHS();
	int currentRule = 0;
	while (!sequence.isEmpty()) {
	    currentRule = sequence.pop();
	    System.out.println(currentRule);
	    switch (currentRule) {
	    case 1:				//<Program>--><List>
		
		break;
	    case 2:				//<List>--><Statement>
		break;
	    case 3:				//<List>-><List><Statement>
		tempright = tempStack.pop();
		templeft = tempStack.pop();
		tempparent = new Node(0, 0, 0, 3, templeft, tempright, null);
		templeft.parent = tempparent;
		tempright.parent = tempparent;
		tempStack.push(tempparent);

		break;
	    case 4:
		break;
	    case 5:
		break;
	    case 6:
		break;
	    case 7:
		break;
	    case 8:
		break;
	    case 9:
		break;
	    case 10:
		break;
	    case 11:
		break;
	    case 12:
		break;
	    case 13:
		break;
	    case 14:
		break;
	    case 15:
		break;
	    case 16:
		break;
	    case 17:
		break;
	    case 18:
		break;
	    case 19:
		break;
	    case 20:
		break;
	    case 21:
		break;
	    case 22:
		break;
	    case 23:
		break;
	    case 24:
		break;
	    case 25:
		break;
	    case 26:
		break;
	    case 27:
		
		break;
	    case 28:
		break;
	    case 29:
		break;
	    case 30:
		break;
	    case 31:
		break;
	    case 32:
		break;
	    case 33:
		break;
	    case 34:
		break;
	    case 35:
		break;
	    case 36:
		break;
	    case 37:
		break;
	    case 38:
		break;
	    case 39:
		break;
	    case 40:
		break;
	    case 41:
		break;
	    case 42:
		break;
	    case 43:
		break;
	    case 44:
		break;
	    case 45:
		break;
	    case 46:
		break;
	    case 47:
		break;
	    case 48:
		break;
	    case 49:
		break;
	    case 50:
		break;
	    case 51:
		break;
	    case 52:
		break;
	    case 53:
		break;
	    case 54:
		break;
	    case 55:
		break;
	    case 56:
		break;
	    case 57:
		break;
	    case 58:
		break;
	    case 59:
		break;
	    case 60:
		break;

	    }

	}

	return syntaxTree.poll();

    }

    protected Node createNode(Class<?> nodeClass)
	    throws InstantiationException, IllegalAccessException {
	Node node = (Node) nodeClass.newInstance();
	return node;
    }
}
