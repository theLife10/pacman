import java.util.Scanner; 
public class experiment02
{ 
  public static void main(String [] args)
  {
    String[][] grid = new String[15][15]; 
    int row = 5; 
    int col = 5;
    
    
    initialize(grid);
    
    Scanner keyboard = new Scanner(System.in); 
    
    while(true)
    { 
      print(grid);
      
      String option = keyboard.nextLine(); 
      if(option.equals("s"))   //down
      { 
        grid[row][col]=" ";
        row++;
        if(checkBoudaries(grid,row,col))
        {
          
          updateGrid(grid,row,col);
        }
        
        else 
        {

          row--; 
          grid[row][col]="P"; 
         
        }
      } 
      
      else if(option.equals("w")) //up
      {
        grid[row][col]=" ";
        row--;
        if(checkBoudaries(grid,row,col))
        { 
          updateGrid(grid,row,col);
        }
        else
        {
          row++;
          grid[row][col]="P";
        }
      }
      else if(option.equals("a")) //left
      {
        grid[row][col]=" ";
        col--; 
        if(checkBoudaries(grid,row,col))
        {
          updateGrid(grid,row,col);
        }
        else
        {
          col++;
          grid[row][col]="P";
        }
      }
      else if(option.equals("d")) //right
      {
        grid[row][col]=" ";
        col++;
        if(checkBoudaries(grid,row,col))
        {
          updateGrid(grid,row,col);
        }
        else
        {
          col--;
          grid[row][col]="P";
        }
      }
      if(row == 14 && col==6)
      {
         updateGrid(grid,row,col);
         row-=14;
         grid[row][col]="P";
      }
      else if(row ==0 && col ==6)
      {
         updateGrid(grid,row,col);
         row+=14;
         grid[row][col]="P";
      }
      else if(row == 6 && col ==0)
      {
        updateGrid(grid,row,col);
        col+=14;
        grid[row][col]="P";
      }
      else if(row ==6 && col == 14)
      {
        updateGrid(grid,row,col);
        col-=14;
        grid[row][col]="P";
      }
      else
      {
        
      }
    }
  }
  public static void initialize(String [][] grid)
  {
    
    for(int row =0; row < grid.length; row++)
    {
      for(int col=0; col < grid[row].length; col++)
      {
        if(row ==0 || row ==14)
        {
          grid[0][col]="X";
          grid[14][col]="X";
          grid[0][6]=" ";
          grid[14][6]=" ";
        }
        else if(col == 0 || col == 14)
        {
          grid[row][0]="X";
          grid[row][14]="X";
          grid[6][0]=" ";
          grid[6][14]=" ";  
        }
        else
        {
          grid[row][col]=".";
        }
      }
    }
    grid[5][5]="P";
  }
  public static void print(String [][] grid)
  {
    for(int row =0; row < grid.length; row++)
    {
      for(int col=0; col < grid[row].length; col++)
      {
        System.out.print(grid[row][col]); 
      }
      System.out.println(" ");
    }
  }
  public static void updateGrid(String [][] grid,int row,int col)
  {
    System.out.println(checkScore(grid));
    
    if(checkBoudaries(grid,row,col))
    {
      grid[row][col]="P";
    }
    if(row ==14 && col==6)
    {
      grid[row][col]=" ";
      row=0;
      col=6;
      grid[row][col]="P";
      
    }
    else if(row ==0 && col == 6)
    {
      grid[row][col]=" ";
      row=14;
      col=6;
      grid[row][col]="P";
    }
    else if(row ==6 && col==0)
    {
      grid[row][col]=" ";
      row=6;
      col=14;
      grid[row][col]="P";
    }
    else if(row ==6 && col==14)
    {
      grid[row][col]=" ";
      row=6;
      col=0;
      grid[row][col]="P";
    }
  }
  public static int checkScore(String [][] grid)
  {
    int score=0; 
    for(int row =0; row < grid.length; row++)
    {
      for(int col=0; col < grid[row].length; col++)
      {
        if(grid[row][col].equals(" "))
        {
          score++;
        }
      }
    }
    return score-4;
  }
  public static boolean checkBoudaries(String [][] grid,int row,int col)
  {
    if(row == 0 && col==6)
    {
      return true;
    }
    else if(row==14 && col==6)
   {
      return true;
    }
    else if(row ==6 && col ==0)
    {
      return true;
    }
    else if(row ==6 && col ==14)
    {
      return true; 
    }
    else if(row == 0 || row == 14)
    {
      return false;
    }
    
    else if(col == 0 || col == 14)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}

