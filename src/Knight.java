package com.chess;
import java.util.List;
import java.util.ArrayList;
public class Knight extends Piece
{
public Knight(Color color)
{
super(color,PieceType.KNIGHT);
}
@Override
public String getSymbol()
{
return "N";
}
@Override
public List<Position> getPossibleMoves(Position position,Board board)
{
List<Position> moves = new ArrayList<>();
int [][] directions = {{-1,-2},{1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,-1},{2,1}};
int newr,newc;
Position newPosition;
for(int i=0;i<8;i++)
{
newr = position.getRow() + directions[i][0];
newc = position.getCol() + directions[i][1];
newPosition = new Position(newr,newc);
if(newPosition.isValid() && !board.isOccupiedBySameColor(newPosition,color))
{
moves.add(newPosition);
}
}
return moves;
}
}
