package com.chess;

public class User extends Colleague
{
private String id;
private String name;
private int score;

public User(String id,String name)
{
super();
this.id = id;
this.name = name;
}
public String getId()
{
return this.id;
}
public String getName()
{
return this.name;
}
public int getScore()
{
return this.score;
}
public void incrementScore(int points)
{
score +=points;
}
public void decrementScore(int points)
{
score-=points;
}
@Override
public String toString()
{
return name+"(Score: "+score+")";
}
@Override
public void send(Message message)
{
if(mediator!=null)
{
mediator.sendMessage(message,this);
}
}
@Override
public void receive(Message message)
{
System.out.println("User "+name+" received message from "+message.getSenderId()+" : "+message.getMessage());
}
}
