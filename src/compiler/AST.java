package compiler;

import compiler.Node;

import java.util.List;
import java.util.Stack;

public class AST {

    private Stack<Node> syntaxTree = new Stack<Node>();
      
    /**
     * 
     * generate AST with the rules provided
     * 
     * @param sequence
     */
    Node generate(Stack<Integer> sequence,List<SymbolTableEntry> symbolTable) {
	 Node tempRight,tempLeft,tempParent;
	 int index=0;
	int currentRule = 0;
	while (!sequence.isEmpty()) {
	    currentRule = sequence.pop();
	    System.out.println(currentRule);
	    switch (currentRule) {
	    case 1:				//<Program>--><List>
		tempLeft = syntaxTree.pop();
		tempParent = new Node(0, 0, 0, 1, tempLeft, null, null);
		tempLeft.parent = tempParent;
		syntaxTree.push(tempParent);
		break;
	    case 2:				//<List>--><Statement>
		
		break;
	    case 3:				//<List>--><List><Statement>
		tempRight = syntaxTree.pop();
		tempLeft = syntaxTree.pop();
		tempParent = new Node(0, 0, 0, 3, tempLeft, tempRight, null);
		tempLeft.parent = tempParent;
		tempRight.parent = tempParent;
		syntaxTree.push(tempParent);

		break;
	    case 4:				//<List>-->REPEAT<Type>[ <List> ]
		
		break;
	    case 5:				//<List>-->DOTIMES [ Variable <Type> ] [ <List> ]
		break;
	    case 6:				//<List>-->FOR [ Variable <Type><Type><Type> ] [ List ]
		break;
	    case 7:				//<List>-->IF <Type> [ <List> ]
		break;
	    case 8:				//<List>-->IFELSE <Type>[ <List> ][ <List>]
		break;
	    case 9:				//<List>-->TO Variable [ <Parameters> ] [ <List> ]

		break;
	    case 10:				//<Parameters>--><Type>

		break;
	    case 11:				//<Parameters>--><Parameters><Type>

		break;
	    case 12:				//<Statement>--><Command>
		
		break;
	    case 13:				//<Statement>--><Queries>

		break;	
	    case 14:				//<Command>-->SET Variable<Type>
	
		break;
	    case 15:				//<Command>--><Move><Type>
		
	    case 16:				//<Command>--><Turn><Type>
		tempLeft = syntaxTree.pop();
		tempRight = syntaxTree.pop();
		tempParent = new Node(0 ,0, 0, currentRule,
			tempLeft, tempRight, null);
		syntaxTree.push(tempParent);
		
		break;
	    case 17:				//<Command>-->SETXY<Type><Type>
		break;
	    case 18:				//<Command>-->TOWARDS<Type><Type>
		break;
	    case 19:				//<Command>--><Property>
		break;	
	    case 20:				//<Command>-->HOME

		break;
	    case 21:				//<Command>-->CS

		break;
	    case 22:				//<Queries>-->XCOR

		break;
	    case 23:				//<Queries>-->YCOR

		break;
	    case 24:				//<Queries>-->HEADING

		break;
	    case 25:				//<Queries>-->PENDOWNP

		break;
	    case 26:				//<Queries>-->SHOWINGP

		break;
	    case 27:				//<Move>-->FD
	    case 28:				//<Move>-->BK
	    case 29:				//<Turn>-->LT
	    case 30:				//<Turn>-->RT
	    case 31:				//<Turn>-->SETH

		index++;
		tempParent = new Node( currentRule , 0, 0,
			currentRule, null, null, null);
		syntaxTree.push(tempParent);

		break;
	    case 32:				//<Property>-->PD

		break;
	    case 33:				//<Property>-->PU

		break;
	    case 34:				//<Property>-->ST

		break;
	    case 35:				//<Property>-->HT

		break;
	    case 36:				//<Type>-->Constant

		
	    case 37:				//<Type>-->Variable
		index++;
		// if (!isNumber(symboltable[index])) index--;
		tempLeft = new Node(index, 0, 0, currentRule, null, null, null);
		syntaxTree.push(tempLeft);
		
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

	return syntaxTree.pop();

    }

   
}
