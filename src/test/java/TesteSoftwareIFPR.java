import jdk.jfr.Name;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
    @Name("Deve testar o primeiro problema caminho Base: a - b - d")
    public void testarPrimeiroProblemaCaminhoABD() {
        assertEquals("0", ProblemasIFPR.primeiroProblema(1));
    }

    @Test
    @Name("Deve testar o primeiro problema caminho: a - b - c - e - d")
    public void testarPrimeiroProblemaCaminhoABCED() {
        assertEquals("0 1", ProblemasIFPR.primeiroProblema(2));
    }

    @Test
    @Name("Deve testar o primeiro problema caminho: a - b - c - e - f - d ")
    public void testarPrimeiroProblemaCaminhoABCEFD() {
        assertEquals("0 1 1", ProblemasIFPR.primeiroProblema(3));
    }

    @Test
    @Name("Deve testar segundo problema caminho Base: a - b - c - b - d - e - g - h - e - f")
    public void testarSegundoProblemaCaminhoABCBDEGHEF() {
        // todo - verificar se ficou correto
        assertEquals(9, ProblemasIFPR.segundoProblema(10, 1, new int[]{1, 10}));
    }

    @Test
    @Name("Deve testar o segundo problema caminho: a - b - d - e - f")
    public void testarSegundoProblemaCaminhoABDEF() {
        assertEquals(0, ProblemasIFPR.segundoProblema(0, 0, new int[]{0, 0}));
    }

    @Test
    @Name("Deve testar o segundo problema caminho: a - b - d - e - g - e - f")
    public void testarSegundoProblemaCaminhoABDEGEF() {
        // TODO - NÃO CONSEGUI IMPLEMENTAR
        assertEquals(0, ProblemasIFPR.segundoProblema(10, 0, new int[]{}));
    }

    @Test
    @Name("Deve teste o terceiro problema caminho Base: a - b - c")
    public void testarTerceiroProblemaCaminhoABC() {
        // TODO - Este caminho é impossível de testar uma vez que a variável "i" sempre vai ser menor que 10
    }

    @Test
    @Name("Deve teste o terceiro problema caminho a - b - d - e - b - c")
    public void testarTerceiroProblemaCaminhoABDEBC() {
        int[] numeros = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        ArrayList<int[]> retorno = new ArrayList<int[]>();
        retorno.add(numeros);
        retorno.add(new int[0]);

        assertEquals(retorno, ProblemasIFPR.terceiroProblema(numeros));
    }

    @Test
    @Name("Deve teste o terceiro problema caminho a - b - d - f - b - c")
    public void testarTerceiroProblemaCaminhoABDFBC() {
        int[] numeros = new int[]{1, 3, 5, 7, 9, 13, 3, 1, 5, 11};

        ArrayList<int[]> retorno = new ArrayList<int[]>();
        retorno.add(new int[0]);
        retorno.add(numeros);

        assertEquals(retorno, ProblemasIFPR.terceiroProblema(numeros));
    }
}
