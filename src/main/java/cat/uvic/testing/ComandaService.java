package cat.uvic.testing;

public class ComandaService {

    private final StockRepository stockRepository;

    public ComandaService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public boolean potComprar(String producte) {

        if (producte == null || producte.isBlank()) {
            throw new IllegalArgumentException("Producte invàlid");
        }

        return stockRepository.teStock(producte);
    }
}
