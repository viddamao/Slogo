package compiler;

import compiler.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	    case 38:				//<Type>--><Math>

		break;
	    case 39:				//<Type>--><Boolean>

		break;
	    case 40:				//<Math>-->+<Type><Type>

		break;
	    case 41:				//<Math>-->-<Type><Type>

		break;
	    case 42:				//<Math>-->*<Type><Type>

		break;
	    case 43:				//<Math>-->/<Type><Type>

		break;
	    case 44:				//<Math>-->%<Type><Type>

		break;
	    case 45:				//<Math>-->~<Type>

		break;
	    case 46:				//<Math>-->RANDOM<Type>

		break;
	    case 47:				//<Math>--><Tri><Type>

		break;
	    case 48:				//<Math>-->LOG<Type>

		break;
	    case 49:				//<Math>-->POW<Type><Type>

		break;
	    case 50:				//<Tri>-->SIN

		break;
	    case 51:				//<Tri>-->COS

		break;
	    case 52:				//<Tri>-->TAN

		break;
	    case 53:				//<Tri>-->ATAN

		break;
	    case 54:				//<Boolean>-->LESSP<Type><Type>

		break;
	    case 55:				//<Boolean>-->GREATERP<Type><Type>

		break;
	    case 56:				//<Boolean>-->EQUALP<Type><Type>

		break;
	    case 57:				//<Boolean>-->NOTEQUALP<Type><Type>

		break;
	    case 58:				//<Boolean>-->AND<Type><Type>
	
		break;
	    case 59:				//<Boolean>-->NOT<Type>

		break;
	    case 60:				//<Boolean>-->OR<Type><Type>
		break;

	    }

	}

	return syntaxTree.pop();

    }

    public void traverse(Node currentNode) {
	Compiler myCompiler=new Compiler();
	symbolTable=myCompiler.getSymbolTable();
	if (currentNode == null)
	    return;
	int rule = currentNode.type;
	switch (rule) {
		
	case 1:					//<Program>--><List>
	   
	    traverse(currentNode.left);

	    return;
		case 3:					//<List>--><List><Statement>
	    traverse(currentNode.left);
	    traverse(currentNode.right);
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
		double val=symbolTable.get(currentNode.right.data_1).getValue();
		switch (currentNode.left.data_1){
		case 27:
		    System.out.println("FD ");
		    break;
		case 28:
		    System.out.println("BK ");
		    break;
		case 29:
		    System.out.println("LT ");
		    break;
		case 30:
		    System.out.println("RT ");
		    break;
		}
		
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
//	    case 27:				//<Move>-->FD
//	    case 28:				//<Move>-->BK
//	    case 29:				//<Turn>-->LT
//	    case 30:				//<Turn>-->RT
//	    case 31:				//<Turn>-->SETH
//
//		tempParent = new Node( currentRule , 0, 0,
//			currentRule, null, null, null);
//		syntaxTree.push(tempParent);
//
//		break;
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
	    case 38:				//<Type>--><Math>

		break;
	    case 39:				//<Type>--><Boolean>

		break;
	    case 40:				//<Math>-->+<Type><Type>

		break;
	    case 41:				//<Math>-->-<Type><Type>

		break;
	    case 42:				//<Math>-->*<Type><Type>

		break;
	    case 43:				//<Math>-->/<Type><Type>

		break;
	    case 44:				//<Math>-->%<Type><Type>

		break;
	    case 45:				//<Math>-->~<Type>

		break;
	    case 46:				//<Math>-->RANDOM<Type>

		break;
	    case 47:				//<Math>--><Tri><Type>

		break;
	    case 48:				//<Math>-->LOG<Type>

		break;
	    case 49:				//<Math>-->POW<Type><Type>

		break;
	    case 50:				//<Tri>-->SIN

		break;
	    case 51:				//<Tri>-->COS

		break;
	    case 52:				//<Tri>-->TAN

		break;
	    case 53:				//<Tri>-->ATAN

		break;
	    case 54:				//<Boolean>-->LESSP<Type><Type>

		break;
	    case 55:				//<Boolean>-->GREATERP<Type><Type>

		break;
	    case 56:				//<Boolean>-->EQUALP<Type><Type>

		break;
	    case 57:				//<Boolean>-->NOTEQUALP<Type><Type>

		break;
	    case 58:				//<Boolean>-->AND<Type><Type>
	
		break;
	    case 59:				//<Boolean>-->NOT<Type>

		break;
	    case 60:				//<Boolean>-->OR<Type><Type>
		break;

	    }


    
	
	
	
    }
}

   

