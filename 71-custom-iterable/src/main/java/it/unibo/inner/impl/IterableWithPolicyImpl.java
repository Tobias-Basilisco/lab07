package it.unibo.inner.impl;

import java.lang.annotation.Inherited;
import java.util.Arrays;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl <T> implements IterableWithPolicy<T>{
    private final T[] elements;

    public IterableWithPolicyImpl (final T[] elements){
        this.elements = Arrays.copyOf(elements, elements.length);
    }

    /**
     * 
     {@inherit doc}
     */
    @Override
    public void setIterationPolicy(Predicate<T> filter){

    }

    class NoPolicyIterator implements Iterator<T>{
        private int currentIndex;

        public NoPolicyIterator(){
            currentIndex = 0; 
        }

        @Override
        public boolean hasNext() {
            return currentIndex < elements.length;
        }

        @Override
        public T next() {
            return elements[currentIndex];
        }
    }

    public Iterator<T> iterator(){
        return new NoPolicyIterator();
    }
}
