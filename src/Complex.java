
public class Complex {
	private double re, im;
	
	public Complex(double re, double im) {
		this.re = re; this.im = im;
	}
	
	public double getRe() {
		return re;
	}
	
	public double getIm() {
		return im;
	}
	
	public double getAbs2() {
		return Math.pow(re,2)+Math.pow(im,2);
	}
	
	public void add(Complex c ) {
		this.re+=c.getRe();
		this.im+=c.getIm();
	}
	
	public void mul(Complex c ) {
		double TheRe = re*c.getRe() - im*c.getIm();
		double TheIm =  re*c.getIm() + im*c.getRe();
		re = TheRe;
		im = TheIm;
	}
	
}
