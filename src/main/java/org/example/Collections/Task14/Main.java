package org.example.Collections.Task14;

public class Main {
    public static void main(String[] args) throws Exception {
        Config config = new Config();

        System.out.println("key1 = " + config.get("key1")); // A
        System.out.println("key2 = " + config.get("key2")); // D

        config.remove("key1");
        System.out.println("key1 after remove = " + config.get("key1")); // B

        config.save();
        System.out.println("key1 after save = " + config.get("key1")); // B

        config.set("default.filenames", "default2");
        config.save();

        config.reset();
        System.out.println("key1 after reset = " + config.get("key1")); // C
    }
}

