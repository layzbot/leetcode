package com.learning;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(maxNoRepeat_slidingWindow("bbbbb"));
    }

    //n cube
    static int maxNoRepeat_brute(String input) {
        if(input == null || input.length() == 0) {
            return 0;
        } else if(input.length() == 1) {
            return 1;
        }
        int currentMax = 0;
        for(int i=0; i<input.length(); i++) {
            for(int j = input.length(); j>i; j--) {
             //   System.out.println("Comparing "+i+" & "+j+ " ===> "+input.substring(i,j));
                Set<Character> subStrSet = new HashSet(input.substring(i,j).chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
                if(subStrSet.size() == (j-i) && (j-i) > currentMax) {
                    currentMax = j-i;
                }
            }
        }
        return currentMax;
    }

    //O(n)
    static int maxNoRepeat_slidingWindow(String input) {
        Set<Character> set = new HashSet<>(input.length());
        int i=0, j=0, output=0;

        while(i<input.length() && j<input.length()) {
            if(!set.contains(input.charAt(j))) {
                set.add(input.charAt(j));
                j++;
                output = Math.max(output, j-i);
            } else {
                set.remove(input.charAt(i));
                i++;
            }
        }
        return output;
    }


}
