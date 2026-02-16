package org.example.Collections;

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

// Comparator to sort by decreasing score, then by name alphabetically
class Checker implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            // Sort by decreasing score
            return b.score - a.score;
        } else {
            // If scores are equal, sort by name alphabetically
            return a.name.compareTo(b.name);
        }
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player[] player = new Player[n];
        for (int i = 0; i < n; i++) {
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, new Checker());
        for (Player p : player) {
            System.out.println(p.name + " " + p.score);
        }
    }
}