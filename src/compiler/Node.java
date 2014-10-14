package compiler;

public class Node {
    double data_1, data_2, data_3;
    int type;
    Node left, right;

    public Node(double data1, double data2, double data3, int type, Node left,
	    Node right) {
	this.data_1 = data1;
	this.data_2 = data2;
	this.data_3 = data3;
	this.type = type;
	this.left = left;
	this.right = right;
    }

}
