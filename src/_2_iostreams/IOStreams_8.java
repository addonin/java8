package _2_iostreams;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author Dmitry Adonin
 * @since 11/11/2015
 */
public class IOStreams_8 {
    public static void main(String[] args) {
        //Stream.of("1","1","1","2").distinct().forEach(System.out::println);
        Stream<String> out = zip(Stream.of("1","1","1","2"), Stream.of("1","1","1","2", "3"));
        out.forEach(System.out::print);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        /*int i = 0;
        List<T> firstAsList = new ArrayList<>();
        List<T> secondAsList = new ArrayList<>();
        List<T> outAsList = new LinkedList<>();
        first.forEach(firstAsList::add);
        second.forEach(secondAsList::add);
        while (i < firstAsList.size() && i < secondAsList.size()) {
            outAsList.add(firstAsList.get(i));
            outAsList.add(secondAsList.get(i));
            i++;
        }
        return outAsList.stream();*/

        //better solution
        Iterator<T> secondAsIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        first.forEach((e) -> {
            if (secondAsIterator.hasNext()) {
                builder.accept(e);
                builder.accept(secondAsIterator.next());
            } else {
                first.close();
            }
        });
        return builder.build();
    }
}
