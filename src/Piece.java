package com.chess;
import java.util.List;
public abstract class Piece
{
protected Color color;
protected PieceType pieceType;
protected boolean moved;

public Piece(Color color,PieceType pieceType)
{
this.color = color;
this.pieceType = pieceType;
moved = false;
}

public Color getColor()
{
return this.color;
}

public PieceType getPieceType()
{
return this.pieceType;
}

public void setMoved(boolean moved)
{
this.moved = moved;
}

public boolean getMoved()
{
return moved;
}

public abstract List<Position> getPossibleMoves(Position from,Board board);
public abstract String getSymbol();
public String toString()
{
String colorStr = (color==Color.WHITE) ? "W" : "B";
return colorStr+getSymbol();
}
}
