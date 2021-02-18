import java.util.Collection;

/**
 * Jaren Hendricks
 * Impact Solution
 * Main Class
 *
 * Class uses Methods located in RangeSummarizer to return the final result.
 *
 * Assumptions: Inputted values are sorted in ascending order
 *              All inputted values are unique
 *              All inputted values are non-negative numbers
 *              Input can be an empty string
 *
 * 19 February 2021
 */
public class Main {
    public static void main(String[] args) {
        RangeSummarizer rangeSum = new RangeSummarizer();
        Collection<Integer> array = rangeSum.collect("1,3");
        System.out.println(rangeSum.summarizeCollection(array));
    }
}
