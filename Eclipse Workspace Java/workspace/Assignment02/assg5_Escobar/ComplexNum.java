// Jason Aaron Escobar Escoto

/*
 * ComplexNum.java is a class that will used to store and manipulate complex
 * numbers. The complex numbers have the format of a + bi, a being the real
 * and b being the imaginary.
 */

package assg5_Escobar;

public class ComplexNum {
	private double real, imaginary;

	/*
	 * This constructor will create a complex number  0 + 0i
	 */

	public ComplexNum(){
		setReal(0);
		setImaginary(0);
	}

	/*
	 *  This constructor will create a complex number with x equal to 
	 *  the real part of the complex number
	 *  
	 *  @param	x	the real part of the complex number will equal x
	 */

	public ComplexNum(double x){
		setReal(x);
		setImaginary(0);
	}

	/*
	 * This constructor will create a complex number with x equal to the real part of the
	 * complex number and y equal to the imaginary part
	 * 
	 * @param	x	the real part of the complex number will equal x.
	 * @param	y	the imaginary part of the complex number will equal y.		
	 */

	public ComplexNum(double x, double y){
		setReal(x);
		setImaginary(y);
	}

	/*
	 *getReal will return the real part of the 'this'
	 *
	 * @return	the real part of 'this'
	 */

	public double getReal(){
		return real ;
	}

	/*
	 *getReal will return the imaginary part of the 'this'
	 * 
	 * @return 	the imaginary part of 'this'
	 */

	public double getImaginary(){
		return imaginary ;
	}

	/*
	 * setReal sets the real part of the 'this' equal to x
	 * 
	 * @param	x	what the real part of 'this' will equal
	 */

	public void setReal(double x){
		real = x;
	}

	/*
	 * setImaginary sets the imaginary part of 'this' equal to y
	 * 
	 * @param	x	what the imaginary part of 'this' will equal
	 */

	public void setImaginary(double x){
		imaginary = x; 
	}

	/*
	 * 'add' adds y to 'this' and returns the answer. For example, 4 + 1i 
	 * is 'this' and 2 + 3i is y, then this method will return 6 + 3i.
	 * 
	 * @param	y	the complex number that will be added to this
	 * @return		a new complex number that is the sum of y and 'this'
	 */

	public ComplexNum add(ComplexNum y){
		return new ComplexNum(this.real + y.real, this.imaginary + y.imaginary);
	}

	/*
	 * 'sub' subtracts y from 'this' and returns the answer. For example, 
	 * 4 + 1i is 'this' and 2 + 3i is y, then this method will return 2 - 2i. 
	 * 
	 * @param	y	the complex number that will be subtracted from 'this'
	 * @return		a new complex number that is the difference of 'this' and y
	 */

	public ComplexNum sub(ComplexNum y){
		return new ComplexNum(this.real - y.real, this.imaginary - y.imaginary);
	}

	/*
	 * 'mul' multiplies 'this' and y and returns the answer. The multiplication step
	 * is (a +bi) * (c+ + di) = (a*c - b*d) + (a*d + b*c)i. For example, 4 + 1i is
	 * 'this' and 2 + 3i is y, then this method will return 5.0 + 14.0i.
	 * 
	 * @param	y	the complex number that will be multiplied with 'this'
	 * @return		a new complex number that is the product of x and y.
	 */

	public ComplexNum mul(ComplexNum y){
		double a = this.real;
		double b = this.imaginary;
		double c = y.real;
		double d = y.imaginary;
		return new ComplexNum((a*c-b*d),(a*d+b*c));
	}
	public ComplexNum neg(){
		return new ComplexNum(-real,-imaginary);
	}
	/*
	 * This method will convert a complex number to a string. The format
	 * will be "a + bi", where a is the real and b is the imaginary. If
	 * either a or b are 0, then that part will not print. For example,
	 * if 0 is the real part and 6 is the imaginary part of the complex
	 * number, then the string returned will be "6i".
	 * 
	 * @return	a string that can be printed.
	 */
	public String toString(){

		if(real == 0){
			if (imaginary == 0){
				return "";
			}
			if(imaginary < 0){
				return "" + imaginary + "i";
			}
			return "" + imaginary + "i";
		}

		if (imaginary == 0){
			return ""+ real;
		}
		if(imaginary < 0){
			return "" + real + " - " + (-imaginary) + "i";
		}

		return "" + real + " + " + imaginary + "i";

	}
	
	/*
	 * This method will check if object x is equal to 'this'. This method
	 * will return true is the real part and the imaginary part of object x
	 * and 'this' are equal. If they are not equal, meaning that x is not a
	 * complex number or that either the real or the imaginary parts are 
	 * different, then this method will return false
	 * 
	 * @return		a boolean value that returns true if they are equal,
	 * 				false if they are not.
	 */
	public boolean equals(Object x){
		if (x == null){
			return false;
		}
		if (x instanceof ComplexNum){
			ComplexNum y = (ComplexNum) x;
			return (this.real == y.real && this.imaginary == y.imaginary);
		}
		return false;
	}
}
