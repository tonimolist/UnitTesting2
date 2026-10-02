package cat.uvic.testing;

public class Calculator {

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplica(int a, int b) {
        return a * b;
    }

    public double divideix(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No es pot dividir entre zero");
        }

        return a / b;
    }

    public int potencia(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent negatiu no permès");
        }

        int resultat = 1;

        for (int i = 0; i < exponent; i++) {
            resultat *= base;
        }

        return resultat;
    }
}
