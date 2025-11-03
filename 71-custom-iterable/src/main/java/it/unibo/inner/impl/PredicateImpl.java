package it.unibo.inner.impl;

import it.unibo.inner.api.Predicate;

public class PredicateImpl<T> implements Predicate<T>{

    // public PredicateImpl(){

    // }
    /**
     * 
     * {@inherit}
     * @param elem
     * @return
     */
    @Override
    public boolean test(T elem){
        return true;
    }
}
