package com.jenkins.lab.UnitTest;

import com.jenkins.lab.Palindrome;
import static org.junit.Assert.*;
import org.junit.Test;
public class PalindromeTest {


    @Test
    public void whenEmptyString_thenAccept(){
        Palindrome palindrome = new Palindrome();
        assertTrue(palindrome.isPalindrome(""));
    }
}
