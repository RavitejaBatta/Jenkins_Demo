package com.jenkins.lab.UnitTest;

import com.jenkins.lab.Palindrome;
import static org.junit.Assert.*;
import org.junit.Test;
public class PalindromeTest {


    String input1 = "abba";
    Palindrome palin = new Palindrome();
    boolean expected = true;

    @Test
    public void whenEmptyString(){
        assertEquals(expected,palin.isPalindrome(input1));
    }
    @Test
    public void isNotPalindrome(){
        assertEquals(false,palin.isPalindrome("abc"));
    }
    @Test(expected=IllegalArgumentException.class)
    public void isNotPalindromeException(){
        assertEquals(false,palin.isPalindrome(null));
    }
}
