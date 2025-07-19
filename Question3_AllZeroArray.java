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
//

public class Question3_AllZeroArray {
    private int[] list;

    public Question3_AllZeroArray(int[] list){
        this.list = list;
    }

    public int allZeroArray(){
        int num = list[0];

        for(int i = 1; i < list.length; i++){
            num = computeNum(num, list[i]);
        }

        // setting to 1 or 0 if it is possible
        return num == list[0] ? 1 : 0;
    }

    private int computeNum(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args){
        int[] list = {1,2,3};
        Question3_AllZeroArray myQuestion3 = new Question3_AllZeroArray(list);

        System.out.println("isPossible?: " + myQuestion3.allZeroArray());
    }
}
