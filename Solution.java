package HackerRank;

/*Zigzag array
 * We say an array of  distinct integers
 * is zigzag if no three consecutive elements in the array are either increasing or decreasing.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int count = 0;
    static boolean isItZigzag(ArrayList<Integer> a){
        if(a.size()<3){ 
            return true;
        }else{ 
           boolean zigzag = true;
           //int len = a.size();
           for (int i = 0; i<a.size()-2;i++) { 
                  //ascending and descending 
                  if( (a.get(i)<a.get(i+1) && a.get(i+1)<a.get(i+2) )||( a.get(i)>a.get(i+1) && a.get(i+1)>a.get(i+2)) ){ 
                  zigzag = false; 
                  //System.out.println("not zigzag");
                  //remove the middle and bring back the iterator i 
                  a.remove(i+1);
                  //System.err.println("arrList changed: " + a);
                  i--;
                  //count the removed elements 
                  count+=1;
                                    
               }
            } 
            //System.err.println("arrList cut: " + a);
            System.out.println("count: "+count);
            return zigzag;     
        }     
    }    
    static int minimumDeletions(ArrayList<Integer> a){
        if(isItZigzag(a)==true){
          return count;  
        }else{
            return minimumDeletions(a);  
        }
         
        // Complete this function
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int count = 0;
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        for(int a_i=0; a_i < n; a_i++){
            arr.add(in.nextInt());
        }
        // Return the minimum number of elements to delete to make the array zigzag
        int result = minimumDeletions(arr);
        System.out.println(result);
    }
}