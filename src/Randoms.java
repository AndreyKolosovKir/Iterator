import java.util.Iterator;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected int min;
    protected int max;
    protected List<Integer> randomNumbers;

    public Randoms(int min, int max) {
        this.max = max;
        this.min = min;
        random = new Random();
        randomNumbers = random.ints(min, max + 1)
                .limit(100)
                .boxed()
                .collect(Collectors.toList());
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return (randomNumbers.size() > 0);
            }

            @Override
            public Integer next() {
                if (hasNext()) {
                    Integer num = randomNumbers.get(nextIndex);
                    nextIndex++;
                    return num;
                } else {
                    throw new java.util.NoSuchElementException();
                }
            }
        };
    }
}
