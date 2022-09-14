public class ProblemasIFPR {
    public static void primeiroProblema(int n) {
        int ultimo = 1, penultimo = 0, atual;
        System.out.println("0");
        if (n > 1) {
            System.out.println(" 1");
            for (int i = 2; i < n; i++) {
                atual = ultimo + penultimo;
                penultimo = ultimo;
                ultimo = atual;
                System.out.println(" " + atual);
            }
        }
    }

    public static void segundoProblema(int n, int m, int fig[]) {
        int album[] = new int[n + 1];
        for (int i = 0; i < m; i++) {
            album[fig[i]]++;
        }
        m = 0;
        for (int i = 1; i <= n; i++) {
            if (album[i] == 0)
                m++;
        }
        System.out.println(m);
    }

    public static void terceiroProblema(int numeros[]) {
        int[] pares = new int[10];
        int[] impares = new int[10];
        int numero, quantidadePares = 0, quantidadeImpares = 0;
        for (int i = 0; i < 10; i++) {
            numero = numeros[i];
            if (numero % 2 == 0) {
                pares[quantidadePares] = numero;
                quantidadePares = quantidadePares + 1;
            } else {
                impares[quantidadeImpares] = numero;
                quantidadeImpares = quantidadeImpares + 1;
            }
        }
        for (int i = 0; i < quantidadePares; i++)
            System.out.print(pares[i] + ", ");
        System.out.print("\n");
        for (int i = 0; i < quantidadeImpares; i++)
            System.out.print(impares[i] + ", ");
    }
}