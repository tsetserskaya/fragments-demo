/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kalicinscy.utils;

import android.os.Build;
import android.text.format.DateFormat;
import java.text.Normalizer;

/**
 *
 * @author Wojtek
 */
public class StringUtils {

    public static String join(Object[] arr) {
        return join(arr, ",");
    }

    public static String join(Object[] arr, String joiner) {
        StringBuilder buf = new StringBuilder();
        for (Object o : arr) {
            buf.append(o.toString());
            buf.append(joiner);
        }
        if (buf.length() > 0) {
            buf.setLength(buf.length() - joiner.length());
        }
        return buf.toString();
    }

    public static String join(int[] arr) {
        StringBuilder buf = new StringBuilder();
        for (int i : arr) {
            buf.append(i);
            buf.append(',');
        }
        if (buf.length() > 0) {
            buf.setLength(buf.length() - 1);
        }
        return buf.toString();
    }

    public static String join(long[] arr) {
        StringBuilder buf = new StringBuilder();
        for (long i : arr) {
            buf.append(i);
            buf.append(',');
        }
        if (buf.length() > 0) {
            buf.setLength(buf.length() - 1);
        }
        return buf.toString();
    }

    public static String date2ago(long date, long now) {
        long seconds = now - date;
        if (seconds < 60) {
            return "moments ago";
        } else if (seconds < 60 * 60) {
            return (seconds / 60) + " minutes ago";
        } else if (seconds < 60 * 60 * 12) {
            return (seconds / 60 / 60) + " hours ago";
        } else {
            return DateFormat.format("EEEE, h:mmaa", date * 1000).toString();
        }
    }

//    one, few, many, other
//    gram, gramy, gramów, grama
    public static String getPlural(float quantity, String[] choices) {
        if (quantity >= 1) {
            switch (quantity == 1 ? 0 : (quantity % 10 >= 2
                    && quantity % 10 <= 4
                    && (quantity % 100 < 10
                    || quantity % 100 >= 20) ? 1 : 2)) {
                case 0:
                    return choices[0];
                case 1:
                    return choices[1];
                case 2:
                    return choices[2];
                default:
                    return choices[3];
            }
        } else if (quantity > 0) {
            return choices[3];
        } else {
            return choices[2];
        }
    }
    
    public static String normalize(String input){
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.GINGERBREAD) {
            return NormalizerBase.normalize(input);
        } else {
            return NormalizerGingerbread.normalize(input);
        }
        
    }
    
    
    private static class NormalizerBase {
        static String from = "aąbcćdeęfghijklłmnoópqrsśtuvwxyzźż";
        static String to = "aabccdeefghijkllmnoopqrsstuvwxyzzz";
        
        public static String normalize(String input){
            input = input.toLowerCase();
            StringBuilder sb = new StringBuilder();
            int fromCharIndex = -1;
            char fromChar;
            for (int i = 0; i < input.length(); i++){
                fromChar = input.charAt(i);
                fromCharIndex = from.indexOf(fromChar);
                if (fromCharIndex != -1){
                    sb.append(to.charAt(fromCharIndex));
                }
            }
            return sb.toString();
        }
    }
    
    private static class NormalizerGingerbread {
        
        public static String normalize(String input){
            input = input.toLowerCase().replaceAll("ł", "l");
            input = Normalizer.normalize(input, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            return input;
        }
    }
}
