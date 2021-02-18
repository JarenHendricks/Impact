import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * Jaren Hendricks
 * Impact Solution
 * RangeSummarizerTest Class
 *
 * Assumptions: Inputted values are sorted in ascending order
 *              All inputted values are unique
 *              All inputted values are non-negative numbers
 *              Input can be an empty string
 *
 * 19 February 2021
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RangeSummarizerTest {

    //Attribute
    private RangeSummarizer rangeSum;

    /*
     * Void method states when tests start
     */
    @BeforeAll
    public void setupMessage(){
        System.out.println("Starting Test cases");
    }

    /*
     * Creates an RangeSummarizer Object before each test case.
     */
    @BeforeEach
    public void setUp() {
        this.rangeSum = new RangeSummarizer();
    }

    /*
     * Tests Collect Method
     * Test uses Parameterized Testing as different inputs are required for testing.
     * All inputted strings are passed in ValueSource
     */
    @ParameterizedTest(name = "{index} => value inserted is {0}")
    @ValueSource(strings ={
            "", "1", "1,3", "1,2,3,4", "0,2,3,4,6,8,9", "1,3,6,7,8,12,13,14,15,21,22,23,24,31",
            "1,2,4,6,8,9,10,12,13,14", "2,4,6,8,10", "1,2,3,4,5,6,7,8,9,10"
    })
    public void collect(String values) {
        Collection<Integer> actual = rangeSum.collect(values);

        //Tests when input is empty
        if (values.equals(""))
            assertEquals(Arrays.asList(), actual);
        else {
            //Collects the expected result
            Collection<Integer> expected = Arrays.asList(values.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            assertIterableEquals(expected, actual);
        }
    }

    /*
     * Tests summarizeCollection Method
     * Test uses Parameterized Testing as different inputs are required for testing.
     * All inputted strings are passed via inputsToSummarizeCollection method
     */
    @ParameterizedTest(name = "{index} => Input: {0} | Output: {1}")
    @MethodSource("inputsToSummarizeCollection")
    public void summarizeCollection(String input, String expected) {
        assertEquals(expected, rangeSum.summarizeCollection(rangeSum.collect(input)));
    }

    /*
     * Method uses a stream of arguments to collect input and expected output strings.
     * Returns a Stream of Arguments
     */
    private static Stream<Arguments> inputsToSummarizeCollection(){
        return Stream.of(
                Arguments.of("", "Empty List"),
                Arguments.of("1","1"),
                Arguments.of("1,3", "1, 3"),
                Arguments.of("1,2,3,4", "1-4"),
                Arguments.of("0,2,3,4,6,8,9", "0, 2-4, 6, 8-9"),
                Arguments.of("1,3,6,7,8,12,13,14,15,21,22,23,24,31", "1, 3, 6-8, 12-15, 21-24, 31"),
                Arguments.of("1,2,4,6,8,9,10,12,13,14", "1-2, 4, 6, 8-10, 12-14"),
                Arguments.of("2,4,6,8,10", "2, 4, 6, 8, 10"),
                Arguments.of("1,2,3,4,5,6,7,8,9,10", "1-10")
        );
    }

    /*
     * Void method states when all tests have executed
     */
    @AfterAll
    public void exitMessage(){
        System.out.println("Ending Test Cases");
    }

}