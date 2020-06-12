package assg5_Escobar;

import junit.framework.TestCase;

public class TestComplexNum extends TestCase{
	private ComplexNum x, y, z;

	protected void setUp(){
		x = new ComplexNum();
		y = new ComplexNum(4.1);
		z = new ComplexNum(4.1,1.3);
	}

	public void testDefaultConstructor() {
		assertEquals("Real Value: ", 0, x.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", 0, x.getImaginary(), 0.00001);
	}

	public void testOneParamConstructor() {
		assertEquals("Real Value: ", 4.1, y.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", 0, y.getImaginary(), 0.00001);
	}
	public void testTwoParamConstructor() {
		assertEquals("Real Value: ", 4.1, z.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", 1.3, z.getImaginary(), 0.00001);
	}
	public void testGetReal(){
		assertEquals("Get Real Value: ", 4.1, z.getReal(), 0.00001);
	}
	public void testGetImaginary(){
		assertEquals("Get Imaginary Value: ", 1.3, z.getImaginary(), 0.00001);
	}
	public void testSetReal(){
		x.setReal(9.6);
		assertEquals("Set Real: ", 9.6, x.getReal());
	}
	public void testSetImaginary(){
		x.setImaginary(5.4);
		assertEquals("Set Imaginary: ", 5.4, x.getImaginary());
	}
	public void testAdd(){
		ComplexNum temp = new ComplexNum(2.2, 3.2);
		ComplexNum sum = z.add(temp);
		assertEquals("Real Value: ", 6.3, sum.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", 4.5, sum.getImaginary(), 0.00001);
	}
	public void testSub(){
		ComplexNum temp = new ComplexNum(2.3, 3.2);
		ComplexNum diff = z.sub(temp);
		assertEquals("Real Value: ", 1.8, diff.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", -1.9, diff.getImaginary(), 0.00001);
	}
	public void testMul(){
		ComplexNum temp = new ComplexNum(2.3, 3.2);
		ComplexNum product = z.mul(temp);
		assertEquals("Real Value: ", 5.27, product.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", 16.11, product.getImaginary(), 0.00001);
	}

	public void testNeg(){
		ComplexNum neg = new ComplexNum(-z.getReal(),-z.getImaginary());
		assertEquals("Real Value: ", -4.1, neg.getReal(), 0.00001);
		assertEquals("Imaginary Value: ", -1.3, neg.getImaginary(), 0.00001);
	}

	public void testToString(){
		assertEquals("Test toString when real and imaginary are 0: ", "",x.toString());
		assertEquals("Test toString when imaginary is 0: ", "4.1", y.toString());
		x.setImaginary(-5.4);
		assertEquals("Test toString when real is 0: ", "-5.4i", x.toString());
		assertEquals("Test toString when none are 0: ", "4.1 + 1.3i", z.toString());
		assertEquals("Test toString when both are negative: ", "-4.1 - 1.3i", z.neg().toString());
	}
	public void testEquals(){
		ComplexNum temp = z;
		assertEquals("Test toString when true: ", true, temp.equals(z));
		assertEquals("Test toString when false: ", false, temp.equals(x));
	}
}