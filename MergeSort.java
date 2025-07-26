package SortMethods;

public class MergeSort {
    public static void sort(int[] n, SortMetrics m) {
        mergeSort(n, 0, n.length - 1, m);
    }

    private static void mergeSort(int[] n, int esq, int dir, SortMetrics m) {
        if (esq < dir) {
            int meio = (esq + dir) / 2;
            mergeSort(n, esq, meio, m);
            mergeSort(n, meio + 1, dir, m);
            merge(n, esq, meio, dir, m);
        }
    }

    private static void merge(int[] n, int esq, int meio, int dir, SortMetrics m) {
        int n1 = meio - esq + 1;
        int n2 = dir - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = n[esq + i];
            m.movimentacoes++;
        }
        for (int j = 0; j < n2; j++) {
            R[j] = n[meio + 1 + j];
            m.movimentacoes++;
        }

        int i = 0, j = 0;
        int k = esq;

        while (i < n1 && j < n2) {
            m.comparacoes++;
            if (L[i] <= R[j]) {
                n[k++] = L[i++];
            } else {
                n[k++] = R[j++];
            }
            m.movimentacoes++;
        }

        while (i < n1) {
            n[k++] = L[i++];
            m.movimentacoes++;
        }

        while (j < n2) {
            n[k++] = R[j++];
            m.movimentacoes++;
        }
    }
}
