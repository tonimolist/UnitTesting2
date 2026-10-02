package cat.uvic.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ComandaServiceTest {

    // Creem un magatzem fals (mock)
    private StockRepository stockRepository = mock(StockRepository.class);

    // INSTANCIEM MAGATZEM FALS
    private ComandaService comandaService = new ComandaService(stockRepository);

    //PRODUCTE BUIT O NUL 
    @Test 
    void testProducteNullExcepcio() {

        // Abans de preguntar al magatzem, el servei mira si li hem passat un text vàlid. Si li passem null, ha de petar amb IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            comandaService.potComprar(null);
        });
    }

    @Test 
    void testProducteBuitExcepcio() {
        assertThrows(IllegalArgumentException.class, () -> {
            comandaService.potComprar("   ");
        });
    }

    //SIMULAR QUE HI HA ESTOC
    @Test 
    void testPotComprarQuanHiHaStock() {
        
        //Resposta del fals magatzem
        when(stockRepository.teStock("poma")).thenReturn(true);

        //Executem metode real 
        boolean resultat = comandaService.potComprar("poma");

        //Comprovem que el resultat és cert
        assertTrue(resultat);
        
        //Verifiquem que el servei ha consultat al repositori per "poma"
        verify(stockRepository).teStock("poma");
    }

    //SIMULAR QUE NO HI HA ESTOC
    @Test 
    void testNoPotComprarQuanNoHiHaStock() {

        //Resposta del fals magatzem
        when(stockRepository.teStock("pera")).thenReturn(false);

        //Executem metode real
        boolean resultat = comandaService.potComprar("pera");

        //Comprovem que el resultat és fals
        assertFalse(resultat);

        //Verifiquem que el servei ha consultat al repositori per "pera"
        verify(stockRepository).teStock("pera");
    }
}
