package org.example.CoreJava.Task4;

public class StringCompressor {
    public static String compress(String str) {
        if (str == null || str.length() == 0) return str;

        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char current = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == current) {
                count++;
            } else {
                compressed.append(current).append(count);
                current = str.charAt(i);
                count = 1;
            }
        }
        // Append the last character and its count
        compressed.append(current).append(count);

        // Return the shorter string
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String input = "aabcccccaaa";
        String result = compress(input);
        System.out.println("Compressed: " + result);
    }
}
