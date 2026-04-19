package com.chess;
public class Move
{
private Position from;
private Position to;
private Piece piece;
private Piece capturedPiece;

public Move()
{
this.piece = null;
this.capturedPiece = null;
}

public Move(Position from,Position to,Piece piece,Piece capturedPiece)
{
this.from = from;
this.to = to;
this.piece = piece;
this.capturedPiece = capturedPiece;
}

public Position getFrom()
{
return this.from;
}

public Position getTo()
{
return this.to;
}

public Piece getPiece()
{
return piece;
}

public Piece getCapturedPiece()
{
return capturedPiece;
}


}
