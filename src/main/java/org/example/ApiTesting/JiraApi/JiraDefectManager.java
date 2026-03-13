package org.example.ApiTesting.JiraApi;

import kong.unirest.*;
import java.io.File;

public class JiraDefectManager {
    private static final String JIRA_BASE_URL = "https://your-domain.atlassian.net";
    private static final String EMAIL = "your-email@example.com";
    private static final String API_TOKEN = "your-api-token";
    private static final String PROJECT_KEY = "PROJ";

    private static String defectId = null;

    private static UnirestInstance getUnirest() {
        UnirestInstance unirest = Unirest.spawnInstance();
        unirest.config()
                .defaultBaseUrl(JIRA_BASE_URL)
                .setDefaultHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString((EMAIL + ":" + API_TOKEN).getBytes()))
                .setDefaultHeader("Accept", "application/json")
                .setDefaultHeader("Content-Type", "application/json");
        return unirest;
    }

    // 1. Create the defect in Jira
    public static String createDefect() {
        String body = "{ \"fields\": { \"project\": { \"key\": \"" + PROJECT_KEY + "\" }, \"summary\": \"Test Defect\", \"description\": \"Defect created via API\", \"issuetype\": { \"name\": \"Bug\" } } }";
        HttpResponse<JsonNode> response = getUnirest().post("/rest/api/3/issue")
                .body(body)
                .asJson();
        if (response.getStatus() == 201) {
            String id = response.getBody().getObject().getString("key");
            System.out.println("Defect created with ID: " + id);
            return id;
        } else {
            System.out.println("Failed to create defect: " + response.getBody());
            return null;
        }
    }

    // 2. Update the Defect using defect ID
    public static void updateDefect(String defectId) {
        String body = "{ \"fields\": { \"summary\": \"Updated Test Defect\" } }";
        HttpResponse<String> response = getUnirest().put("/rest/api/3/issue/" + defectId)
                .body(body)
                .asString();
        System.out.println("Update response: " + response.getStatus());
    }

    // 3. Search the Defect created in step 1
    public static void searchDefect(String defectId) {
        String jql = "key=" + defectId;
        HttpResponse<JsonNode> response = getUnirest().get("/rest/api/3/search")
                .queryString("jql", jql)
                .asJson();
        System.out.println("Search result: " + response.getBody());
    }

    // 4. Add an attachment to the issue
    public static void addAttachment(String defectId, String filePath) {
        UnirestInstance unirest = getUnirest();
        unirest.config().setDefaultHeader("X-Atlassian-Token", "no-check");
        HttpResponse<JsonNode> response = unirest.post("/rest/api/3/issue/" + defectId + "/attachments")
                .field("file", new File(filePath))
                .asJson();
        System.out.println("Attachment response: " + response.getStatus());
    }

    // 5. Delete the defect created at step number 1
    public static void deleteDefect(String defectId) {
        HttpResponse<String> response = getUnirest().delete("/rest/api/3/issue/" + defectId)
                .asString();
        System.out.println("Delete response: " + response.getStatus());
    }

    // 6. Create a defect with an attached document
    public static String createDefectWithAttachment(String filePath) {
        String defectId = createDefect();
        if (defectId != null) {
            addAttachment(defectId, filePath);
        }
        return defectId;
    }

    public static void main(String[] args) {
        // 1. Create defect
        String defectId = createDefect();

        // 2. Update defect
        if (defectId != null) updateDefect(defectId);

        // 3. Search defect
        if (defectId != null) searchDefect(defectId);

        // 4. Add attachment
        if (defectId != null) addAttachment(defectId, "path/to/your/file.txt");

        // 5. Delete defect
        if (defectId != null) deleteDefect(defectId);

        // 6. Create defect with attachment
        createDefectWithAttachment("path/to/your/file.txt");
    }
}

