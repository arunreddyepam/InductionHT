package org.example.Collections.Task14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    private Properties config;

    public Config() throws IOException {
        reset();
    }

    public void reset() throws IOException {
        // Step 1: Load main config.properties
        Properties mainProps = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            mainProps.load(fis);
        }

        // Step 2: Load default properties (if any)
        String defaultFiles = mainProps.getProperty("default.filenames");

        Properties current = null;

        if (defaultFiles != null && !defaultFiles.trim().isEmpty()) {
            String[] files = defaultFiles.split(",");

            // Load defaults in REVERSE order
            for (int i = files.length - 1; i >= 0; i--) {
                String filename = files[i].trim() + ".properties";
                Properties defaults = new Properties(current);

                try (FileInputStream fis = new FileInputStream(filename)) {
                    defaults.load(fis);
                }

                current = defaults;
            }
        }

        // Step 3: Create final config with defaults
        if (current != null) {
            this.config = new Properties(current);
        } else {
            this.config = new Properties();
        }

        // Step 4: Overlay main properties
        this.config.putAll(mainProps);
    }

    public String get(String key) {
        return config.getProperty(key);
    }

    public void set(String key, String value) {
        config.setProperty(key, value);
    }

    public void remove(String key) {
        config.remove(key);
    }

    public void save() throws IOException {
        Properties toSave = new Properties();

        // Save ONLY direct properties (not defaults)
        for (Object keyObj : config.keySet()) {
            String key = (String) keyObj;

            // Only save properties that belong to main config
            String value = config.getProperty(key);
            toSave.setProperty(key, value);
        }

        try (FileOutputStream fos = new FileOutputStream("config.properties")) {
            toSave.store(fos, null);
        }
    }
}

