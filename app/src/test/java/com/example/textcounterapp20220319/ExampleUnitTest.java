package com.example.textcounterapp20220319;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

import com.example.textcounterapp20220319.utils.TextUtils;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */



public class ExampleUnitTest {


    public static class Generator {
        public static String generateRandomString(int len) {
            String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                    +"lmnopqrstuvwxyz";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder(len);
            for (int i = 0; i < len; i++)
                sb.append(chars.charAt(rnd.nextInt(chars.length())));
            return sb.toString();
        }
    }


    @Test
    public void getCharsCount_Given_RandomString_Result() {
        String givenString = Generator.generateRandomString(99999999);
        int expectedValue = 99999999;
        int actualValue = TextUtils.getCharsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCharsCount_Given_EmptyString_Result_Zero() {
        String givenString = "";
        int expectedValue = 0;
        int actualValue = TextUtils.getCharsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCharsCount_Given_SymbolString_Result() {
        String givenString = "~`!@#$%^&*()-_=+[]{}'/?";
        int expectedValue = 23;
        int actualValue = TextUtils.getCharsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCharsCount_Given_NormalString_Result() {
        String givenString = "123 4567 890 1";
        int expectedValue = 14;
        int actualValue = TextUtils.getCharsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = NullPointerException.class)
    public void getCharsCount_Given_NullString_Result_Exception() {
        String givenString = null;
        int actualValue = TextUtils.getCharsCount(givenString);
    }



    /** Ne??inau ar gerai toks testavimas zodziams, nes MainActivity funkcija wordsCount String'?? splitina per tarpo simbol?? ir gauna array tipo elementus.
     * Mano atveju, jeigu paduodi string'a ("123 456 789 8"), tai jis yra per tarp?? splitinamas ?? {"123", "456", "789" "8"}.
     * Tuomet ??ie atskiri elemntai esantys array yra suskai??iuojami ir gr????inamas ??od??i?? skai??ius.
     * Testuojant negaliu perduoti tokios reik??m??s ("123 456 789 8"), nes funkcij?? j?? mato, kaip 1 element??, nors yra 4 ??od??iai.
     * Kaip suprantu vienas testavimas tur??t?? b??ti ar gerai splitinamas stringas per tarp??, o kitas testavimas ar gerai suskai??iuojami array elementai? */

    @Test
    public void getWordsCount_Given_SymbolString_Result() {
        String[] givenString = {"@#$","%^$",",.,.","+_)"};
        int expectedValue = 4;
        int actualValue = TextUtils.getWordsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_Given_SpaceString_Result() {
        String[] givenString = {".,.,.,.,"};
        int expectedValue = 1;
        int actualValue = TextUtils.getWordsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_Given_EmptyString_Result() {
        String[] givenString = {};
        int expectedValue = 0;
        int actualValue = TextUtils.getWordsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getWordsCount_Given_NormalString_Result() {
        String[] givenString = {"123","456","789","8"};
        int expectedValue = 4;
        int actualValue = TextUtils.getWordsCount(givenString);

        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = NullPointerException.class)
    public void getWordsCount_Given_NullString_Result_Exception() {
        String[] givenString = null;
        int actualValue = TextUtils.getWordsCount(givenString);
    }


}
