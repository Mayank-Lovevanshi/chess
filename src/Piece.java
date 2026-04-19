package com.chess;
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

public boolean setMoved(boolean moved)
{
this.moved = moved;
}

public boolean getMoved()
{
return moved;
}

public abstract List<Position> getPossibleMoved(Position from,Board board);
public abstract String getSymbol();
public String toString()
{
String colorStr = (color=Color.WHITE) ? "W" : "B";
return colorStr+getSymbol();
}
}
