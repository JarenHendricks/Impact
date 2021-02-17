import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class RangeSummarizer implements NumberRangeSummarizer{


    //collect the input
    public Collection<Integer> collect(String input){
        if(input.equals(""))
            return Arrays.asList();
        return Arrays.asList(input.split(",")).stream().map(Integer::parseInt).collect(toList());
    }

}



