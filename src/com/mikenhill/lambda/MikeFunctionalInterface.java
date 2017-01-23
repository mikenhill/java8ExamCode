package com.mikenhill.lambda;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface MikeFunctionalInterface <T, R> {
	public R doWork(T t);
	
	default <V> MikeFunctionalInterface<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> doWork(before.apply(v));
    }
	
}
