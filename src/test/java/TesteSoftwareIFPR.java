import jdk.jfr.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertThrows;

public class TesteSoftwareIFPR {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream printStream = System.out;

    @Before
    public void init() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void end() {
        System.setOut(new PrintStream(printStream));
    }

    @Test
    @Name("Deve testar o primeiro problema com número que seja menor do que 1")
    public void testarPrimeiroProblemaNumeroMenorQueUm() {
        ProblemasIFPR.primeiroProblema(-1);

        assertEquals("0", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
    }

    @Test
    @Name("Deve testar o primeiro problema com número que seja igual a 1")
    public void testarPrimeiroProblemaNumeroIguaAUm() {
        ProblemasIFPR.primeiroProblema(1);

        assertEquals("0", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
    }

    @Test
    @Name("Deve testar o primeiro problema com número que seja maior do que 1")
    public void testarPrimeiroProblemaNumeroMaiorQueUm() {
        ProblemasIFPR.primeiroProblema(3);
        assertEquals("011", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
    }

    @Test
    @Name("Deve testar o segundo problema")
    public void testarSegundoProblema() {
        ProblemasIFPR.segundoProblema(10, 1, new int[]{1, 10});

        assertEquals("9", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
    }

    @Test
    @Name("Deve teste o terceiro problema com números par a esquerda e impares a direita PT1")
    public void testarTerceiroProblemaParImpar1() {
        ProblemasIFPR.terceiroProblema(new int[]{14, 5, 9, 4, 83, 169, 1423, 434, 22, 6});

        assertEquals("14,4,434,22,6,5,9,83,169,1423,", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
        // TODOD - Foi adicionado uma vírgula no print do terceiro problema para apresentar separadamente os números
        // pares e ímpares.
    }

    @Test
    @Name("Deve teste o terceiro problema com números par a esquerda e impares a direita PT2.")
    public void testarTerceiroProblemaParImpar2() {
        ProblemasIFPR.terceiroProblema(new int[]{1, 5, 9, 4, 83, 169, 45, 434, 22, 6, 3, 2, 2, 57, 4});

        assertEquals("4,434,22,6,1,5,9,83,169,45,", byteArrayOutputStream.toString().replaceAll("\\s+", ""));
        // TODOD - Foi adicionado uma vírgula no print do terceiro problema para apresentar separadamente os números
        // pares e ímpares.
    }

    @Test
    @Name("Deve teste o terceiro problema onde que o total de números passados por parâmetro seja menor que 10.")
    public void testarTerceiroProblemaErroIndexThrows() {
        assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> ProblemasIFPR.terceiroProblema(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
