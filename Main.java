package SortMethods;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int tam = 10000;
        int[] original = new int[tam];

        for (int i = 0; i < tam; i++) {
            original[i] = tam - i;
        }

        runSort("Insertion Sort", original, InsertionSort::sort);
        runSort("Selection Sort", original, SelectSort::sort);
        runSort("Heap Sort", original, HeapSort::sort);
        runSort("Merge Sort", original, MergeSort::sort);
        runSort("Shell Sort", original, ShellSort::sort);
    }

    public static void runSort(String nome, int[] original, SortAlgorithm algoritmo) {
        int[] copia = Arrays.copyOf(original, original.length);
        SortMetrics m = new SortMetrics();
        long inicio = System.currentTimeMillis();

        algoritmo.sort(copia, m);

        long fim = System.currentTimeMillis();
        System.out.println("=== " + nome + " ===");
        System.out.println("Comparacoes: " + m.comparacoes);
        System.out.println("Movimentacoes: " + m.movimentacoes);
        System.out.println("Tempo (ms): " + (fim - inicio));
        System.out.println();
    }

    @FunctionalInterface
    public interface SortAlgorithm {
        void sort(int[] vetor, SortMetrics m);
    }
}

