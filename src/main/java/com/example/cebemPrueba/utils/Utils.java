package com.example.cebemPrueba.utils;

import java.text.MessageFormat;

public class Utils {

    public static String count(String cadena) {
        int vCount = 0, cCount = 0;
        String cad = cadena.toLowerCase();
        for (int i = 0; i < cad.length(); i++) {

            char ch = cad.charAt(i);

            if (Character.isAlphabetic(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vCount++;

                } else {
                    cCount++;
                }
            }
        }
        Object params[] = { vCount, cCount };
        return MessageFormat.format("El número de vocales es {0} y de consonantes {1}", params);

    }

    public static String decimalToBinary(int decimal) {
        if (decimal <= 0) {
            return "0";
        }
        String binary = "";
        while (decimal > 0) {
            short remainder = (short) (decimal % 2);
            decimal = decimal / 2;
            binary = String.valueOf(remainder) + binary;
        }
        return binary;
    }

    public static String convertTextToBinary(String cad) {
        String binaryText = "";
        for (int i = 0; i < cad.length(); i++) {
            char currentChar = cad.charAt(i);
            int ascii = (int) currentChar;
            String binary = decimalToBinary(ascii);
            binaryText += binary + " ";
        }
        return binaryText;
    }
}
