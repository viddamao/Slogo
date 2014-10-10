package compiler;

public class Node {
    int type, data_1, data_2, data_3;
    Node left, right, parent;

    public Node(int data1, int data2, int data3, int type, Node left,
	    Node right, Node parent) {
	this.data_1 = data1;
	this.data_2 = data2;
	this.data_3 = data3;
	this.type = type;
	this.left = left;
	this.right = right;
	this.parent = parent;
    }

    public int getData1() {
	return data_1;
    }

    public int getData2() {
	return data_2;
    }

    public int getData3() {
	return data_3;
    }

    public int getType() {
	return type;
    }

}
