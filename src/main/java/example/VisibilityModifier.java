package example;

public class VisibilityModifier {

    static class Complex {
        private final double real;
        private final double imaginary;

        public Complex(final double r, final double i) {
            this.real = r;
            this.imaginary = i;
        }

        public Complex add(final Complex other) {
            return new Complex(this.real + other.real, this.imaginary + other.imaginary);
        }

        public String toString() {
            return "real: " + real + " imag:" + imaginary;
        }
    }

    public static void main(String[] args) {
        final Complex expexted = new Complex(6, 2);

        final Complex a = new Complex(8, 0);
        final Complex b = new Complex(-2, 2);

        System.out.println(expexted);
        System.out.println(a.add(b));
    }

}
