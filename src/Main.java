import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        RangeSummarizer rangeSum = new RangeSummarizer();
        Collection<Integer> array = rangeSum.collect("0,2,3,4,6,8,9");
        System.out.println(rangeSum.summarizeCollection(array));
    }
}
