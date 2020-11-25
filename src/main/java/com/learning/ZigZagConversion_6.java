package com.learning;

import java.util.Arrays;

public class ZigZagConversion_6 {
    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        System.out.println(zigzag(input, 4));
    }

    static String zigzag(String input, int n) {
        StringBuffer output = new StringBuffer();
        char[][] arr = new char[n][input.length()];
        int i = 0, x = 0, y = 0;
        boolean forward = true;

        while(i<input.length()) {
            if(y == n-1) {
                forward = false;
            } else if(y == 0) {
                forward = true;
            }
            arr[y][x] = input.charAt(i);
            if (forward) {
                y++;
            } else {
                x++;
                y--;
            }
            i++;
        }

        for(int c = 0; c<n; c++) {
            for(int d = 0; d<input.length(); d++) {
                if(arr[c][d] != '\0') {
                    output.append(arr[c][d]);
                }
            }
        }
        return output.toString();
    }
}
