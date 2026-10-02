package cat.uvic.testing;

public class DescompteService {

    public double calcular(double importCompra, boolean clientPremium) {

        if (importCompra < 0) {
            throw new IllegalArgumentException("Import invàlid");
        }

        if (clientPremium && importCompra >= 100) {
            return importCompra * 0.80;
        }

        if (importCompra >= 100) {
            return importCompra * 0.90;
        }

        return importCompra;
    }
}
