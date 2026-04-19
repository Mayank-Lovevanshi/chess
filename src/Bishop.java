package com.chess;
import java.util.List;
import java.util.ArrayList;
public class Bishop extends Piece
{
public Bishop(Color color)
{
super(color,PieceType.BISHOP);
}
@Override
public String getSymbol()
{
return "B";
}
@Override
public List<Position> getPossibleMoves(Position position,Board board)
{
List<Position> moves = new ArrayList<>();
int [][] directions = {{1,1},{-1,-1},{-1,1},{1,-1}};
int newr,newc;
Position newPosition;
for(int i=0;i<4;i++)
{
for(int j=1;j<8;j++)
{
newr = position.getRow() + directions[i][0]*j;
newc = position.getCol() + directions[i][1]*j;
newPosition = new Position(newr,newc);
if(!newPosition.isValid()) break;
if(board.isOccupiedBySameColor(newPosition,color)) break;
moves.add(newPosition);
if(board.isOccupied(newPosition)) break;
}
}
return moves;
}

}
