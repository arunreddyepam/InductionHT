package org.example.Collections.Task12;

public class Main {
    public static void main(String[] args) {

        SocialNetwork sn = new SocialNetwork();

        sn.addFriend("Alice", "Bob");
        sn.addFriend("Bob", "Charlie");

        sn.displayFriends("Alice");
        sn.displayFriends("Bob");
        sn.displayFriends("Charlie");

        // Mutual friends
        System.out.println("Mutual friends of Alice and Charlie: " +
                sn.suggestMutualFriends("Alice", "Charlie"));

        // Friend counts
        sn.displayFriendCounts();

        // Remove friendship
        sn.removeFriend("Alice", "Bob");
        sn.displayFriends("Alice");
        sn.displayFriends("Bob");
    }
}

