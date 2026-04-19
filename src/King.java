pacakge com.chess;
public class King extends Piece
{
public King(Color color)
{
super(color,PieceType.KING);
}
@Override
public String getSymbol()
{
return "K";
}
@Override
public List<Position> getPossibleMoves(Position position,Board board)
{
List<Integer> directions = {{0,1},{1,0},{-1,-1},{1,1},{-1,0},{0,-1},{1,-1},{-1,1}};
List<Position> moves = new ArrayList<>();
int newr,newc;
for(int i=0;i<8;i++)
{
newr = position.getRow() + directions[i][0];
newc = position.getCol() + directions[i][1];
Position newPosition = new Position(newr,newc);
if(newPosition.isValid() && !board.isOccupiedBySameColor(newPosition,this.color))
{
moves.add(newPosition);
}
}
return moves;
}

}
