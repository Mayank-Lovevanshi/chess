package com.chess;
public interface ChatMediator
{
void sendMessage(Message message,User user);
void addUser(User user);
void removeUser(User user);
}
