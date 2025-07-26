package SortMethods;

public class ShellSort {
    public static void sort(int[] n, SortMetrics m) {
        int tam = n.length;
        for (int gap = tam / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < tam; i++) {
                int temp = n[i];
                m.movimentacoes++;
                int j;
                for (j = i; j >= gap && n[j - gap] > temp; j -= gap) {
                    m.comparacoes++;
                    n[j] = n[j - gap];
                    m.movimentacoes++;
                }
                if (j >= gap) m.comparacoes++; // última comparação falha
                n[j] = temp;
                m.movimentacoes++;
            }
        }
    }
}
