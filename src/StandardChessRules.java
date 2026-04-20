package com.chess;
import java.util.List;

public class StandardChessRules extends ChessRules
{
@Override
public boolean isValidMove(Move move,Board board)
{
Piece piece = move.getPiece();
List<Position> positions = piece.getPossibleMoves(move.getFrom(),board);
boolean isValidDestination = false;
for(Position position : positions)
{
if(position.equals(move.getTo())) isValidDestination = true;
}
if(!isValidDestination) return false;
return !wouldMoveCauseCheck(move,board,piece.getColor());
}

@Override
public boolean wouldMoveCauseCheck(Move move,Board board,Color kingColor)
{
Piece movingPiece = board.getPiece(move.getFrom());
Piece capturedPiece = board.getPiece(move.getTo());

if(movingPiece==null) return true; // Invalid move
// simulate the move
board.removePiece(move.getFrom());
if(capturedPiece!=null)
{
board.removePiece(move.getTo());
}
board.placePiece(move.getTo(),movingPiece);
bool isCheck = isInCheck(kingColor,board);

// undo the move
board.removePiece(move.getTo());
board.placePiece(move.getFrom(),movingPiece);
if(capturedPiece!=null)
{
board.placePiece(move.getTo(),capturedPiece);
}
return isCheck;
}

@Override
public boolean isInCheck(Color color,Board board)
{
Position kingPosition = board.findKing(color);
if(kingPosition.getRow()==-1) return false;
Color opponentColor = (color==Color.WHITE) ? Color.BLACK : Color.WHITE;
List<Position> opponentPiecesPosition = board.getAllPiecesOfColor(opponentColor);
for(Position pos : opponentPiecesPosition)
{
Piece opponentPiece = board.getPiece(pos);
List<Position> opponentMoves = opponentPiece.getPossibleMoves(pos,board);
for(Position opponentPos : opponentMoves)
{
if(opponentPos.equals(kingPosition)) return true;
}
}
return false;
}

@Override
public boolean isCheckMate(Color color,Board board)
{
if(!isInCheck(color,board)) return false;
List<Position> piecePositions = board.getAllPiecesOfColor(color);
for(Position pos : piecePositions)
{
Piece piece = board.getPiece(pos);
List<Position> pieceMoves = piece.getPossibleMoves(pos,board);
for(Position targetPos : pieceMoves)
{
Move move = new Move(pos,targetPos,piece,board.getPiece(targetPos));
if(isValidMove(move,board)) return false;
}
}
return true;
}

@Override
public boolean isStaleMate(Color color,Board board)
{
if(isInCheck(color,board)) return false;
List<Position> piecePositions = board.getAllPiecesOfColor(color);
for(Position pos : piecePositions)
{
Piece piece = board.getPiece(pos);
List<Position> pieceMoves = piece.getPossibleMoves(pos,board);
for(Position targetPos : pieceMoves)
{
Move move = new Move(pos,targetPos,piece,board,getPiece(targetPiece));
if(isValidMove(move,board)) return false;
}
}
return true;
}

}
