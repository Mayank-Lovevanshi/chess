package com.chess;
import java.util.List;
import java.util.ArrayList;
public class Queen extends Piece
{

public Queen(Color color)
{
super(color,PieceType.QUEEN);
}

@Override
public String getSymbol()
{
return "Q";
}

@Override
public List<Position> getPossibleMoves(Position position,Board board)
{
List<Position> moves = new ArrayList<>();
List<Integer> directions = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
int newr,newc;
for(int i=0;i<8;i++)
{
for(int j=1;j<8;j++)
{
newr = position.getRow() + directions[i][0]*j;
newc = position.getCol() + directions[i][1]*j;
Position newPosition = new Position(newr,newc);
if(!newPosition.isValid()) break;
if(board.isOccupiedBySameColor) break;
moves.add(newPosition);
if(board.isOccupied(newPosition)) break;
}
}
return moves;
}

}
