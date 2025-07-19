//Question 5
// You are given an array of n integer numbers a[0], a[1], ..., a[n - 1].
// Find the distance between the two closest (nearest) minimums in it. It is guaranteed that
// in the array a minimum occurs at least two times.
// Example: Given the following array [1,2,3,1,4,5,2] The function should return 3
// Explanation: 1 is the smallest (minimum) number which appears twice. a[0] = 1 a[3] = 1
// The distance is 3-0 = 3


public class Question5_TwoClosestMinimums {

    private int[] numbers;
    public Question5_TwoClosestMinimums(int[] numbers){
        this.numbers = numbers;
    }

    public int twoClosestMinimums(){
        int minimum = Integer.MAX_VALUE;

        //finding the minimum value in the array
        for(int number : numbers){
            if(number < minimum){
                minimum = number;
            }
        }

        int minimumDistance = Integer.MAX_VALUE;
        int lastIndex = -1;

        //traversing the array and tracking positions of the minimum value
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == minimum){
                if(lastIndex != -1){
                    int distance = i - lastIndex;
                    minimumDistance = Math.min(minimumDistance, distance);
                }
                lastIndex = i;
            }
        }
        return minimumDistance;
    }
    public static void main(String[] args){
        int[] numbers = {1,2,3,1,4,5,2};
        Question5_TwoClosestMinimums myQuestion5 = new Question5_TwoClosestMinimums(numbers);
        System.out.println("The minimum distance is: " + myQuestion5.twoClosestMinimums());
    }
}
