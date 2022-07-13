package com.jenkins.lab;

public class Palindrome {

    public boolean isPalindrome(String inputString) {


        if (inputString == null) {
            throw new IllegalArgumentException("Input Should not be null");
        }

        if (inputString.equals(reverse(inputString))) {
            return true;
        } else {
            return false;
        }
    }
        private String reverse(String input){

            String rev = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                rev = rev + input.charAt(i);
            }
            return rev;
        }

}


