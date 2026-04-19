package com.chess;
import java.util.Objects;
public class Position
{
private int row;
private int col;

public Position(int row,int col)
{
this.row = row;
this.col = col;
}

public int getRow()
{
return row;
}

public int getCol()
{
return col;
}

public boolean isValid()
{
return row>=0 && col>=0 && row<8 && col<8;
}

@Override
public boolean equals(Object obj)
{
if(this==obj) return true;
if(obj==null || this.getClass()!=obj.getClass()) return false;
Position other = (Position)obj;
return row==other.getRow() && col==other.getCol();
}

@Override
public int hashCode()
{
return Objects.hash(row,col);
}

public int compareTo(Position other)
{
if(row!=other.getRow()) return Integer.compare(row,other.getRow());
return Integer.compare(col,other.getCol());
}

@Override
public String toString()
{
return "("+row+","+col+")";
}

public String toChessNotation()
{
char file = (char)('a'+col);
char rank = (char)('8'-row);
return ""+file+rank;
}

}
