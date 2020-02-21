package com.example.mahmoudsaed.taskhome.data.remote;

/**
 * Created by Mahmoud Saed on 2/19/2020.
 */

public class Response {
    private Data data;
    private String status_code;
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
