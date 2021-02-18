/**
 * Jaren Hendricks
 * Impact Solution
 * Main Class
 *
 * Assumptions: Inputted values are sorted in ascending order
 *              All inputted values are unique
 *              All inputted values are non-negative numbers
 *              Input can be an empty string
 *
 * 19 February 2021
 */

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        RangeSummarizer rangeSum = new RangeSummarizer();
        Collection<Integer> array = rangeSum.collect("0, 3");
        System.out.println(rangeSum.summarizeCollection(array));
    }
}
