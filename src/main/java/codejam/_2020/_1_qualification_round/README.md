# Qualification Round 2020
[link](https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c)

## Vestigium (7pts)

### Problem
Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.

The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).

An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.

Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.

### Input
The first line of the input gives the number of test cases, T. T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore. Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. Mi,j is the integer in the i-th row and j-th column of the matrix.

### Output
For each test case, output one line containing Case #x: k r c, where x is the test case number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix that contain repeated elements, and c is the number of columns of the matrix that contain repeated elements.

### Limits
Test set 1 (Visible Verdict)
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
2 ≤ N ≤ 100.
1 ≤ Mi,j ≤ N, for all i, j.

### Sample

#### Input
```
3
4
1 2 3 4
2 1 4 3
3 4 1 2
4 3 2 1
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
3
2 1 3
1 3 2
1 2 3
```

#### Output
```
Case #1: 4 0 0
Case #2: 9 4 4
Case #3: 8 0 2
```

In Sample Case #1, the input is a natural Latin square, which means no row or column has repeated elements. All four values in the main diagonal are 1, and so the trace (their sum) is 4.

In Sample Case #2, all rows and columns have repeated elements. Notice that each row or column with repeated elements is counted only once regardless of the number of elements that are repeated or how often they are repeated within the row or column. In addition, notice that some integers in the range 1 through N may be absent from the input.

In Sample Case #3, the leftmost and rightmost columns have repeated elements.

---
##Nesting Depth (5pts, 11pts)

###Problem
tl;dr: Given a string of digits S, insert a minimum number of opening and closing parentheses into it such that the resulting string is balanced and each digit d is inside exactly d pairs of matching parentheses.

Let the nesting of two parentheses within a string be the substring that occurs strictly between them. An opening parenthesis and a closing parenthesis that is further to its right are said to match if their nesting is empty, or if every parenthesis in their nesting matches with another parenthesis in their nesting. The nesting depth of a position p is the number of pairs of matching parentheses m such that p is included in the nesting of m.

For example, in the following strings, all digits match their nesting depth: 0((2)1), (((3))1(2)), ((((4)))), ((2))((2))(1). The first three strings have minimum length among those that have the same digits in the same order, but the last one does not since ((22)1) also has the digits 221 and is shorter.

Given a string of digits S, find another string S', comprised of parentheses and digits, such that:
all parentheses in S' match some other parenthesis,
removing any and all parentheses from S' results in S,
each digit in S' is equal to its nesting depth, and
S' is of minimum length.

###Input
The first line of the input gives the number of test cases, T. T lines follow. Each line represents a test case and contains only the string S.

###Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the string S' defined above.

###Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
1 ≤ length of S ≤ 100.

Test set 1 (Visible Verdict)
Each character in S is either 0 or 1.

Test set 2 (Visible Verdict)
Each character in S is a decimal digit between 0 and 9, inclusive.

###Sample

####Input
```
4
0000
101
111000
1

```
####Output
```
Case #1: 0000
Case #2: (1)0(1)
Case #3: (111)000
Case #4: (1)
```
  
The strings ()0000(), (1)0(((()))1) and (1)(11)000 are not valid solutions to Sample Cases #1, #2 and #3, respectively, only because they are not of minimum length. In addition, 1)( and )(1 are not valid solutions to Sample Case #4 because they contain unmatched parentheses and the nesting depth is 0 at the position where there is a 1.

You can create sample inputs that are valid only for Test Set 2 by removing the parentheses from the example strings mentioned in the problem statement.


---
## Parenting Partnering Returns (7pts, 12pts)

### Problem
Cameron and Jamie's kid is almost 3 years old! However, even though the child is more independent now, scheduling kid activities and domestic necessities is still a challenge for the couple.

Cameron and Jamie have a list of N activities to take care of during the day. Each activity happens during a specified interval during the day. They need to assign each activity to one of them, so that neither of them is responsible for two activities that overlap. An activity that ends at time t is not considered to overlap with another activity that starts at time t.

For example, suppose that Jamie and Cameron need to cover 3 activities: one running from 18:00 to 20:00, another from 19:00 to 21:00 and another from 22:00 to 23:00. One possibility would be for Jamie to cover the activity running from 19:00 to 21:00, with Cameron covering the other two. Another valid schedule would be for Cameron to cover the activity from 18:00 to 20:00 and Jamie to cover the other two. Notice that the first two activities overlap in the time between 19:00 and 20:00, so it is impossible to assign both of those activities to the same partner.

Given the starting and ending times of each activity, find any schedule that does not require the same person to cover overlapping activities, or say that it is impossible.

### Input
The first line of the input gives the number of test cases, T. T test cases follow. Each test case starts with a line containing a single integer N, the number of activities to assign. Then, N more lines follow. The i-th of these lines (counting starting from 1) contains two integers Si and Ei. The i-th activity starts exactly Si minutes after midnight and ends exactly Ei minutes after midnight.

### Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is IMPOSSIBLE if there is no valid schedule according to the above rules, or a string of exactly N characters otherwise. The i-th character in y must be C if the i-th activity is assigned to Cameron in your proposed schedule, and J if it is assigned to Jamie.

If there are multiple solutions, you may output any one of them. (See "What if a test case has multiple correct solutions?" in the Competing section of the FAQ. This information about multiple solutions will not be explicitly stated in the remainder of the 2020 contest.)

### Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.
0 ≤ Si < Ei ≤ 24 × 60.

#### Test set 1 (Visible Verdict)
2 ≤ N ≤ 10.

#### Test set 2 (Visible Verdict)
2 ≤ N ≤ 1000.

### Sample

####Input
```
4
3
360 480
420 540
600 660
3
0 1440
1 3
2 4
5
99 150
1 100
100 301
2 5
150 250
2
0 720
720 1440
```
####Output
```
Case #1: CJC
Case #2: IMPOSSIBLE
Case #3: JCCJJ
Case #4: CC
```
  
Sample Case #1 is the one described in the problem statement. As mentioned above, there are other valid solutions, like JCJ and JCC.

In Sample Case #2, all three activities overlap with each other. Assigning them all would mean someone would end up with at least two overlapping activities, so there is no valid schedule.

In Sample Case #3, notice that Cameron ends an activity and starts another one at minute 100.

In Sample Case #4, any schedule would be valid. Specifically, it is OK for one partner to do all activities.

---

##ESAb ATAd (1pts, 9pts, 16pts)
### Problem
Last year, a research consortium [had some trouble](https://codingcompetitions.withgoogle.com/codejam/round/0000000000051705/00000000000881de) with a distributed database system that sometimes lost pieces of the data. You do not need to read or understand that problem in order to solve this one!

The consortium has decided that distributed systems are too complicated, so they are storing B bits of important information in a single array on one awesome machine. As an additional layer of security, they have made it difficult to obtain the information quickly; the user must query for a bit position between 1 and B, and then they receive that bit of the stored array as a response.

Unfortunately, this ultra-modern machine is subject to random quantum fluctuations! Specifically, after every 1st, 11th, 21st, 31st... etc. query is sent, but before the response is given, quantum fluctuation causes exactly one of the following four effects, with equal probability:

25% of the time, the array is complemented: every 0 becomes a 1, and vice versa.
25% of the time, the array is reversed: the first bit swaps with the last bit, the second bit swaps with the second-to-last bit, and so on.
25% of the time, both of the things above (complementation and reversal) happen to the array. (Notice that the order in which they happen does not matter.)
25% of the time, nothing happens to the array.
Moreover, there is no indication of what effect the quantum fluctuation has had each time. The consortium is now concerned, and it has hired you to get its precious data back, in whatever form it is in! Can you find the entire array, such that your answer is accurate as of the time that you give it? Answering does not count as a query, so if you answer after your 30th query, for example, the array will be the same as it was after your 21st through 30th queries.

###Input and output
This is an interactive problem. You should make sure you have read the information in the [Interactive Problems section](https://codingcompetitions.withgoogle.com/codejam/faq#interactive-problems) of our FAQ.

Initially, your program should read a single line containing two integers T and B: the number of test cases and the number of bits in the array, respectively. Note that B is the same for every test case.

Then, you need to process T test cases. In each case, the judge begins with a predetermined B-bit array; note that this array can vary from test case to test case, and is not necessarily chosen at random. Then, you may make up to 150 queries of the following form:

Your program outputs one line containing a single integer P between 1 and B, inclusive, indicating which position in the array you wish to look at.
If the number of queries you have made so far ends with a 1, the judge chooses one of the four possibilities described above (complementation, reversal, complementation + reversal, or nothing), uniformly at random and independently of all other choices, and alters the stored array accordingly. (Notice that this will happen on the very first query you make.)
The judge responds with one line containing a single character 0 or 1, the value it currently has stored at bit position P, or N if you provided a malformed line (e.g., an invalid position).
Then, after you have made as many of the 150 queries above as you want, you must make one more exchange of the following form:

Your program outputs one line containing a string of B characters, each of which is 0 or 1, representing the bits currently stored in the array (which will not necessarily match the bits that were initially present!)
The judge responds with one line containing a single letter: uppercase Y if your answer was correct, and uppercase N if it was not (or you provided a malformed line). If you receive Y, you should begin the next test case, or stop sending input if there are no more test cases.
After the judge sends N to your input stream, it will not send any other output. If your program continues to wait for the judge after receiving N, your program will time out, resulting in a Time Limit Exceeded error. Notice that it is your responsibility to have your program exit in time to receive a Wrong Answer judgment instead of a Time Limit Exceeded error. As usual, if the memory limit is exceeded, or your program gets a runtime error, you will receive the appropriate judgment.

###Limits
Time limit: 40 seconds per test set.
Memory limit: 1GB.
1 ≤ T ≤ 100.

Test set 1 (Visible Verdict)
B = 10.

Test set 2 (Visible Verdict)
B = 20.

Test set 3 (Hidden Verdict)
B = 100.

###Testing Tool
You can use this testing tool to test locally or on our servers. To test locally, you will need to run the tool in parallel with your code; you can use our [interactive runner](https://storage.googleapis.com/coding-competitions.appspot.com/interactive_runner.py) for that. The interactive runner was changed after the 2019 contest. Be sure to download the latest version. For more information, read the [Interactive Problems](https://codingcompetitions.withgoogle.com/codejam/faq#interactive-problems) section of the FAQ.

###Local Testing Tool
To better facilitate local testing, we provide you the following script. Instructions are included inside. You are encouraged to add more test cases for better testing. Please be advised that although the testing tool is intended to simulate the judging system, it is NOT the real judging system and might behave differently.

If your code passes the testing tool but fails the real judge, please check the [Coding section](https://codingcompetitions.withgoogle.com/codejam/faq#coding) of our FAQ to make sure that you are using the same compiler as us.

[Download local testing tool](https://codejam.googleapis.com/dashboard/get_file/AQj_6U1J1sPo9tw7JNMSbL8jn9SsS8lo9hUHLBYDH5mNVmgKaV6DJ_zLrVjy9INDjJAIdyRo8tA7aA/local_testing_tool.py)

###Sample Interaction
The following interaction corresponds to Test Set 1.
```
t, b = readline_int_list()      // reads 100 into t and 10 into b.
// The judge starts with the predetermined array for this test case:
// 0001101111. (Note: the actual Test Set 1 will not necessarily
// use this array.)
printline 1 to stdout   // we ask about position 1.
flush stdout
// Since this is our 1st query, and 1 is 1 mod 10, the judge secretly and
// Since this is our 1st query, and 1 is 1 mod 10, the judge secretly and
// randomly chooses one of the four possible quantum fluctuation effects, as
// described above. It happens to choose complementation + reversal, so now
// the stored value is 0000100111.
r = readline_chr()      // reads 0.
printline 6 to stdout   // we ask about position 6.
flush stdout
// Since this is our 2nd query, and 2 is 2 mod 10, the judge does not choose
// a quantum fluctuation effect.
r = readline_chr()      // reads 0.
...
// We have omitted the third through tenth queries in this example.
...
printline 1 to stdout   // we decide to ask about position 1 again.
flush stdout
// Since this is our 11th query, and 11 is 1 mod 10, the judge secretly and
// randomly chooses a quantum fluctuation effect, and happens to get
// reversal, so now the stored value is 1110010000.
r = readline_chr()      // reads 1.
printline 1110110000 to stdout   // we try to answer. why?!?!
flush stdout
ok = readline_chr()     // reads N -- we have made a mistake!
exit                    // exits to avoid an ambiguous TLE error

```

---
##Indicium (7pts, 25pts)
###Problem
Indicium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.

A Latin square is an N-by-N square matrix in which each cell contains one of N different values, such that no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.

The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).

Given values N and K, produce any N-by-N "natural Latin square" with trace K, or say it is impossible. For example, here are two possible answers for N = 3, K = 6. In each case, the values that contribute to the trace are underlined.

```
2 1 3   3 1 2
3 2 1   1 2 3
1 3 2   2 3 1
```


###Input
The first line of the input gives the number of test cases, T. T test cases follow. Each consists of one line containing two integers N and K: the desired size of the matrix and the desired trace.

###Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is IMPOSSIBLE if there is no answer for the given parameters or POSSIBLE otherwise. In the latter case, output N more lines of N integers each, representing a valid "natural Latin square" with a trace of K, as described above.

###Limits
Time limit: 20 seconds per test set.
Memory limit: 1GB.
N ≤ K ≤ N2.

Test set 1 (Visible Verdict)
T = 44.
2 ≤ N ≤ 5.

Test set 2 (Hidden Verdict)
1 ≤ T ≤ 100.
2 ≤ N ≤ 50.

###Sample

####Input
```
2
3 6
2 3
```

####Output
```
Case #1: POSSIBLE
2 1 3
3 2 1
1 3 2
Case #2: IMPOSSIBLE
```
  
Sample Case #1 is the one described in the problem statement.

Sample Case #2 has no answer. The only possible 2-by-2 "natural Latin squares" are as follows:

```
1 2   2 1
2 1   1 2
```
These have traces of 2 and 4, respectively. There is no way to get a trace of 3.