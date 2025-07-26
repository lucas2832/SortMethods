package SortMethods;

public class SelectSort {
    public static void sort(int[] n, SortMetrics m) {
        for (int i = 0; i < n.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n.length; j++) {
                m.comparacoes++;
                if (n[j] < n[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int aux = n[i];
                n[i] = n[min];
                n[min] = aux;
                m.movimentacoes += 3;
            }
        }
    }
}
