package com.chess;
import java.util.Map;
public class Board
{
private Piece[][] pieces;
private Map<Position,Piece> piecePositions;

public Board()
{
board = new Piece[8][8];
piecePosition = new HashMap<>();
initializeBoard();
}
public void initializeBoard()
{

placePiece(new Position(0,0),PieceFactory.createPiece(PieceType.ROOK,Color.BLACK));
placePiece(new Position(0,1),PieceFactory.createPiece(PieceType.KNIGHT,Color.BLACK));
placePiece(new Position(0,2),PieceFactory.createPiece(PieceType.BISHOP,Color.BLACK));
placePiece(new Position(0,3),PieceFactory.createPiece(PieceType.QUEEN,Color.BLACK));
placePiece(new Position(0,4),PieceFactory.createPiece(PieceType.KING,Color,BLACK));
placePiece(new Position(0,5),PieceFactory.createPiece(PieceType.BISHOP,Color.BLACK));
placePiece(new Position(0,6),PieceFactory.createPiece(PieceType.KNIGHT,Color.BLACK));
placePiece(new Position(0,7),PieceFactory.createPiece(PieceType.ROOK,Color.BLACK));

for(int col=0;col<8;col++)
{
placePiece(new Position(1,col),PieceFactory,createPiece(PieceType.PAWN,Color.BLACK));
}

placePiece(new Position(7,0),PieceFactory.createPiece(PieceType.ROOK,Color.WHITE));
placePiece(new Position(7,1),PieceFactory.createPiece(PieceType.KNIGHT,Color.WHITE));
placePiece(new Position(7,2),PieceFactory.createPiece(PieceType.BISHOP,Color.WHITE));
placePiece(new Position(7,3),PieceFactory.createPiece(PieceType.QUEEN,Color.WHITE));
placePiece(new Position(7,4),PieceFactory.createPiece(PieceType.KING,Color,WHITE));
placePiece(new Position(7,5),PieceFactory.createPiece(PieceType.BISHOP,Color.WHITE));
placePiece(new Position(7,6),PieceFactory.createPiece(PieceType.KNIGHT,Color.WHITE));
placePiece(new Position(7,7),PieceFactory.createPiece(PieceType.ROOK,Color.WHITE));

for(int col=0;col<8;col++)
{
placePiece(new Position(6,col),PieceFactory.createPiece(PieceType.PAWN,Color.WHITE));
}

}

void placePiece(Position position,Piece piece)
{
board[position.getRow()][position.getCol()] = piece;
piecePositions.put(pos,piece);
}

void removePiece(Position position,Piece piece)
{
board[position.getRow()][position.getCol()] = null;
peicePositions.remove(position);
}

public getPiece(Position position)
{
return board[position.getRow()][position.getCol()];
}

public boolean isOccupied(Position position)
{
return getPiece(position)!=null;
}

public boolean isOccupiedBySameColor(Position position,Color color)
{
Piece piece = getPiece(position);
if(piece==null) return false;
return piece.getColor==color;
}

public void movePiece(Position from,Position to)
{
Piece pieceToMove = getPiece(from);
if(pieceToMove==null) return;
Piece pieceToCapture = getPiece(to);
if(pieceToCapture!=null)
{
piecePositions.remove(to);
}
board[from.getRow()][from.getCol()] = null;
piecePositions.remove(from);
board[to.getRow()][to.getCol()] = pieceToMove;
piecePositions.put(to,pieceToMove);

piece.setMoved(true);
}

public void getAllPiecesOfColor(Color color)
{
List<Position> pieces = new ArrayList<>();
for(Map.Entry<Position,Piece> entry : piecePositions.entrySet())
{
if(entry.getValue().getColor()==color)
{
pieces.add(entry.getKey());
}
}
return pieces;
}

public Position findKing(Color color)
{
Piece piece;
for(Map<Position,Piece> entry : piecePositions.entrySet())
{
piece = entry.getValue();
if(piece.getType()==PieceType.KING && piece.getColor==color)
{
return entry.getKey();
}
return new Position(-1,-1);
}

}
}
