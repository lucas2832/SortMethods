package SortMethods;

public class HeapSort {
    public static void sort(int[] n, SortMetrics m) {
        int tam = n.length;

        for (int i = tam / 2 - 1; i >= 0; i--) {
            heapify(n, tam, i, m);
        }

        for (int i = tam - 1; i > 0; i--) {
            swap(n, 0, i, m);
            heapify(n, i, 0, m);
        }
    }

    private static void heapify(int[] n, int tam, int i, SortMetrics m) {
        int maior = i;
        int esq = 2 * i + 1;
        int dir = 2 * i + 2;

        if (esq < tam) {
            m.comparacoes++;
            if (n[esq] > n[maior]) maior = esq;
        }

        if (dir < tam) {
            m.comparacoes++;
            if (n[dir] > n[maior]) maior = dir;
        }

        if (maior != i) {
            swap(n, i, maior, m);
            heapify(n, tam, maior, m);
        }
    }

    private static void swap(int[] n, int i, int j, SortMetrics m) {
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
        m.movimentacoes += 3;
    }
}
