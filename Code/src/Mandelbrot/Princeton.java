package Mandelbrot;

import java.awt.Color;


public class Princeton {

    // return number of iterations to check if c = a + ib is in Mandelbrot set
    public static int mand(Complex z0, int max) {
        Complex z = z0;
        for (int t = 0; t < max; t++) {
            if (z.abs() > 2.0) return t;
            z = z.times(z).plus(z0);
        }
        return max;
    }

    public static void main(String[] args)  {
    	
    	/*
        double xc   = Double.parseDouble(args[0]);
        double yc   = Double.parseDouble(args[1]);
        double size = Double.parseDouble(args[2]);

        int n   = 512;   // create n-by-n image
        int max = 255;   // maximum number of iterations

        Picture picture = new Picture(n, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double x0 = xc - size/2 + size*i/n;
                double y0 = yc - size/2 + size*j/n;
                Complex z0 = new Complex(x0, y0);
                int gray = max - mand(z0, max);
                Color color = new Color(gray, gray, gray);
                picture.set(i, n-1-j, color);
            }
        }
        picture.show();
        */
    }
    
    
    public class Complex {
    	double real;
    	double imag;
    	
    	public Complex(double real, double imag) {
    		this.real = real;
    		this.imag = imag;
    	}
    	
    	public double getReal() {
    		return this.real;
    	}
    	
    	public double getImag() {
    		return this.imag;
    	}
    	
    	public Complex plus(Complex num1, Complex num2) {
    		Complex sum = new Complex(num1.real + num2.real, num1.imag + num2.imag);
    		return sum;
    	}
    	
    	public Complex plus(Complex num) {
    		return new Complex(this.real + num.real, this.imag + num.imag);
    	}
    	
    	public Complex minus(Complex num1, Complex num2) {
    		return new Complex(num1.real - num2.real, num1.imag - num2.imag);
    	}
    	
    	public Complex minus(Complex num) {
    		return new Complex(this.real - num.real, this.imag - num.imag);
    	}
    	public Complex times(Complex num1, Complex num2) {
    		Complex result = new Complex(num1.real * num2.real - num1.imag * num2.imag, num1.real * num2.imag + num1.imag * num2.real);
    		return result;
    	}
    	
    	public Complex times(Complex num) {
    		Complex result = new Complex(this.real * num.real - this.imag * num.imag, this.real * num.imag + this.imag * num.real);
    		return result;
    	}

		public double abs(Complex num) {
			return Math.sqrt(num.real*num.real + num.imag*num.imag);
		}
		
		public double abs() {
			return Math.sqrt(this.real*this.real + this.imag*this.imag);
		}
 
		public String toString() {
			return Double.toString(this.real) + " + " + Double.toString(this.imag) + " i";
		}
		
		public double degree(Complex num) {
			return Math.tan(num.imag / num.real);
		}
		
		public double degree() {
			return Math.tan(this.imag / this.real);
		}
    }
}


