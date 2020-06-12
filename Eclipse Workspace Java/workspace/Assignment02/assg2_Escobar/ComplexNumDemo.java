// Jason Aaron Escobar Escoto

package assg2_Escobar;

public class ComplexNumDemo {

	public static void main(String[] args) {
		ComplexNum w = new ComplexNum();
		ComplexNum x = new ComplexNum(2.3, 3.2);
		ComplexNum y = new ComplexNum(4.1,1.3);
		ComplexNum a = y.mul(x);
		ComplexNum b = w.add(y);
		ComplexNum c = w.sub(y);
		ComplexNum d = x.neg();
		ComplexNum e = y.sub(x.add(x.add(x)));
		boolean f = x.equals(6);
		boolean g = x.equals(x);
		ComplexNum h = new ComplexNum();
		h.setImaginary(y.getImaginary());
		h.setReal(y.getReal());

		System.out.print("a = " + a +"\nb = " + b + "\nc = " + c +"\nd = " + d
				+ "\nw = " + w + "\ne = " + e + "\nf = " + f + "\ng = " + g + "\nh = " + h);		
	}

}
