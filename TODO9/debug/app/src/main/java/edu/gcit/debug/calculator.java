package edu.gcit.debug;

public class calculator {

    public enum Operators{ADD,SUB,DIV,MUL}

    public double add(double Firstoperand, double Secondoperand) {
        return Firstoperand +  Secondoperand;
    }
    public double sub(double Firstoperand, double  Secondoperand) {
        return Firstoperand - Secondoperand;
    }
    public double div(double Firstoperand, double Secondoperand) {
        return Firstoperand / Secondoperand;
    }
    public double mul(double Firstoperand, double  Secondoperand) {
        return Firstoperand *  Secondoperand;
    }
}
