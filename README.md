**Tana/Tufin Assessment Test**

Completed with **Java 17**

To run  the code :

javac [filename].java -> java [filename]

eg. run javac Question1_GetLongestString.java 
then run java Question1_GetLongestString

**NB:** All the questions have main methods 
which can be run to test against the expected
results.

<ins>Question 1

To solve this problem, I filtered invalid
strings, used a helper method to validate
efficiently then tracked the longest string 
as I looped through the strings.

<ins>Question 2

To solve the problem on how many unique 
ways the array's numbers can be added to
match the "result." I used backtracking
technique. Using the backtracking algorithm 
I recursively explored all combinations of 
the array. I tracked the current sum and 
stopped exploring when it matched the 
"result" or when the "result" is exceeded.
To avoid duplicates I first sorted the array

<ins>Question 3 

For this problem, in order to
make all elements zero except the first, the
first element must be able to generate all
others using repeated subtractions. This is
only possible if the Greatest Common Divisor
of the entire array is equal to the first
element. For my solution I computed the GCD
of the entire array. If GCD == a[0] return 1
else return 0

<ins>Question 4

The goal of this problem is to find the 
first string that appears only once in the
input array and return null if no such string
exists.I used a LinkedHashMap to store the 
products as keys and their frequencies as 
values

<ins>Question 5

To solve the problem, I found the minimum 
number by iterating through the array, tracked
the position of where the minimum number is.
Any time I encounter each occurrence of the
minimum, I calculate the distance from the
previous occurrence and keep track of the
smallest distance then return the smallest 
distance

<ins>Question 6

To solve this problem I first converted
the sentence to lowercase and split it into
individual words using whitespace. I counted
the word frequencies using a HashMap. I used
a PriorityQueue to efficiently keep only the
top 3 most frequency words while iterating 
through the Map. After extracting the top 3
words I sorted them in alphabetical order.

<ins>Question 7

To rotate the list I first got the size
of the list then normalized n by doing 
n mod size to prevent over rotating the list.
if n is equal to 0 no rotation is needed
else take the subset of last n elements to 
the front then take the subset of 
remaining elements then finally combine 
both parts into a new LinkedList.
