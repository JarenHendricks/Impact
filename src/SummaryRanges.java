import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int first = nums[0], last = nums[0];

        if(nums.length == 0)
            return result;
        if(nums.length == 1) {
            result.add(first+"");
            return result;
        }

        for(int i = 0; i<nums.length-1; i++){
            if(nums[i+1] == last+1) {
                last++;
                if(last == nums[nums.length-1])
                    result.add(first + "->" + last);
            } else if(nums[i+1] != last+1) {
                if(first == last)
                    result.add(first+"");
                else
                    result.add(first + "->" + last);

                first = nums[i+1];
                last = nums[i+1];
                if(last == nums[nums.length-1])
                    result.add(last +"");
            }

        }

        return result;
    }

    public static List<String> summaryRanges2(int[] nums) {
        List<String> result = new ArrayList<>();

        int len = nums.length;

        if(len == 0)
            return result;

        int a = nums[0];

        for(int i = 0; i<len; i++){
            if(i == len-1 || nums[i]+1 != nums[i+1]){
                if(nums[i] != a)
                    result.add(a + "->" + nums[i]);
                else
                    result.add(a +"");
                if(i != len-1)
                    a=nums[i+1];
            }
        }

        return result;
    }

    public static List<String> summaryRanges3(int[] nums) {

        List<String> res = new ArrayList<>();
        AtomicInteger start = new AtomicInteger(0);

        if (nums.length == 0) {
            return res;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1] + 1) {
                System.out.println(i);
                continue;
            }

            if (i - 1 == start.get())
                res.add(String.valueOf(nums[start.get()]));
            else
                res.add(nums[start.get()] + "->" + nums[i-1]);
            start.set(i);
            System.out.println("Start:" + start );
        }

        //0, 2-4, 6

        if (nums.length - 1 == start.get())
            res.add(String.valueOf(nums[start.get()]));
        else
            res.add(nums[start.get()] + "->" + nums[nums.length - 1]);

        //0, 2-4, 6, 8-9
        return res;

    }

    public static void main(String[] args){
        System.out.println(SummaryRanges.summaryRanges3(new int[]{0,2,3,4,6,8,9}));
        //[1->3, -1, -1, 1->2, 1->2]
    }
}

// Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
// Result: "1, 3, 6-8, 12-15, 21-24, 31",