package org.example.Collections.Task5;

import java.util.*;

public class TreeMapOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // number of test cases

        while (T-- > 0) {
            int Q = sc.nextInt();   // number of queries
            TreeMap<Integer, Integer> map = new TreeMap<>();
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < Q; i++) {
                char type = sc.next().charAt(0);

                switch (type) {
                    case 'a':   // add
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        map.put(x, y);
                        break;

                    case 'b':   // get
                        int key = sc.nextInt();
                        if (map.containsKey(key)) {
                            result.append(map.get(key)).append(" ");
                        } else {
                            result.append("-1 ");
                        }
                        break;

                    case 'c':   // size
                        result.append(map.size()).append(" ");
                        break;

                    case 'd':   // delete
                        int delKey = sc.nextInt();
                        map.remove(delKey);
                        break;

                    case 'e':   // print sorted map
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            result.append(entry.getKey())
                                    .append(" ")
                                    .append(entry.getValue())
                                    .append(" ");
                        }
                        break;
                }
            }

            System.out.println(result.toString().trim());
        }
        sc.close();
    }
}

