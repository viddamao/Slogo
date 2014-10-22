package compiler;

import commands.*;
import compiler.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import simulationObjects.Turtle;

public class AST {

    private Stack<Node> syntaxTree = new Stack<Node>();
    private List<SymbolTableEntry> symbolTable = new ArrayList<>();

    
    /**
     * 
     * generate AST with the rules provided
     * 
     * @param sequence
     */
    Node generate(Stack<Integer> sequence) {
	Compiler myCompiler = new Compiler();
	symbolTable = myCompiler.getSymbolTable();
	Node tempRight, tempLeft, tempParent;
	int index = -1;
	int currentRule = 0;
	while (!sequence.isEmpty()) {
	    currentRule = sequence.pop();
	    switch (currentRule) {
	    case 1: // <Program>--><List>
		tempLeft = syntaxTree.pop();
		tempParent = new Node(0, 0, 0, 1, tempLeft, null);
		syntaxTree.push(tempParent);
		break;
	    case 3: // <List>--><List><Statement>
	    case 4: // <List>-->REPEAT<Type>[ <List> ]
	    case 5: // <List>-->DOTIMES [ Variable <Type> ] [ <List> ]
	    case 6: // <List>-->FOR [ Variable <Type><Type><Type> ] [ List ]
	    case 7: // <List>-->IF <Type> [ <List> ]
	    case 11: // <Parameters>--><Parameters><Type>
	    case 14: // <Command>-->SET Variable<Type>
	    case 15: // <Command>--><Move><Type>
	    case 16: // <Command>--><Turn><Type>
	    case 17: // <Command>-->SETXY<Type><Type>
	    case 18: // <Command>-->TOWARDS<Type><Type>
	    case 41: // <Math>-->+<Type><Type>
	    case 42: // <Math>-->-<Type><Type>
	    case 40: // <Math>-->*<Type><Type>
	    case 43: // <Math>-->/<Type><Type>
	    case 44: // <Math>-->%<Type><Type>
	    case 47: // <Math>--><Tri><Type>
	    case 49: // <Math>-->POW<Type><Type>
	    case 54: // <Boolean>-->LESSP<Type><Type>
	    case 55: // <Boolean>-->GREATERP<Type><Type>
	    case 56: // <Boolean>-->EQUALP<Type><Type>
	    case 57: // <Boolean>-->NOTEQUALP<Type><Type>
	    case 58: // <Boolean>-->AND<Type><Type>
	    case 60: // <Boolean>-->OR<Type><Type>
	    case 61:
	    case 62:
	    case 63:
	    case 64:
	    case 72:
	    case 73:
	    case 74:
	    case 75:
	    case 76:
	
		tempRight = syntaxTree.pop();
		tempLeft = syntaxTree.pop();
		tempParent = new Node(0, 0, 0, currentRule, tempLeft, tempRight);
		syntaxTree.push(tempParent);

		break;
	    case 65://palette
		tempRight = syntaxTree.pop();
		tempLeft = syntaxTree.pop();
		Node temp = new Node(syntaxTree.pop().data_1,tempLeft.data_1, tempRight.data_1, currentRule, tempLeft, tempRight);
		tempParent = new Node(0, 0, 0, currentRule, syntaxTree.pop(), temp);
		break;
	    case 8: // <List>-->IFELSE <Type>[ <List> ][ <List>]
	    case 9: // <List>-->TO Variable [ <Parameters> ] [ <List> ]
		tempRight = syntaxTree.pop();
		tempLeft = syntaxTree.pop();
		Node tempSeq = new Node(0, 0, 0, currentRule, tempLeft, tempRight);
		tempLeft=syntaxTree.pop();
		tempParent = new Node(0, 0, 0, currentRule, tempLeft, tempSeq);
		syntaxTree.push(tempParent);

		break;

	    case 20: // <Command>-->HOME
	    case 21: // <Command>-->CS
	    case 22: // <Queries>-->XCOR
	    case 23: // <Queries>-->YCOR
	    case 24: // <Queries>-->HEADING
	    case 25: // <Queries>-->PENDOWNP
	    case 26: // <Queries>-->SHOWINGP
	    case 27: // <Move>-->FD
	    case 28: // <Move>-->BK
	    case 29: // <Turn>-->LT
	    case 30: // <Turn>-->RT
	    case 31: // <Turn>-->SETH
	    case 32: // <Property>-->PD
	    case 33: // <Property>-->PU
	    case 34: // <Property>-->ST
	    case 35: // <Property>-->HT
	    case 50: // <Tri>-->SIN
	    case 51: // <Tri>-->COS
	    case 52: // <Tri>-->TAN
	    case 53: // <Tri>-->ATAN
	    case 66:
	    case 67:
	    case 68:
	    case 69:
	    case 70:
	    case 71:
	    case 77://
		

		tempParent = new Node(currentRule, 0, 0, currentRule, null,
			null);
		syntaxTree.push(tempParent);

		break;

	    case 36: // <Type>-->Constant
	    case 37: // <Type>-->Variable
		index++;
		tempLeft = new Node(symbolTable.get(index).getValue(), 0, 0,
			currentRule, null, null);
		syntaxTree.push(tempLeft);

		break;
	
	    case 45: // <Math>-->~<Type>
	    case 46: // <Math>-->RANDOM<Type>
	    case 48: // <Math>-->LOG<Type>
	    case 59: // <Boolean>-->NOT<Type>
		tempLeft = syntaxTree.pop();
		tempParent = new Node(0, 0, 0, currentRule, tempLeft, null);
		syntaxTree.push(tempParent);

	    

		break;
	    }

	}

	return syntaxTree.pop();

    }

    public ArrayList<Command<Turtle, Void>> traverse(Node currentNode,ArrayList<Command<Turtle, Void>> ret) {

	if (currentNode == null)
	    return null;
	 traverse(currentNode.left,ret);
	 traverse(currentNode.right,ret);
	int rule = currentNode.type;
	switch (rule) {

	case 1: // <Program>--><List>
	    break;
	case 3: // <List>--><List><Statement>
	    
	    break;

	case 4: // <List>-->REPEAT<Type>[ <List> ]

	    break;
	case 5: // <List>-->DOTIMES [ Variable <Type> ] [ <List> ]
	    break;
	case 6: // <List>-->FOR [ Variable <Type><Type><Type> ] [ List ]
	    break;
	case 7: // <List>-->IF <Type> [ <List> ]
	    break;
	case 8: // <List>-->IFELSE <Type>[ <List> ][ <List>]
	    break;
	case 9: // <List>-->TO Variable [ <Parameters> ] [ <List> ]

	    break;
	case 10: // <Parameters>--><Type>

	    break;
	case 11: // <Parameters>--><Parameters><Type>

	    break;
	    
	case 13: // <Statement>--><Queries>

	    break;
	case 14: // <Command>-->SET Variable<Type>

	    break;
	case 15: // <Command>--><Move><Type>

	case 16: // <Command>--><Turn><Type>
	    double val = currentNode.right.data_1;
	    
	    switch (currentNode.left.type) {
	    case 27:
		System.out.print("FD ");
		System.out.println(val);
		Command<Turtle, Void> current = CommandList.forwardCommand(val);
		ret.add(current);
		return ret;
	    case 28:
		System.out.println("BK ");
		current = CommandList.forwardCommand(val);
		ret.add(current);
		return ret;

	    case 29:
		System.out.println("LT ");
		
		break;
	    case 30:
		System.out.println("RT ");
		
		break;
	    }

	    System.out.println(val);
	    break;
	case 17: // <Command>-->SETXY<Type><Type>
	    break;
	case 18: // <Command>-->TOWARDS<Type><Type>
	    break;
	case 19: // <Command>--><Property>
	    break;
	case 20: // <Command>-->HOME

	    break;
	case 21: // <Command>-->CS
	    System.out.println("CS");
	    break;
	case 22: // <Queries>-->XCOR

	    break;
	case 23: // <Queries>-->YCOR

	    break;
	case 24: // <Queries>-->HEADING

	    break;
	case 25: // <Queries>-->PENDOWNP

	    break;
	case 26: // <Queries>-->SHOWINGP

	    break;
	// case 27: //<Move>-->FD
	// case 28: //<Move>-->BK
	// case 29: //<Turn>-->LT
	// case 30: //<Turn>-->RT
	// case 31: //<Turn>-->SETH
	//
	// tempParent = new Node( currentRule , 0, 0,
	// currentRule, null, null, null);
	// syntaxTree.push(tempParent);
	//
	// break;
	case 32: // <Property>-->PD

	    break;
	case 33: // <Property>-->PU

	    break;
	case 34: // <Property>-->ST

	    break;
	case 35: // <Property>-->HT

	    break;
	case 38: // <Type>--><Math>
	    break;
	case 39: // <Type>--><Boolean>
	    break;
	case 40: // <Math>-->+<Type><Type>
	case 41: // <Math>-->-<Type><Type>
	case 42: // <Math>-->*<Type><Type>
	case 43: // <Math>-->/<Type><Type>
	case 44: // <Math>-->%<Type><Type>
	case 49: // <Math>-->POW<Type><Type>
	case 54: // <Boolean>-->LESSP<Type><Type>
	case 55: // <Boolean>-->GREATERP<Type><Type>
	case 56: // <Boolean>-->EQUALP<Type><Type>
	case 57: // <Boolean>-->NOTEQUALP<Type><Type>
	case 58: // <Boolean>-->AND<Type><Type>
	case 60: // <Boolean>-->OR<Type><Type>

	    double val1 = currentNode.left.data_1,
	    val2 = currentNode.right.data_1;
	    double result = 0;

	    switch (rule) {
	    case 40:
		result = val1 + val2;
		break;
	    case 41:
		result = val1 - val2;
		break;
	    case 42:
		result = val1 * val2;
		break;
	    case 43:
		result = val1 / val2;
		break;
	    case 44:
		result = val1 % val2;
		break;
	    case 49:
		result = Math.pow(val1, val2);
		break;
	    case 54:
		result = (val1 < val2) ? 0 : 1;
		break;
	    case 55:
		result = (val1 > val2) ? 0 : 1;
		break;
	    case 56:
		result = (val1 == val2) ? 0 : 1;
		break;
	    case 57:
		result = (val1 == val2) ? 1 : 0;
		break;
	    case 58:
		result = ((val1 == 1) & (val2 == 1)) ? 0 : 1;
		break;
	    case 60:
		result = ((val1 == 1) | (val2 == 1)) ? 0 : 1;
		break;

	    }
	    currentNode.data_1 = result;
	    break;

	case 45: // <Math>-->~<Type>
	case 46: // <Math>-->RANDOM<Type>
	case 48: // <Math>-->LOG<Type>

	    val1 = currentNode.left.data_1;
	    result = 0;
	    switch (rule) {
	    case 45:
		result = -val1;
		break;
	    case 46:
		result = Math.random() * val1;
		break;
	    case 48:
		result = Math.log(val1);
		break;
	    }
	    currentNode.data_1 = result;

	    break;
	case 47: // <Math>--><Tri><Type>
	    break;
	case 50: // <Tri>-->SIN

	    break;
	case 51: // <Tri>-->COS

	    break;
	case 52: // <Tri>-->TAN

	    break;
	case 53: // <Tri>-->ATAN

	    break;

	case 59: // <Boolean>-->NOT<Type>

	    break;
	    
	case 61://SETBG
	    break;
	case 62://SETPC
	    break;
	case 63://SETPS
	    break;
	case 64://SETSH
	    break;
	case 65://SETPALETTE
	    break;
	case 66://PC
	    break;
	case 67://SH
	    break;
	case 68://STAMP
	    break;
	case 69://CLEARSTAMPS
	    break;
	case 70://ID
	    break;
	case 71://TURTLES
	    break;
	case 72://TELL
	    break;
	case 73://ASK
	    break;
	case 74://ASKWITH
	    break;
	case 75://ONCLICK
	    break;
	case 76://ONMOVE
	    break;
	case 77://ONKEY
	    break;
	
	}
	
	return ret;

    }
}