package controller;

import java.util.Stack;

import controller.TokenFinder.Type;

class SymbolTableEntry {
    private Type myType;
    private String myName;
    private int myValue;

    @SuppressWarnings("unused")
    public SymbolTableEntry(Type type, String name, int value) {
	Type myType = type;
	String myName = name;
	int myValue = value;
	Stack<String> i;
    }

    void setType(Type type) {
	this.myType = type;
    }

    public void setName(String name) {
	this.myName = name;
    }

    public void setValue(int value) {
	this.myValue = value;
    }

    public Type getType() {
	return this.myType;
    }

    public String getName() {
	return this.myName;
    }

    public int getValue() {
	return this.myValue;
    }

}