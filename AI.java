import java.util.*;

public class AI 
{
    public static final int DIAGONAL_COST = 14;
    public static final int V_H_COST = 10;
    
    static class Cell
    {  
        int heuristicCost = 0; //Heuristic cost
        int finalCost = 0; //G+H
        int x;
        int y;
        Cell parent; 
        
        Cell(int x, int y)
        {
            this.x = x;
            this.y = y; 
        }
        
        @Override
        public String toString()
        {
            return "["+this.x+", "+this.y+"]";
        }
    }
    
    //Blocked cells are just null Cell values in grid
    static Cell [][] grid = new Cell[13][9];
    
    static PriorityQueue<Cell> open;
     
    static boolean closed[][];
    static int startX, startY;
    static int endX, endY;
            
    public static void setBlocked(int x, int y)
    {
        grid[x][y] = null;
    }
    
    public static void setStartCell(int x, int y)
    {
        startX = x;
        startY = y;
    }
    
    public static void setEndCell(int x, int y)
    {
        endX = x;
        endY = y; 
    }
    
    static void checkAndUpdateCost(Cell current, Cell t, int cost)
    {
        if(t == null || closed[t.x][t.y])return;
        int t_final_cost = t.heuristicCost+cost;
        
        boolean inOpen = open.contains(t);
        if(!inOpen || t_final_cost<t.finalCost)
        {
            t.finalCost = t_final_cost;
            t.parent = current;
            if(!inOpen)open.add(t);
        }
    }
    
    public static void AI()
    { 
        
        //add the start location to open list.
        open.add(grid[startX][startY]);
        
        Cell current;
        
        while(true)
        { 
            current = open.poll();
            if(current==null)break;
            closed[current.x][current.y]=true; 

            if(current.equals(grid[endX][endY]))
            {
                return; 
            } 

            Cell t;  
            if(current.x-1>=0)
            {
                t = grid[current.x-1][current.y];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.y-1>=0)
                {                      
                    t = grid[current.x-1][current.y-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }

                if(current.y+1<grid[0].length)
                {
                    t = grid[current.x-1][current.y+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
            } 

            if(current.y-1>=0)
            {
                t = grid[current.x][current.y-1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.y+1<grid[0].length)
            {
                t = grid[current.x][current.y+1];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 
            }

            if(current.x+1<grid.length)
            {
                t = grid[current.x+1][current.y];
                checkAndUpdateCost(current, t, current.finalCost+V_H_COST); 

                if(current.y-1>=0)
                {
                    t = grid[current.x+1][current.y-1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }
                
                if(current.y+1<grid[0].length)
                {
                   t = grid[current.x+1][current.y+1];
                    checkAndUpdateCost(current, t, current.finalCost+DIAGONAL_COST); 
                }  
            }
        } 
    }
}