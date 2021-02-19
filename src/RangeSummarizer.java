import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

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
     * @return Collection of Integer values
     */
    public Collection<Integer> collect(String input){
        //returns empty list if an empty string is found
        if(input.equals(""))
            return Arrays.asList();

        //Splits the string by commas, maps values to type Integer and collects resultant data in Collection<Integer>.
        return Arrays.asList(input.replaceAll("\\s", "")
                .split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(toList());
    }

    /**
     * Method gets the resultant summarized string
     *
     * @param input Collection<Integer>
     * @return summarized string or "Empty List" if the input is empty
     */
    public String summarizeCollection(Collection<Integer> input){
        //Converts Collection to List
        List<Integer> seq = input.stream().collect(toCollection((ArrayList::new)));

        //Checks if list is empty
        if (input.isEmpty())
            return "Empty List";

        /*Creates a stream, retrieves indexes of starting ranges via filter
         and appends correct ranges to stringBuilder via forEach loop.*/
        IntStream.range(1, input.size())
                .filter(i ->  seq.get(i-1) + 1 != seq.get(i))
                .forEach(i -> {
                    if (i - 1 == start.get())
                        sb.append(String.valueOf(seq.get(start.get()))).append(", ");
                    else
                        sb.append(seq.get(start.get()) + "-" + seq.get(i-1)).append(", ");

                    start.set(i);
                });

        //Appends the final ranges to the stringBuilder Object.
        if (seq.size() - 1 == start.get())
            sb.append(String.valueOf(seq.get(start.get())));
        else
            sb.append(seq.get(start.get()) + "-" + seq.get(seq.size() - 1));

        return sb.toString();
    }

}



