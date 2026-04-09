package org.example.Collections.Task1;

import java.util.*;

public class ArrayListQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < k; j++) {
                row.add(sc.nextInt());
            }

            list.add(row);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            try {
                int value = list.get(x - 1).get(y - 1);
                System.out.println(value);
            } catch (Exception e) {
                System.out.println("ERROR!");
            }
        }
        sc.close();
    }
}
