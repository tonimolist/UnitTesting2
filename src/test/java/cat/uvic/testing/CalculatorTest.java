package cat.uvic.testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {


            
// @ParameterizedTest: Diu a JUnit que aquest test s'ha de repetir diverses vegades amb dades diferents.
// @CsvSource: És la llista de dades (entrades i resultat esperat) separades per comes que rep el test.
// @Test: Marca una funció normal perquè JUnit l'executi com una sola prova.


    //Instanciem calculadora 
    private Calculator calculator = new Calculator();

    //SUMA
    //Preparar
    @ParameterizedTest 
    @CsvSource({
        "2, 3, 5",
        "-2, -3, -5",
        "-4, 4, 0",
        "0, 0, 0"
    })

    void testSuma(int a, int b, int resultatEsperat) {

        //Executar calculadora
        int resultatReal = calculator.suma(a, b);

        //Comprovar si coincideix 
        assertEquals(resultatEsperat, resultatReal);
    }

    //RESTA
    //Preparar
    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "-5, -3, -2",
        "0, 5, -5",
        "0, 0, 0"
    })

    void testResta(int a, int b, int resultatEsperat) {

        //Executar calculadora
        int resultatReal = calculator.resta(a, b);

        //Comprovar si coincideix
        assertEquals(resultatEsperat, resultatReal);
    }

    //MULTIPLICACIO
    //Preparar
    @ParameterizedTest
    @CsvSource({
        "4, 2, 8",
        "-4, 2, -8",
        "-4, -2, 8",
        "5, 0, 0",
        "0, 0, 0"
    })

    void testMultiplica(int a, int b, int resultatEsperat) {

        //Executar calculadora
        int resultatReal = calculator.multiplica(a, b);

        //Comprovar si coincideix
        assertEquals(resultatEsperat, resultatReal);
    }

    //DIVISIO
    //Preparar
    @ParameterizedTest
    @CsvSource({
        "10.0, 2.0, 5.0",
        "-10.0, 2.0, -5.0",
        "-9.0, -3.0, 3.0",
        "0.0, 5.0, 0.0",
        "1.0, 3.0, 0.3333"
    })

    void testDivideix(double a, double b, double resultatEsperat) {

        //Executar calculadora
        double resultatReal = calculator.divideix(a, b);

        //Comprovar si coincideix
        assertEquals(resultatEsperat, resultatReal, 0.0001);
    }

    //(EXCEPCIO) - DIVISIO PER 0
    @Test

    void testDivideixPerZeroExcepcio() {

        //Comprova que executar calculator.divideix(10.0, 0.0) llanci obligatòriament l'error esperat IllegalArgumentException sense trencar el test.
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.divideix(10.0, 0.0);
        });
    }

    //POTENCIA
    //Preparar
    @ParameterizedTest
    @CsvSource({
        "2, 3, 8",
        "5, 0, 1",
        "0, 3, 0",
        "-2, 2, 4",
        "-2, 3, -8"
    })

    void testPotencia(int base, int exponent, int resultatEsperat) {

        //Executar calculadora
        int resultatReal = calculator.potencia(base, exponent);

        //Comprovar si coincideix
        assertEquals(resultatEsperat, resultatReal);
    }

    //(EXCEPCIO) - EXPONENT NEGATIU
    @Test

    void testPotenciaExponentNegatiuExcepcio() {

        //Comprova que passar un exponent negatiu (-1) llança l'error esperat IllegalArgumentException sense aturar bruscament el test.
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.potencia(2, -1);
        });
    }
}