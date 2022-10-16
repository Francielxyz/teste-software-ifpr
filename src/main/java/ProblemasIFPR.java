import java.util.ArrayList;
import java.util.Arrays;

public class ProblemasIFPR {
    public static String primeiroProblema(int n) {
        int ultimo = 1, penultimo = 0, atual;
        String resposta = "0";
        if (n > 1) {
            resposta += " 1";
            for (int i = 2; i < n; i++) {
                atual = ultimo + penultimo;
                penultimo = ultimo;
                ultimo = atual;
                resposta += " " + atual;
            }
        }
        return resposta;
    }

    public static int segundoProblema(int n, int m, int fig[]) {
        int album[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            album[fig[i]]++;
        }
        m = 0;
        for (int i = 1; i <= n; i++) {
            if (album[i] == 0)
                m++;
        }
        return m;
    }

    public static ArrayList<int[]> terceiroProblema(int numeros[]) {
        ArrayList<int[]> retorno = new ArrayList<int[]>();
        int[] pares = new int[0];
        int[] impares = new int[0];
        for (int i = 0; i < 10; i++) {
            if (numeros[i] % 2 == 0) { // é par
                pares = Arrays.copyOf(pares, pares.length + 1);
                pares[pares.length - 1] = numeros[i];
            } else { // é ímpar
                impares = Arrays.copyOf(impares, impares.length + 1);
                impares[impares.length - 1] = numeros[i];
            }
        }
        retorno.add(0, pares);
        retorno.add(1, impares);
        return retorno;
    }
}