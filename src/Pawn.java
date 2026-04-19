package com.chess;
import java.util.List;
import java.util.ArrayList;
public class Pawn extends Piece
{
public Pawn(Color color)
{
super(color,PieceType.PAWN);
}
@Override
public String getSymbol()
{
return "P";
}
@Override
public List<Position> getPossibleMoves(Position position,Board board)
{
List<Position> moves = new ArrayList<>();
int direction = (this.color==Color.WHITE) ? -1 : 1;
Position newPosition;
int newr,newc;
newr = position.getRow() + direction;
newPosition = new Position(newr,position.getCol());

if(newPosition.isValid() && !board.isOccupied())
{
moves.add(newPosition);
}

if(!moved)
{
newr = position.getRow() + direction*2;
newPosition = new Position(newr,position.getCol());
if(newPosition.isValid() && board.isOccupied())
{
moves.add(newPosition);
}
}

int leftCapture,rightCapture;

newr = position.getRow() + direction;
newc = position.getCol() - 1;

leftCapture = new Position(newr,newc);
if(leftCapture.isValid() && 
	board.isOccupied() && 
	!board.isOccupiedBySameColor(leftCapture,this.color))
{
moves.add(leftCapture);
}

newc = position.getCol() + 1;

rightCapture = new Position(newr,newc);

if(rightCapture.isValid() && 
	board.isOccupied() && 
	!board.isOccupiedBySameColor(rightCapture,this.color))
{
moves.add(rightCapture);
}
return moves;
}

}
