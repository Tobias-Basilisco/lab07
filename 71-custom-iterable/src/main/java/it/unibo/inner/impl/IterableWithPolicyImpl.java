package it.unibo.inner.impl;

import java.lang.annotation.Inherited;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;
import it.unibo.inner.impl.PredicateImpl;

public class IterableWithPolicyImpl <T> implements IterableWithPolicy<T>{
    private final T[] elements;
    private Predicate<T> predicate;

    public IterableWithPolicyImpl (final T[] elements){
        this(
            elements,
            new Predicate<T>() {
                @Override
                public boolean test(T elem) {
                    return true;
                }

            }
        );
    }

    public IterableWithPolicyImpl (final T[] elements, final Predicate<T> predicate){
        this.elements = Arrays.copyOf(elements, elements.length);
        this.predicate = predicate;
    }

    public Iterator<T> iterator(){
        return new IteratorWithOptPolicy(predicate);
    }

    /**
     * 
     {@inherit}
     */
    @Override
    public void setIterationPolicy(Predicate<T> filter){
        predicate = filter;
    }

    class IteratorWithOptPolicy implements Iterator<T>{
        private int currentIndex;
        private final Predicate<T> predicate;

        public IteratorWithOptPolicy(){
            this.predicate = new PredicateImpl<>();
        }

        public IteratorWithOptPolicy(final Predicate<T> predicate){
            this.predicate = predicate;
        }

        @Override
        public boolean hasNext() {
            return currentIndex < elements.length;
        }

        @Override
        public T next() {
            if (hasNext()){
                if(!predicate.test(elements[currentIndex])){
                    currentIndex++;
                    return next();
                }
                return elements[currentIndex++];
            }
            return null;
            // throw new NoSuchElementException();
        }
    }

}
