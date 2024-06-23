package com.etalon.aidemo.aidemo.assistance;

public class ChatMessage {

  public ChatMessage(String chatId, String message) {
    this.chatId = chatId;
    this.message = message;
  }
  
  private String chatId;
  private String message;

  public String getChatId() {
    return chatId;
  }
  public String getMessage() {
    return message;
  }
}
