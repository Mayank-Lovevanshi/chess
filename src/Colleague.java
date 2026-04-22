package com.chess;
public abstract class Colleague
{
protected ChatMediator chatMediator;
public Colleague()
{
chatMediator = null;
}
public abstract void send(Message message);
public abstract void receive(Message message);
public void setMediator(ChatMediator chatMediator)
{
this.chatMediator = chatMediator;
}
public ChatMediator getMediator()
{
return chatMediator;
}
}

