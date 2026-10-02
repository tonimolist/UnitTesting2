package cat.uvic.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescompteServiceTest {

    //INSTANCIEM EL DESCOMPTE
    private DescompteService descompteService = new DescompteService();

    //(EXCEPCIO) - IMPORT NEGATIU
    @Test 
    void testImportNegatiuExcepcio() {

        //Passa un valor negatiu (-10.0) i comprova que el programa llança de forma controlada l'error IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            descompteService.calcular(-10.0, false); 
        });
    }

    //DESCOMPTES
    //Preparar
    @ParameterizedTest
    @CsvSource({
        "0.0, false, 0.0",     // --> AMB AQUEST CAS MATEM EL MUTANT DE L'EXERCICI D
        "50.0, false, 50.0",   // No premium < 100: sense descompte
        "50.0, true, 50.0",    // Premium < 100: sense descompte
        "100.0, false, 90.0",  // No premium >= 100: 10% descompte (100 * 0.90)
        "100.0, true, 80.0",   // Premium >= 100: 20% descompte (100 * 0.80)
        "200.0, false, 180.0", // No premium gran: 10% descompte (200 * 0.90)
        "200.0, true, 160.0"   // Premium gran: 20% descompte (200 * 0.80)
    })

    void testCalcularDescompte (double importCompra, boolean clientPremium, double resultatEsperat) {

        //Executar
        double resultatReal = descompteService.calcular(importCompra, clientPremium);

        //Comprovar
        assertEquals(resultatEsperat, resultatReal, 0.0001);
    }
    
}
