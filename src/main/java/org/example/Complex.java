package org.example;

public class Complex {
    private double real;
    private double imag;

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public Complex add(Complex other) {
        return new Complex(real + other.real, imag + other.imag);
    }

    public Complex sub(Complex other) {
        return new Complex(real - other.real, imag - other.imag);
    }

    public Complex mul(Complex other) {
        return new Complex(real * other.real - imag * other.imag, imag * other.real + real * other.imag);
    }

    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    public Complex div(Complex other) {
        Complex divide = this.mul(other.conjugate());
//        System.out.println("!!!" + "!!!");
        divide.real /= other.getReal() * other.getReal() + other.getImag() * other.getImag();
        divide.imag /= other.getReal() * other.getReal() + other.getImag() * other.getImag();
        return divide;
    }

    public Complex pow(Integer power) {
        if (power == 1) {
            return this;
        }
        else {
            return this.mul(this);
        }
    }

    public double abs() {
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    public Complex sqrt() {
        return new Complex(Math.sqrt(real), Math.sqrt(imag));
    }

    public String toString() {
        return "(" + real + " + " + imag + "*i)";
    }
}
