package controller;

import java.util.Stack;

import controller.TokenFinder.Type;

class SymbolTableEntry {
    private Type myType;
    private String myName;
    private double myValue;

    void setType(Type type) {
	this.myType = type;
    }

    public void setName(String name) {
	this.myName = name;
    }

    public void setValue(double value) {
	this.myValue = value;
    }

    public Type getType() {
	return this.myType;
    }

    public String getName() {
	return this.myName;
    }

    public double getValue() {
	return this.myValue;
    }

}