package com.chess;
public interface ChessRules
{
public boolean isValidMove(Move move,Board board);
public boolean isInCheck(Color color,Board board);
public boolean isCheckMate(Color color,Board board);
public boolean isStaleMate(Color color,Board board);
public boolean wouldMoveCauseCheck(Move move,Board board,Color kingColor);
}
