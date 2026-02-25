package org.example.Collections.Task12;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SocialNetwork {

    // user -> set of friends
    private HashMap<String, HashSet<String>> network;

    public SocialNetwork() {
        network = new HashMap<>();
    }

    // Ensure user exists in network
    private void addUserIfAbsent(String user) {
        if (!network.containsKey(user)) {
            network.put(user, new HashSet<>());
        }
    }

    // Add bidirectional friendship
    public void addFriend(String user1, String user2) {
        if (user1 == null || user2 == null) {
            throw new NullPointerException("User cannot be null");
        }

        if (user1.equals(user2)) {
            return; // cannot friend yourself
        }

        addUserIfAbsent(user1);
        addUserIfAbsent(user2);

        network.get(user1).add(user2);
        network.get(user2).add(user1);
    }

    // Remove bidirectional friendship
    public void removeFriend(String user1, String user2) {
        if (user1 == null || user2 == null) {
            throw new NullPointerException("User cannot be null");
        }

        if (network.containsKey(user1)) {
            network.get(user1).remove(user2);
        }
        if (network.containsKey(user2)) {
            network.get(user2).remove(user1);
        }
    }

    // Display all friends for a user
    public void displayFriends(String user) {
        if (user == null) {
            throw new NullPointerException("User cannot be null");
        }

        HashSet<String> friends = network.get(user);
        if (friends == null) {
            System.out.println(user + " has no friends or does not exist.");
        } else {
            System.out.println("Friends of " + user + ": " + friends);
        }
    }

    // -------- High-Level Task --------
    // Suggest mutual friends between two users
    public Set<String> suggestMutualFriends(String user1, String user2) {
        Set<String> result = new HashSet<>();

        if (!network.containsKey(user1) || !network.containsKey(user2)) {
            return result;
        }

        HashSet<String> friends1 = network.get(user1);
        HashSet<String> friends2 = network.get(user2);

        // Find intersection
        for (String f : friends1) {
            if (friends2.contains(f)) {
                result.add(f);
            }
        }

        return result;
    }

    // -------- Medium-Level Task --------
    // Display total number of friends for each user
    public void displayFriendCounts() {
        for (Map.Entry<String, HashSet<String>> entry : network.entrySet()) {
            String user = entry.getKey();
            int count = entry.getValue().size();
            System.out.println(user + " has " + count + " friends.");
        }
    }
}

