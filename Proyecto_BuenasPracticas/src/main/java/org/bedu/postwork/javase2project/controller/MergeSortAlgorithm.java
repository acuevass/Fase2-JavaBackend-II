package org.bedu.postwork.javase2project.controller;

// POSTWORK 06.


import lombok.experimental.UtilityClass;

import java.util.*;

@UtilityClass
public class MergeSortAlgorithm {

    // CHECKLIST: MergeSortAlgorithm tiene un método que ordena por números números naturales
    // con un Comparable.
    public static <T extends Comparable<T>> List<T> sort(List<T> unsortedList) {
        return sort(unsortedList, Comparator.naturalOrder());
    }

    // CHECKLIST: La clase MergeSortAlgorithm contiene un método que ordena una
    // colección con un comparador.
    public static <T> List<T> sort(List<T> unsortedList, Comparator<T> comparator){
        if (unsortedList.size() == 1){
            return unsortedList;
        }
        int elementoMedio = unsortedList.size() / 2;

        Deque<T> pila1  = new ArrayDeque<>(sort(unsortedList.subList(0, elementoMedio), comparator));
        Deque<T> pila2  = new ArrayDeque<>(sort(unsortedList.subList(elementoMedio, unsortedList.size()), comparator));

        return merge(pila1, pila2, comparator);
    }

    // CHECKLIST: MergeSortAlgorithm tiene un método para mezclar los dos tipos de ordenamiento.
    private static <T> List<T> merge(Deque<T> pila1, Deque<T> pila2, Comparator<T> comparator) {
        List<T> merged = new ArrayList<>();

        while (!pila1.isEmpty() && !pila2.isEmpty()) {
            if (comparator.compare(pila1.peekFirst(), pila2.peekFirst()) < 0) {
                merged.add(pila1.pop());
            } else {
                merged.add(pila2.pop());
            }
        }
        merged.addAll(pila1);
        merged.addAll(pila2);

        return merged;

    }
}
