/**
 * Jaren Hendricks
 * Impact Solution
 * RangeSummarizer Class
 *
 * Assumptions: Inputted values are sorted in ascending order
 *              All inputted values are unique
 *              All inputted values are non-negative numbers
 *              Input can be an empty string
 *
 * 19 February 2021
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class RangeSummarizer implements NumberRangeSummarizer{


    //Attributes
    private StringBuilder sb;
    private AtomicInteger start;

    /**
     * Constructor creates a StringBuilder and AtomicInteger object
     */
    public RangeSummarizer(){
        this.sb = new StringBuilder();
        this.start = new AtomicInteger(0);
    }

    /**
     * Method collects the input
     *
     * @param input accepts strings
     * @return
     */
    public Collection<Integer> collect(String input){
        if(input.equals(""))
            return Arrays.asList();
        return Arrays.asList(input.replaceAll("\\s", "")
                .split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    //get the summarized string
    public String summarizeCollection(Collection<Integer> input){
        List<Integer> seq = input.stream().collect(toCollection((ArrayList::new)));

        if (input.isEmpty())
            return "Empty List";

        IntStream.range(1, input.size())
                .filter(i ->  seq.get(i-1) + 1 != seq.get(i))
                .forEach(i -> {
                    if (i - 1 == start.get())
                        sb.append(String.valueOf(seq.get(start.get()))).append(", ");
                    else
                        sb.append(seq.get(start.get()) + "-" + seq.get(i-1)).append(", ");
                    start.set(i);
                });

        if (seq.size() - 1 == start.get())
            sb.append(String.valueOf(seq.get(start.get())));
        else
            sb.append(seq.get(start.get()) + "-" + seq.get(seq.size() - 1));

        return sb.toString();
    }

}



