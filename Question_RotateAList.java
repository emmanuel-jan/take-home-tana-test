//Question 7
// In the following question you should rotate a list by moving each element in the
// list n times to the right.
// Example, given the following list:
// "ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->"ID_A05"->"ID_A06"->null and n=2
//"ID_A05"->"ID_A06" "ID_A01"->"ID_A02"->"ID_A03"->"ID_A04
// You should return the following list:
// "ID_A05"->"ID_A06"->"ID_A01"->"ID_A02"->"ID_A03"->"ID_A04"->null

import java.util.LinkedList;

public class Question_RotateAList {
    private LinkedList<String> list;
    private int n;

    public Question_RotateAList(LinkedList<String> list, int n){
        this.list = list;
        this.n = n;
    }

    public LinkedList<String> rotateList(){
        int size = list.size();

        // edge case check
        if(size == 0 || n % size == 0) return list;

        n = n % size; // ensuring n does not exceed the list size

        //getting ths last n elements
        LinkedList<String> rotatedList = new LinkedList<>();
        // adding the last elements of the list
        rotatedList.addAll(list.subList(size - n, size));
        //adding the remaining elements
        rotatedList.addAll(list.subList(0, size - n));

        return rotatedList;
    }

    private static void printList(LinkedList<String> list){
        for(String element : list){
            System.out.print(element + "->");
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        LinkedList<String> list = new LinkedList<>();
        list.add("ID_A01");
        list.add("ID_A02");
        list.add("ID_A03");
        list.add("ID_A04");
        list.add("ID_A05");
        list.add("ID_A06");
        System.out.println("This is the original list:");
        printList(list);

        int n = 2;
        Question_RotateAList myQuestion7 = new Question_RotateAList(list,n);
        System.out.println("Printing out list rotated by " + n + " positions");
        LinkedList<String> rotatedList = myQuestion7.rotateList();
        printList(rotatedList);
    }
}
