import java.util.HashMap;
import java.util.Map;

public class LightHours {


    // Uses two hashmaps - The first one is meant to sort the inputs according to the keys, so that the processing of adding values to the second hashmap is more accurate.
    // There is definitely a simpler way to do this.
    public static HashMap<Integer, Integer> readInput(String input){
        HashMap<Integer, Integer> intSet = new HashMap<>();
        HashMap<Integer, Integer> holderSet = new HashMap<>();
        char[] intervals = input.toCharArray();
        for(int i = 0; i < intervals.length; i+=2){ // Instantiate first HashMap so that I will have sorted key-value pairs
            int convInt = Character.getNumericValue(intervals[i]), convInt2 = Character.getNumericValue(intervals[i+1]); // Convert array of characters to integer key-values
            holderSet.put(convInt, convInt2);
        }
        int prevRangeBeg = 0, prevRangeEnd = 0; // Variables that hold the current range of values - Used to see if a new range needs to be created or if the current one can be expanded. 
        for(Map.Entry<Integer, Integer> entry : holderSet.entrySet()){
            if(entry.getKey() < prevRangeEnd && entry.getValue() >= prevRangeEnd){ // Check if entry key is within the currently created range. If not, new range is created.
                intSet.put(prevRangeBeg, entry.getValue());
                prevRangeEnd = entry.getValue();
            }else {
                intSet.put(entry.getKey(), entry.getValue()); // Creation of new range
                prevRangeBeg = entry.getKey();
                prevRangeEnd = entry.getValue();
            }
        }
        System.out.println(intSet);
        return intSet;
    }

    // Alternate version of function where an array of integers can be given instead of a string
    public static HashMap<Integer, Integer> readInput(int[] input){
        HashMap<Integer, Integer> intSet = new HashMap<>();
        HashMap<Integer, Integer> holderSet = new HashMap<>();
        for(int i = 0; i < input.length; i+=2){
            holderSet.put(input[i], input[i+1]);
        }
        int prevRangeBeg = 0, prevRangeEnd = 0;
        for(Map.Entry<Integer, Integer> entry : holderSet.entrySet()){
            if(entry.getKey() < prevRangeEnd && entry.getValue() >= prevRangeEnd){
                intSet.put(prevRangeBeg, entry.getValue());
                prevRangeEnd = entry.getValue();
            }else {
                intSet.put(entry.getKey(), entry.getValue());
                prevRangeBeg = entry.getKey();
                prevRangeEnd = entry.getValue();
            }
        }
        System.out.println(intSet);
        return intSet;
    }

    // Computes the total time the lights were on
    public static int hoursOn(HashMap<Integer, Integer> intervals){
        int timeOn = 0;
        for(Map.Entry<Integer, Integer> entry : intervals.entrySet()){
            timeOn += entry.getValue() - entry.getKey();  // Total hours = time left (value) - time entered (key)
        }
        return timeOn;
    }

    public static void main(String ... args){
        String input = "24361368";
        HashMap<Integer, Integer> intervals = readInput(input);
        int totalHours = hoursOn(intervals);
        System.out.println(totalHours);
    }
}
