package test.misc;

/*
 http://www.geeksforgeeks.org/shortest-superstring-problem/
 Shortest Superstring Problem
 Given a set of n strings arr[], find the smallest string that contains each string in the given set as substring. We may assume that no string in arr[] is substring of another string.

 Examples:

 Input:  arr[] = {"geeks", "quiz", "for"}
 Output: geeksquizfor

 Input:  arr[] = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"}
 Output: gctaagttcatgcatc


 Algorithm NP-Hard -
 Let arr[] be given set of strings.

 1) Create an auxiliary array of strings, temp[].  Copy contents
 of arr[] to temp[]

 2) While temp[] contains more than one strings
 a) Find the most overlapping string pair in temp[]. Let this
 pair be 'a' and 'b'. 
 b) Replace 'a' and 'b' with the string obtained after combining
 them.

 3) The only string left in temp[] is the result, return it.
 */
public class ShortestSuperString {

}
