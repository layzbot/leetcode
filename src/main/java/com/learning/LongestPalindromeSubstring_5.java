package com.learning;

public class LongestPalindromeSubstring_5 {
    public static void main(String[] args) {
        String input = "ccccc";
        System.out.println(longestPalindromeDP(input));
    }

    /* ------- BRUTE FORCE ---- */
    static public String longestPalindrome(String input) {
        String result = "";
        for(int i=0; i< input.length(); i++) {
            for(int j=i; j<= input.length(); j++) {
                String temp = input.substring(i,j);
                if(isPalindrome(temp) && temp.length()>result.length()) {
                    result = temp;
                }
            }
        }
        return result;
    }
    static boolean isPalindrome(String input) {
        int i=0,j=input.length()-1;

        while(i<=j) {
            if(input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    /* ------- BRUTE FORCE ---- */


    /* DP */
    static public String longestPalindromeDP(String input) {
     int start=0, end=0, maxLen = 0, n = input.length();
     boolean[][] matrix = new boolean[n][n];

     for(int i=0; i<n; i++) {
         matrix[i][i] = true;
         if(i<n-1 && input.charAt(i) == input.charAt(i+1)) {
             matrix[i][i+1]=true;
             maxLen = 2;
             start = i;
             end = i+1;
         }
     }

     /*
     for(int j=2; j<n; j++) {
         for(int i=0; i<j-1; i++) {
             System.out.println("Comparing ("+i+","+j+")");
             System.out.println("Previous Val = " + matrix[i+1][j-1]);

         }
     }

      */

     for(int i=0; i<n-1; i++) {
         for(int j=i+2; j<n; j++) {
             if(matrix[i+1][j-1] == true && input.charAt(i) == input.charAt(j)) {
                 matrix[i][j] = true;
                 if((j-i+1) > maxLen) {
                     maxLen = j - i + 1;
                     start = i;
                     end = j;
                 }
             }
         }
     }

     return input.substring(start,end+1);
    }
    /* DP */
}
