import java.util.*;
import tetrisclasses.*;

class Tetris
{
  public static void clearScreen()
  {
  try{
      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
  }
  catch(Exception e)
  {
    System.out.println("Problem in clearScreen");
  }
  }
  public static void main(String[] args)
  {
    Board b=new Board();
    b.generate_board();
    char [][]map =new char[][]{{'l','r'},{'r','l'},{'d','u'},{'c','a'},{'a','c'},{'s','p'}};
    ShapeUndo shapeu=new ShapeUndo();
    UndoGame un1=new UndoGame();
    UndoGame un2=new UndoGame();

    int breakgame=0;
    while(true)
    {
      if(breakgame>100)
      {
        break;
      }
      Scanner sc=new Scanner(System.in);
      char ch;
      int breaks=0;
      shapeu.top1=null;
      Shape shape=new Shape();
      int coords[][]=shape.generate_Shape();
      b.setBoard(coords);
      clearScreen();
      b.display_board();
      int i,j,k;
      while(true)
      {
        ch=sc.next().charAt(0);
        for(i=0;i<4;i++)
        {
            if(shape.co[i][0]+1==19)
            {
                breaks=1;
                break;
            }
        }
        if(breaks==1){

              for(i=0;i<coords.length;i++)
            {
                breakgame++;
                b.coord[coords[i][0]]++;
            }
            shapeu.push(shape.val,shape.shaperotation,shape.x,shape.y);
            un1.push('s');
            shapeu.display();
             if(b.findandremove()==1){
              shapeu.top1=null;
          }
            break;
        }
        int newcoords[][]=new int[4][2];
        for(i=0;i<4;i++)
        {
            newcoords[i][0]=shape.co[i][0];
            newcoords[i][1]=shape.co[i][1];
        }
        if(ch=='l')
            coords=shape.moveleft(b.arr);
        else if(ch=='r')
            coords=shape.moveright(b.arr);
        else if(ch=='a')
            coords=shape.rotateleft(b.arr);
        else if(ch=='c')
            coords=shape.rotateright(b.arr);
        else if(ch=='d')
            coords=shape.movedown(b.arr);

        else if(ch=='u')
        {
            if(!un1.isEmpty())
            {
                System.out.println(un1.peek());
                for(i=0;i<6;i++)
                {
                    if(un1.peek()==map[i][0])
                    {

                        if(map[i][1]=='l')
                            coords=shape.moveleft(b.arr);
                        else if(map[i][1]=='u')
                            coords=shape.moveup(b.arr);
                        else if(map[i][1]=='r')
                            coords=shape.moveright(b.arr);
                        else if(map[i][1]=='a')
                            coords=shape.rotateleft(b.arr);
                        else if(map[i][1]=='c')
                            coords=shape.rotateright(b.arr);
                        else if(map[i][1]=='d')
                            coords=shape.movedown(b.arr);
                        else if(map[i][0]=='s')
                        {
                            for(k=0;k<4;k++)
                                b.arr[shape.co[k][0]][shape.co[k][1]]=' ';

                            shape.shaperotation=shapeu.getshaperotation();
                            shape.val=shapeu.getshape();
                            shape.x=shapeu.getx();
                            shape.y=shapeu.gety();

                            if(shape.val==0)
                                shape.make_Stick(shape.shaperotation);
                            else if(shape.val==2)
                                shape.generate_Square(shape.x,shape.y);
                            else if(shape.val==1)
                                shape.make_TShape(shape.shaperotation);
                            else if(shape.val==3)
                                shape.make_LShape(shape.shaperotation);
                            else
                                shape.make_ZShape(shape.shaperotation);
                            for(k=0;k<4;k++)
                                b.coord[shape.co[k][0]]--;
                            coords=shape.moveup(b.arr);
                             shapeu.pop();
                        }
                        un2.push(un1.peek());
                       un1.pop();
                        break;
                    }
                }
            }
        }
        else if(ch=='o' || ch=='O')
        {
            if(!un2.isEmpty())
            {
                for(i=0;i<6;i++)
                {
                    if(un2.peek()==map[i][0])
                    {

                        if(map[i][0]=='l')
                            coords=shape.moveleft(b.arr);
                        else if(map[i][0]=='u')
                            coords=shape.moveup(b.arr);
                        else if(map[i][0]=='r')
                            coords=shape.moveright(b.arr);
                        else if(map[i][0]=='a')
                            coords=shape.rotateleft(b.arr);
                        else if(map[i][0]=='c')
                            coords=shape.rotateright(b.arr);
                        else if(map[i][0]=='d')
                            coords=shape.movedown(b.arr);
                        else if(map[i][0]=='s'){
                            coords=shape.movedown(b.arr);
                            shapeu.push(shape.val,shape.shaperotation,shape.x,shape.y);
                        }
                        un1.push(un2.peek());
                        un2.pop();
                        break;
                    }
                }
            }
        }
        else
        {
            ch='d';
            coords=shape.movedown(b.arr);
        }

            int c=0;
            for(i=0;i<4;i++)
            {
                if(coords[i][0]==newcoords[i][0] && coords[i][1]==newcoords[i][1])
                    c++;
            }

            b.setBoard(coords);
            clearScreen();
            b.display_board();
            if(c!=4 && ch!='u' && ch!='o')
            {
                un1.push(ch);
            }
            if(c==4 && shape.shape_flag==1 && ch!='u' && ch!='o'){
                 for(i=0;i<coords.length;i++)
                {
                    breakgame++;
                    b.coord[coords[i][0]]++;
                }
                shapeu.push(shape.val,shape.shaperotation,shape.x,shape.y);
                un1.push('s');
              if(b.findandremove()==1){
                  shapeu.top1=null;
              }
                break;
            }
      }

    }
    System.out.println("GAME OVER");
  }
}
