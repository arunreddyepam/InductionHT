package org.example.Java8.Task2;

public class Response {
    String responseBody;
    int statusCode;
    String responseType;

    public Response(String responseBody, int statusCode, String responseType) {
        this.responseBody = responseBody;
        this.statusCode = statusCode;
        this.responseType = responseType;
    }

    @Override
    public String toString() {
        return "Response{body='" + responseBody + "', statusCode=" + statusCode +
                ", type='" + responseType + "'}";
    }
}


