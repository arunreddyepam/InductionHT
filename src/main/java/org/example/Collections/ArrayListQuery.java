package org.example.Collections;

import java.util.*;

public class ArrayListQuery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // Number of lines
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();

        // Read n lines
        for (int i = 0; i < n; i++) {
            int d = scanner.nextInt(); // Number of integers in this line
            ArrayList<Integer> line = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                line.add(scanner.nextInt());
            }
            lines.add(line);
        }

        int q = scanner.nextInt(); // Number of queries

        // Process queries
        for (int i = 0; i < q; i++) {
            int x = scanner.nextInt(); // Line number (1-based)
            int y = scanner.nextInt(); // Position in line (1-based)

            // Check bounds
            if (x < 1 || x > lines.size() || y < 1 || y > lines.get(x - 1).size()) {
                System.out.println("ERROR!");
            } else {
                System.out.println(lines.get(x - 1).get(y - 1));
            }
        }
    }
}