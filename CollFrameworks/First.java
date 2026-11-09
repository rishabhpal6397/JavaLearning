package CollFrameworks;

import java.util.*;

public class First {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(5);
        nums.add(3);
        nums.add(8);
        nums.add(3);
        nums.add(1);

        System.out.println(nums);
        System.out.println(nums.size());
        int max = nums.get(0);
        for(int n : nums){
            if (n > max){ max = n; }
        }
        System.out.println(max);

        Set<Integer> uniqueNums = new HashSet<>(nums);
        System.out.println(uniqueNums);

        Set<Integer> sortedNums = new TreeSet<>(nums);
        System.out.println(sortedNums);// 1, 3, 5, 8
        
        String sentence = "java is fun and java is powerful";
        String[] words = sentence.split(" ");

        Map<String, Integer> wordCountMap = new HashMap<>();
        for(String word : words){
            int count = wordCountMap.getOrDefault(word, 0);
            wordCountMap.put(word, count+1);
        }

        System.out.println("Word Counts: " + wordCountMap);

        System.out.println("\"java\" count: " + wordCountMap.get("java"));
    }
}
