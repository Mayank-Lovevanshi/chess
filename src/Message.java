package com.chess;

public class Message
{
private String senderId;
private String message;
private long timestamp;
public Message(String senderId,String message)
{
this.senderId = senderId;
this.message = message;
this.timestamp = System.currentTimeMillis();
}
public String getSenderId()
{
return this.senderId;
}
public String getMessage()
{
return this.message;
}
public long getTimestamp()
{
return this.timestamp;
}
@Override
public String toString()
{
return "["+senderId+"]: "+message;
}
}

