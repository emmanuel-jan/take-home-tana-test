//Question 3
//You are given a potentially non-zero integer array a with positive elements.
//You want to make this array all zero (except the first element) by repeatedly doing the
//following decrement operation zero or more times:
//Choose an index i and replace a[i] with a[i]-a[i-1] Find out if this is possible.
// Return 1 if yes and return 0 otherwise.
// Example: a = 1,2,3 You can perform 4 operations to reach the goal:
// Choose i=3, and the array becomes [1,2,1].
// Choose i=2, and the array becomes [1,1,1].
// Choose i=3, and the array becomes [1,1,0].
// Choose i=2, and the array becomes [1,0,0].

//NB
//This is only possible if the Greatest Common Divisor of the entire array is equal to the first
//element.

public class Question3_AllZeroArray {
    private int[] list;

    public Question3_AllZeroArray(int[] list){
        this.list = list;
    }

    public int allZeroArray(){
        int gcd = list[0];

        // loop through the list as we update our GCD
        for(int i = 1; i < list.length; i++){
            gcd = findGCD(gcd, list[i]);
        }

        // setting to 1 or 0 if it is possible
        return gcd == list[0] ? 1 : 0;
    }

    private int findGCD(int a, int b){
        while (b != 0){
            int temp = b; // saving the value of 'b' temporarily
            b = a % b; // updating 'b' to be the remainder of 'a' divided by 'b'
            a = temp; // setting 'a' to the old value of b
        }
        return a;
    }

    public static void main(String[] args){
        int[] list = {1,2,3};
        Question3_AllZeroArray myQuestion3 = new Question3_AllZeroArray(list);

        System.out.println("isPossible?: " + myQuestion3.allZeroArray());
    }
}
