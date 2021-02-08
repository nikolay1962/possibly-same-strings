package com.testtask.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnpackedStringTest {

    @Test
    void getLengthReturnsNullForDefaultConstructor() {
        UnpackedString unpackedString = new UnpackedString();
        assertNull(unpackedString.getLength());
    }

    @Test
    void getLengthReturnsNumberEqualsToNumberInString() {
        UnpackedString unpackedString = new UnpackedString("11");
        assertEquals(unpackedString.getLength(), 11);
    }

    @Test
    void getLengthReturnsNumberEqualsToStringOfLettersLength() {
        String testString = "abc";
        UnpackedString unpackedString = new UnpackedString(testString);
        assertEquals(unpackedString.getLength(), testString.length());
    }

    @Test
    void getContentReturnsNullForDefaultConstructor() {
        UnpackedString unpackedString = new UnpackedString();
        assertNull(unpackedString.getContent());
    }

    @Test
    void getContentReturnsStringOfQuestionsForStringOfDigits() {
        String testValue = "???????????";
        UnpackedString unpackedString = new UnpackedString("11");
        assertEquals(unpackedString.getContent(), testValue);
    }

    @Test
    void getContentReturnsStringOfSameLettersForStringWithoutDigits() {
        String testValue = "abcdef";
        UnpackedString unpackedString = new UnpackedString(testValue);
        assertEquals(unpackedString.getContent(), testValue);
    }

    @Test
    void possiblySameReturnsTrueForEqualStrings() {
        String testValue = "abcdef";
        UnpackedString first = new UnpackedString(testValue);
        UnpackedString second = new UnpackedString(testValue);
        assertEquals(first.possiblySame(second), true);
    }

    @Test
    void possiblySameReturnsFalseForNullStrings() {
        UnpackedString first = new UnpackedString();
        UnpackedString second = new UnpackedString();
        assertEquals(first.possiblySame(second), false);
    }

    @Test
    void possiblySameReturnsTrueForCorrectCaptchas() {
        String[] testValues = {"starwars", "st3ars"};
        UnpackedString first = new UnpackedString(testValues[0]);
        UnpackedString second = new UnpackedString(testValues[1]);
        assertEquals(first.possiblySame(second), true);
    }

    @Test
    void possiblySameReturnsFalseForIncorrectByLengthCaptchas() {
        String[] testValues = {"starwars", "st2ars"};
        UnpackedString first = new UnpackedString(testValues[0]);
        UnpackedString second = new UnpackedString(testValues[1]);
        assertNotEquals(first.getLength(), second.getLength());
        assertEquals(first.possiblySame(second), false);
    }

    @Test
    void possiblySameReturnsFalseForIncorrectByValueCaptchas() {
        String[] testValues = {"starwars", "st3ers"};
        UnpackedString first = new UnpackedString(testValues[0]);
        UnpackedString second = new UnpackedString(testValues[1]);
        assertEquals(first.getLength(), second.getLength());
        assertEquals(first.possiblySame(second), false);
    }
}
