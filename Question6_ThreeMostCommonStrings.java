//Question 6
//Given a sentence, return the three most common strings in it.
// For example:
// input: "hi there care to discuss algorithm basis or how to solve algorithm or"
// will return - ["algorithm", "or","to"]
// Note: please return the strings in an ascending alphabetic order


import java.util.*;

public class Question6_ThreeMostCommonStrings {
    private String sentence;

    public Question6_ThreeMostCommonStrings(String sentence){
        this.sentence = sentence;
    }

    public List<String> threeMostCommonStrings(){
        //converting the sentence into lowercase and splitting it into words
        String[] words = sentence.toLowerCase().split("\\s+");

        //counting the frequency of each word
        Map<String, Integer> frequency = new HashMap<>();
        for(String word: words){
            frequency.put(word, frequency.getOrDefault(word,0) + 1);
        }

        //using a priority queue to find top 3 by frequency
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
                (a,b) -> a.getValue().equals(b.getValue()) ?
                        b.getKey().compareTo(a.getKey()) :
                        Integer.compare(a.getValue(), b.getValue())
        );

        for(Map.Entry<String, Integer> entry : frequency.entrySet() ){
            priorityQueue.offer(entry);
            //keeping only top 3
            if(priorityQueue.size() > 3){
                priorityQueue.poll();
            }
        }

        //extracting the top 3 words
        List<String> topThreeWords = new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            topThreeWords.add(priorityQueue.poll().getKey());
        }

        // sorting the alphabetically
        Collections.sort(topThreeWords);
        return topThreeWords;
    }

    //Testing the function
    public static void main(String[] agrs){
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        Question6_ThreeMostCommonStrings myQuestion6 = new Question6_ThreeMostCommonStrings(sentence);
        List<String> result = myQuestion6.threeMostCommonStrings();
        System.out.println("The three most common strings are: " + result);
    }
}
