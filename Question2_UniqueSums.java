//Question 2
// In the following challenge, you are given a number "result" and an array of numbers.
// The function should check how many unique ways the array's numbers can be added to
// match the "result."
// Example: result: 10 array: 1,2,3,4,5
// The function should return: 3
// Example: result: 17 array: 1,2,4,7,5
// The function should return: 1

import java.util.*;

public class Question2_UniqueSums {
    private int result;
    private int[] numbers;


    public Question2_UniqueSums(int result, int[] numbers){
        this.result = result;
        this.numbers = numbers;
    }
    public int uniqueSums(){
        //A set ensures that duplicate combinations are only counted once
        Set<List<Integer>> uniqueCombinations = new HashSet<>();
        Arrays.sort(numbers);
        backtrack(numbers, result, 0, new ArrayList<>(), uniqueCombinations); //recursive method call
        return uniqueCombinations.size();
    }

    private static void backtrack(int[] numbers, // input array
                                  int remaining, // how much more we need to reach the target
                                  int start, // current index to start picking from
                                  List<Integer> currentComboList, // current combination we are building
                                  Set<List<Integer>> result // set that stores all valid combinations
    ){
        //Base case — if the sum of current elements equals the target.
        if(remaining == 0){
            result.add(new ArrayList<>(currentComboList));
        }
        //Base case — if sum exceeds the target, stop exploring further.
        if(remaining < 0){
            return;
        }
        for(int i = start; i < numbers.length; i++){
            currentComboList.add(numbers[i]);
            backtrack(numbers, remaining - numbers[i], i + 1, currentComboList, result); // recursively explore
            currentComboList.remove(currentComboList.size() - 1); // remove the last element added
        }

    }

    public static void main(String[] args){
        int[] numbers1 = {1,2,3,4,5};
        int result1 = 10;

        Question2_UniqueSums myQuestion2TestA = new Question2_UniqueSums(result1, numbers1);
        System.out.println("Unique combinations are: " + myQuestion2TestA.uniqueSums());

        int[] numbers2 = {1,2,4,7,5};
        int result2 = 17;
        Question2_UniqueSums myQuestion2TestB = new Question2_UniqueSums(result2, numbers2);
        System.out.println("Unique combinations are: " + myQuestion2TestB.uniqueSums());
    }
}
