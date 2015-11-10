package _1_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Dmitry Adonin
 * @since 11/10/2015
 */
public class Lambda_12 {
    public static void main(String[] args) {
        ArrayList2<String> al2 = new ArrayList2<>();
        al2.addAll(Arrays.asList("A", "B"));
        al2.forEachIf(System.out::println, (element) -> element.startsWith("A"));
    }
}

interface Collection2<T> extends Collection<T> {
    default void forEachIf(Consumer<T> action, Predicate<T> filter) {
        for (T t : this) {
            if (filter.test(t)) { action.accept(t); }
        }
    }
}

class ArrayList2<E> extends ArrayList<E> implements Collection2<E> {}
