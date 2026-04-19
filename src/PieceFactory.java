package com.chess;
public class PieceFactory
{
private PieceFactory(){}
public static Piece createPiece(PieceType pieceType,Color color)
{
switch(pieceType)
{
case KING : return new King(color);
case QUEEN : return new Queen(color);
case KNIGHT : return new Knight(color);
case BISHOP : return new Bishop(color);
case PAWN : return new Pawn(color);
case ROOK : return new Rook(color);
default : return null;
}
}

}
