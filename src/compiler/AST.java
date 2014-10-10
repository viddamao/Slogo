package compiler;

public class AST {
    class Node {

    }
    
    class Program extends Node{
	Node child;
    }
    
    class List extends Node{
	Node leftChild,rightChild;
    }
    
    class Statement extends Node{
	
    }
    
    class Command extends Statement{
	String commandType;
	Type rightChild;
    }
    
    class Move extends Command{
	
    }
    
    class Type extends Node{
	
    }
    
}
