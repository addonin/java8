package _2_iostreams;

import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/12/2015
 */
public class IOStream_10 {
    public static void main(String[] args) {

        Stream<Double> stream = Stream.of(1D, 2D, 3D);
        double d = stream.reduce(new Averager(), Averager::accept, Averager::combine).average();
        System.out.println(d);
    }
}

class Averager {

    final long count;
    final Double value;

    Averager() {
        this.count = 0;
        this.value = 0.0;
    }

    Averager(long count, Double value) {
        this.count = count;
        this.value = value;
    }

    Averager accept(Double value) {
        return new Averager(this.count + 1, this.value + value);
    }

    Averager combine(Averager averager) {
        return new Averager(this.count + averager.count, this.value + averager.value);
    }

    double average() {
        return value / count;
    }

}
