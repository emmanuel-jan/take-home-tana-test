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
        Set<List<Integer>> uniqueCombinations = new HashSet<>();
        Arrays.sort(numbers);
        backtrack(numbers, result, 0, new ArrayList<>(), uniqueCombinations);
        return uniqueCombinations.size();
    }

    private static void backtrack(int[] numbers,
                                  int rem,
                                  int start,
                                  List<Integer> currentComboList,
                                  Set<List<Integer>> res ){
        if(rem == 0){
            res.add(new ArrayList<>(currentComboList));
        }
        if(rem < 0){
            return;
        }
        for(int i = start; i < numbers.length; i++){
            currentComboList.add(numbers[i]);
            backtrack(numbers, rem - numbers[i], i + 1, currentComboList, res);
            currentComboList.remove(currentComboList.size() - 1);
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
