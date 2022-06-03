package com.example.myapplication.Model;

public class Chat {


    private String sender_email, receiver_email, text_message;

    public Chat() {
    }

    public Chat(String sender_email, String receiver_email, String text_message) {
        this.sender_email = sender_email;
        this.receiver_email = receiver_email;
        this.text_message = text_message;
    }

    public Chat(String email, String text_message) {
        this.sender_email = email;
        this.text_message = text_message;
    }

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }

    public String getText_message() {
        return text_message;
    }

    public void setText_message(String text_message) {
        this.text_message = text_message;
    }
}
