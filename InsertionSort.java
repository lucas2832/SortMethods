package SortMethods;

public class InsertionSort {
    public static void sort(int[] n, SortMetrics m) {
        for (int i = 1; i < n.length; i++) {
            int chave = n[i];
            m.movimentacoes++;
            int j = i - 1;

            while (j >= 0 && n[j] > chave) {
                m.comparacoes++;
                n[j + 1] = n[j];
                m.movimentacoes++;
                j--;
            }
            if (j >= 0) m.comparacoes++;
            n[j + 1] = chave;
            m.movimentacoes++;
        }
    }
}
