package cl.iplacex.calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    private final Calculadora calculadora = new Calculadora();

    @Test
    void deberiaSumarDosNumeros() {
        assertEquals(8, calculadora.sumar(5, 3));
    }

    @Test
    void deberiaRestarDosNumeros() {
        assertEquals(2, calculadora.restar(5, 3));
    }
}
