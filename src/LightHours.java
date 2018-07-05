import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LightHours {

    public static ArrayList<Integer> readInput(String input){
        ArrayList<Integer> returnList = new ArrayList<>();
        HashMap<Integer, Integer> intSet = new HashMap<>();
        HashMap<Integer, Integer> holderSet = new HashMap<>();
        char[] intervals = input.toCharArray();
        for(int i = 0; i < intervals.length; i+=2){
            int convInt = Character.getNumericValue(intervals[i]), convInt2 = Character.getNumericValue(intervals[i+1]);
            holderSet.put(convInt, convInt2);
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
        for(Map.Entry<Integer, Integer> interval : intSet.entrySet()) {
            returnList.add(interval.getKey());
            returnList.add(interval.getValue());
        }
        return returnList;
    }

    public static ArrayList<Integer> readInput(int[] input){
        ArrayList<Integer> returnList = new ArrayList<>();
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
        for(Map.Entry<Integer, Integer> interval : intSet.entrySet()) {
            returnList.add(interval.getKey());
            returnList.add(interval.getValue());
        }
        return returnList;
    }

    public static int hoursOn(ArrayList<Integer> intervals){
        int hoursOn = 0;
        for(int i = 0; i < intervals.size()-1; i+=2){
            hoursOn += intervals.get(i+1) - intervals.get(i);
        }
        return hoursOn;
    }

    public static void main(String ... args){
        String input = "";
        ArrayList<Integer> intervals = readInput(input);
        System.out.println(intervals);
        int totalHours = hoursOn(intervals);
        System.out.println(totalHours);
    }
}
