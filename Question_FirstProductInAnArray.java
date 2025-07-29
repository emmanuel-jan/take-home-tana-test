//Question 4
//Unique product Write a method that, efficiently with respect to time and space used,
// finds the first product in an array that occurs only once in that array.
// If there are no unique products in the array, null should be returned.
// For example,
// firstUniqueProduct(new String[] { "Apple", "Computer", "Apple", "Bag" }) should return "Computer".


import java.util.LinkedHashMap;
import java.util.Map;

public class Question_FirstProductInAnArray {
    private String[] products;

    public Question_FirstProductInAnArray(String[] products){
        this.products = products;
    }

    public String firstProduct(){
        if(products == null || products.length == 0 ){
            return null;
        }

        // LinkedHashMap preserves insertion order
        Map<String, Integer> frequency = new LinkedHashMap<>();

        // key value pairs

        //counting frequencies
        for(String product: products){
            frequency.put(product, frequency.getOrDefault(product,0)+1);
        }

        //finding first product with frequency of 1
        for(Map.Entry<String, Integer> entry : frequency.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        //if no unique product is found
        return null;
    }
    public static void main(String[] args){
        String[] products = { "Apple", "Computer", "Apple", "Bag" };
        Question_FirstProductInAnArray myQuestion4 = new Question_FirstProductInAnArray(products);
        System.out.println("The first unique product is: " + myQuestion4.firstProduct());
    }
}
