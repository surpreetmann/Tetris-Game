package tetrisclasses;

import java.util.*;

public class Board{
  public char[][]arr=new char[20][20];
  public int[] coord=new int[20];
  int i,j,k;
  public void generate_board(){

    for(i=0;i<20;i++)
    {
        for(j=0;j<20;j++)
        {
            if(j==19 || j==0)
                arr[i][j]='|';
          else  if(i==0 || i==19)
                arr[i][j]='-';
            else
                arr[i][j]=' ';
        }
    }
    for(int i=0;i<20;i++)
        coord[i]=0;
  }
  public int findandremove(){
      for(i=1;i<=18;i++)
      {
          if(coord[i]==18)
          {
              coord[i]=0;
              for(j=1;j<=18 ;j++)
                  arr[i][j]=' ';

              for(k=i;k>=2;k--)
              {
                  coord[k+1]=0;
                  for(int j=1;j<19;j++){
                  arr[k+1][j]=' ';
                      if(k!=18){
                          if(arr[k][j]!=' ')
                          coord[k+1]++;
                      arr[k+1][j]=arr[k][j];
                      }
                  }
              }
              return 1;
              }
          }
      return 0;
      }


      public void board_initiate(){

      for(i=0;i<20;i++)
      {
          for(j=0;j<20;j++)
          {
              if(j==19 || j==0)
                  arr[i][j]='|';
            else  if(i==0 || i==19)
                  arr[i][j]='-';
          }
      }
  }

  public void setBoard(int mat[][])
  {

      for(i=0;i<mat.length;i++)
      {
              arr[mat[i][0]][mat[i][1]]='#';
      }
      board_initiate();
  }

  public void display_board(){

      for(i=0;i<20;i++)
      {
          for(j=0;j<20;j++)
          {
              System.out.print(arr[i][j]);
          }
          System.out.println();
      }
  }
}
