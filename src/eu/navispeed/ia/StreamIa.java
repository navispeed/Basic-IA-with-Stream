package eu.navispeed.ia;

import eu.navispeed.Choice;
import eu.navispeed.Combinaison;
import eu.navispeed.Referee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIa implements IA {

    //    private Stream<int[]> memory;
    private Supplier<Stream<int[]>> count;
    private Integer base;
    private Integer length;
    private int size;

    public StreamIa(Integer usableNb, Integer length) {
        if (usableNb > 9) {
            throw new IndexOutOfBoundsException("usableNb should be < to 10");
        }
        this.base = usableNb + 1;
        this.length = length;
        this.count = () -> Stream.iterate(new int[length], (t) -> {
            Combinaison combinaison = new Combinaison(t, usableNb + 1);
            combinaison.increment();
            return combinaison.getC();
        }).limit((long) Math.pow(usableNb + 1, length)).parallel().sorted((a, b) -> { //TODO improve sort
            int ac = 0;
            int bc = 0;
            for (int i = 1; i < a.length; ++i) {
                if (a[i - 1] != a[i]) {
                    ac++;
                }
                if (b[i - 1] != b[i]) {
                    bc++;
                }
            }
            return Integer.compare(bc, ac);
        });
        this.size = (int) this.count.get().count();
    }

    @Override
    public int[] play() {
        return this.count.get().findFirst().get();
    }

    public void response(Choice c) {
        Stream<int[]> stream = this.count.get().parallel().filter((i) -> Referee.isValid(i, c));
        List<int[]> collect = stream.collect(Collectors.toList());
        this.count = collect::stream;
        this.size = collect.size();
    }

    public long length() {
        return this.size;
    }
}
