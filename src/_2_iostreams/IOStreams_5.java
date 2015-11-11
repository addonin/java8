package _2_iostreams;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class IOStreams_5 {
    public static void main(String[] args) {
        //simple random value generator
        Stream<Double> stream = Stream.generate(Math::random);
        int i = 0;
        Iterator<Double> iterator = stream.iterator();
        while (i++ < 100) System.out.println(iterator.next());

        //custom linear congruent generator
        long seed = 11, a = 25214903917L, c = 12, m = (long) Math.pow(2, 48);
        Stream<Long> lstream = Stream.iterate(seed, n -> (a * n + c) % m);
        i = 0;
        Iterator iter = lstream.iterator();
        while (i++ < 100) System.out.println(iter.next());
    }
}
