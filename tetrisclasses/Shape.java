package tetrisclasses;

import java.util.*;

public class Shape{

        public int co[][];
        public int shape_flag=1;
        public int length;
        public int width;
        public int shaperotation;
        public int val,x,y;

        public enum shapes{Stick,TShape,Square,LShape,ZShape};

        private void setX(int index, int x)
        {
          co[index][0] = x;
        }

        private void setY(int index, int y)
        {
        co[index][1] = y;
      }

        public int x(int index)
        {
         return co[index][0];
       }

       public int y(int index)
        {
          return co[index][1];
        }

        public int setRandom()
        {
	         shaperotation=0;
        Random r=new Random();
        int val=Math.abs(r.nextInt())%5;
        shapes[] values=shapes.values();
        System.out.println(val);
        System.out.println(values[val]);
        return val;
    }

    public void generate_TShape(int x,int y)
    {
       length=1;
        width=2;
         shaperotation=1;
        co=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x+1,y+1}
        };
    }

    public void generate_Square(int x,int y)
    {
       length=1;
        width=1;
         shaperotation=1;
        co=new int[][]{
            {x,y},{x+1,y},{x,y+1},{x+1,y+1}
        };
    }

    public void generate_Stick(int x,int y)
    {
	     length=3;
	      shaperotation=1;
        co=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x+3,y}
        };

    }



    public void generate_ZShape(int x,int y)
    {
	     length=1;
	      width=2;
        shaperotation=1;
        co=new int[][]{
            {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
        };
    }

   public void generate_LShape(int x,int y)
    {
	length=2;
	width=1;
	shaperotation=1;
        co=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x+2,y+1}
        };
    }


    public void call_Shape(int x,int y)
    {
        if(val==0)
            generate_Stick(x,y);
        else if(val==1)
            generate_TShape(x,y);
        else if(val==2)
            generate_Square(x,y);
        else if(val==3)
            generate_LShape(x,y);
        else if(val==4)
            generate_ZShape(x,y);
    }

    public void make_Stick(int shaperotation)
    {
        if(shaperotation==1)
            generate_Stick(x,y);
        else if(shaperotation==2)
            co=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x,y+3}
        };
        else if(shaperotation==3)
            co=new int[][]{
            {x,y},{x-1,y},{x-2,y},{x,3,y}
        };
        else
            co=new int[][]{
            {x,y},{x,y-1},{x,y-2},{x,y-3}
        };

          if(shaperotation==1 || shaperotation==3)
		        {
			           length=3;width=0;
		        }
	           else {
               length=0;width=3;}
             }

             public void make_TShape(int shaperotation)
             {
               if(shaperotation==1)
               generate_TShape(x,y);
               else if(shaperotation==2)
                co=new int[][]
                {
                  {x,y},{x+1,y},{x+2,y},{x+1,y-1}
        };
        else if(shaperotation==3)
            co=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x-1,y+1}
        };
        else
            co=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x+1,y+1}
        };
        if(shaperotation==1){length=1;width=2;}
        else if(shaperotation==3){
            length=0;
            width=2;
        }
		else
    {
      length=2;width=1;
    }
    }

     public void make_LShape(int shaperotation){
        if(shaperotation==1)
            generate_LShape(x,y);
        else if(shaperotation==2)
            co=new int[][]{
            {x,y},{x,y+1},{x,y+2},{x+1,y}
        };
        else if(shaperotation==3)
            co=new int[][]{
            {x,y},{x+1,y},{x+2,y},{x,y-1}
        };
        else
            co=new int[][]{
            {x,y},{x,y-1},{x,y-2},{x-1,y}
        };
         if(shaperotation==1){ length=2;width=1; }
        else if(shaperotation==2)
        {
            length=2;
            width=2;
        }
        else if(shaperotation==4){
            length=0;
            width=1;
        }
	else{length=1;width=2;}
    }

     public void make_ZShape(int shaperotation){
        if(shaperotation==1)
            generate_ZShape(x,y);
        else if(shaperotation==2)
            co=new int[][]{
            {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
        };
        else if(shaperotation==3)
            co=new int[][]{
            {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
        };
        else
            co=new int[][]{
            {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
        };
         if(shaperotation==1){ length=1;width=2;}
    else if(shaperotation==3){
length=0;
    width=2;
    }
    else if(shaperotation==2){
        length=0;
        width=2;
    }
	else{ length=2;width=1;}
    }

    public int[][] generate_Shape()
    {
     val= setRandom();
         x=1;
        Random r=new Random();
        y=Math.abs(r.nextInt())%15+1;
        System.out.println(x+" "+y);
          if(val==0)
            generate_Stick(x,y);
        else if(val==1)
            generate_TShape(x,y);
        else if(val==2)
            generate_Square(x,y);
        else if(val==3)
            generate_LShape(x,y);
        else if(val==4)
            generate_ZShape(x,y);
        return co;
    }

	public void setxofall(int a){
	for(int i=0;i<4;i++)
	co[i][0]+=a;
	}

	public void setyofall(int a){
	for(int i=0;i<4;i++)
	co[i][1]+=a;
	}

    public int check(int x1,int y1)
    {
        for(int i=0;i<4;i++)
        {
            if(co[i][0]+x1==0 || co[i][0]+x1==19)
                return 1;
            if(co[i][1]+y1==0 || co[i][1]+y1==19)
                return 1;
        }
        return 0;
    }

    public int [][] moveleft(char screen[][]){
            int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
         int c=0;
        if(check(0,-1)==0){
            shape_flag=1;
            for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }

            setyofall(-1);
                        y=y-1;

        }
        else
          {
            shape_flag=0;
            System.out.println("Wrong move");}
            for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
                   c=1;
           }
         if(c==1)
             co=newco;
         else
             newco=co;
            return newco;
    }

    public int [][] moveright(char screen[][]){
            int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
        int c=0;
        if(check(0,1)==0){
            shape_flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }
        setyofall(1);
            y=y+1;
        }
        else
        {
            shape_flag=0;
            System.out.println("Wrong Move");}
            for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
                   c=1;
           }
         if(c==1)
             co=newco;
         else
             newco=co;
            return newco;
    }

    public int [][] movedown(char screen[][]){
         int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
        int c=0;
        if(check(1,0)==0){
            shape_flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }
        setxofall(1);
            x+=1;
        }
        else
        {
            shape_flag=0;
            System.out.println("Boundary Reached");}
            for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
                   c=1;
           }
         if(c==1)
             co=newco;
         else if(c==0)
             newco=co;
            return newco;
    }

       public int [][] moveup(char screen[][]){
         int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
        int c=0;
        if(check(-1,0)==0){
            shape_flag=1;
             for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }
        setxofall(-1);
            x-=1;
        }
        else
        {
            shape_flag=0;
            System.out.println("Boundary Reached");}
            for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
                   c=1;
           }
         if(c==1)
             co=newco;
         else if(c==0)
             newco=co;
            return newco;
    }



    public void rotate_Stick(char ch)
    {
        if(shaperotation==1)
        {
            if(ch=='r'){
            if(y+3<19 ){
            co=new int[][]{
                {x,y},{x,y+1},{x,y+2},{x,y+3}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y-3>0){
                   co=new int[][]{

                       {x,y},{x,y-1},{x,y-2},{x,y-3}
                   };
                    shaperotation=4;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }

        else   if(shaperotation==2 )
        {
            if(ch=='r'){
            if(x+3<19 ){
            co=new int[][]{
                {x,y},{x+1,y},{x+2,y},{x+3,y}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y-3>0){
                   co=new int[][]{

                       {x,y},{x,y-1},{x,y-2},{x,y-3}
                   };
                    shaperotation--;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }
        else if(shaperotation==3)
        {
            if(ch=='r')
            {
                if(y-3>0)
                {
                    co=new int[][]{
                      {x,y},{x,y-1},{x,y-2},{x,y-3}
                    };
                    shaperotation++;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y+3<19)
                {
                    co=new int[][]{
                        {x,y},{x,y+1},{x,y+2},{x,y+3}
                    };
                    shaperotation--;
                }
                 else
                System.out.println("shaperotation not possible");

            }
        }
        else if(shaperotation==4)
        {
            if(ch=='r')
            {
                if(x+3<19)
                {
                    co=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x+3,y}
                    };
                    shaperotation=1;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+3<19)
                {
                    co=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x+3,y}
                    };
                    shaperotation--;
                }
            }
        }
            if(shaperotation==1 || shaperotation==3)
		{
			length=3;width=0;
		}
	else {length=0;width=3;}
    }

	public void rotate_LShape(char ch){
	        if(shaperotation==1 )
        {
            if(ch=='r'){
            if(y+2<19 && x+1<19){
            co=new int[][]{
                {x,y},{x,y+1},{x,y+2},{x+1,y}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x-1>0    &&  y-2>0){
                   co=new int[][]{

                       {x,y},{x,y-1},{x,y-2},{x-1,y}
                   };
                    shaperotation=4;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }

        else   if(shaperotation==2 )
        {
            if(ch=='r'){
            if(x+2<19 && y-1>0){
            co=new int[][]{
                {x,y},{x+1,y},{x+2,y},{x,y-1}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+2<19 && y+1<19){
                   co=new int[][]{
                     {x,y},{x+1,y},{x+2,y},{x+2,y+1}
                   };
                    shaperotation--;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }
        //
        else if(shaperotation==3)
        {
            if(ch=='r')
            {
                if(x-1>0 && y-2>0)
                {

                    co=new int[][]{
                      {x,y},{x,y-1},{x,y-2},{x-1,y}
                    };
                    shaperotation++;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+1<19 && y+2<19)
                {
                    co=new int[][]{
                       {x,y},{x,y+1},{x,y+2},{x+1,y}
                    };
                    shaperotation--;
                }
                 else
                System.out.println("shaperotation not possible");

            }
        }
        else if(shaperotation==4)
        {
            if(ch=='r')
            {
                if(x+2<19 && y+1<19)
                {

                    co=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x+2,y+1}
                    };
                    shaperotation=1;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y-1>0 && x+2<19)
                {
                    co=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x,y-1}
                    };
                    shaperotation--;
                }
            }
        }
	if(shaperotation==1){ length=2;width=1; }
        else if(shaperotation==2)
        {
            length=2;
            width=2;
        }
        else if(shaperotation==4){
            length=0;
            width=1;
        }
	else{length=1;width=2;}
	}

public void rotate_ZShape(char ch){
      if(shaperotation==1 )
        {
            if(ch=='r'){
            if(y-1>0 && x+2<19){
            co=new int[][]{

                {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y+1<19    &&  x+2<19){
                   co=new int[][]{

                       {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
                   };
                    shaperotation=4;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }

        else   if(shaperotation==2 )
        {
            if(ch=='r'){
            if(x-1>0 && y+2<19){
            co=new int[][]{
                {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+1<19 &&  y+2<19){
                   co=new int[][]{
                        {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
                   };
                    shaperotation--;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }
        //
        else if(shaperotation==3)
        {
            if(ch=='r')
            {
                if(x+2<19 && y+1<19)
                {

                    co=new int[][]{
                      {x,y},{x+1,y},{x+1,y+1},{x+2,y+1}
                    };
                    shaperotation++;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+2<19 && y-1>0)
                {
                    co=new int[][]{
                        {x,y},{x+1,y},{x+1,y-1},{x+2,y-1}
                    };
                    shaperotation--;
                }
                 else
                System.out.println("shaperotation not possible");

            }
        }
        else if(shaperotation==4)
        {
            if(ch=='r')
            {
                if(x+1<19 && y+2<19)
                {

                    co=new int[][]{
                        {x,y},{x,y+1},{x+1,y+1},{x+1,y+2}
                    };
                    shaperotation=1;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y+2<19 && x-1>0)
                {
                    co=new int[][]{
                        {x,y},{x,y+1},{x-1,y+1},{x-1,y+2}
                    };
                    shaperotation--;
                }
            }
        }
	if(shaperotation==1){ length=1;width=2;}
    else if(shaperotation==3){
length=0;
    width=2;
    }
    else if(shaperotation==2){
        length=0;
        width=2;
    }
	else{ length=2;width=1;}
}
    public void rotate_TShape(char ch)
    {
         if(shaperotation==1 )
        {
            if(ch=='r'){
            if(y-1>0 && x+2<19){
            co=new int[][]{

                {x,y},{x+1,y},{x+2,y},{x+1,y-1}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y+1<19    &&  x+2<19){
                   co=new int[][]{

                       {x,y},{x+1,y},{x+2,y},{x+1,y+1}
                   };
                    shaperotation=4;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }

        else   if(shaperotation==2 )
        {
            if(ch=='r'){
            if(x-1>0 && y+2<19){
            co=new int[][]{
                {x,y},{x,y+1},{x,y+2},{x-1,y+1}
            };
                shaperotation++;
            }
            else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+1<19 &&  y+2<19){
                   co=new int[][]{
                        {x,y},{x,y+1},{x,y+2},{x+1,y+1}
                   };
                    shaperotation--;
                }
                else
                System.out.println("shaperotation not possible");
            }
        }
        //
        else if(shaperotation==3)
        {
            if(ch=='r')
            {
                if(x+2<19 && y+1<19)
                {

                    co=new int[][]{
                      {x,y},{x+1,y},{x+2,y},{x+1,y+1}
                    };
                    shaperotation++;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(x+2<19 && y-1>0)
                {
                    co=new int[][]{
                        {x,y},{x+1,y},{x+2,y},{x+1,y-1}
                    };
                    shaperotation--;
                }
                 else
                System.out.println("shaperotation not possible");

            }
        }
        else if(shaperotation==4)
        {
            if(ch=='r')
            {
                if(x+1<19 && y+2<19)
                {

                    co=new int[][]{
                        {x,y},{x,y+1},{x,y+2},{x+1,y+1}
                    };
                    shaperotation=1;
                }
                 else
                System.out.println("shaperotation not possible");
            }
            else
            {
                if(y+2<19 && x-1>0)
                {
                    co=new int[][]{
                        {x,y},{x,y+1},{x,y+2},{x-1,y+1}
                    };
                    shaperotation--;
                }
            }
        }
            if(shaperotation==1){length=1;width=2;}
        else if(shaperotation==3){
            length=0;
            width=2;
        }
		else {length=2;width=1;}
    }
    public int[][] rotateleft(char [][]screen){
        int previousshaperotation=shaperotation;
        if (val==2)
        {
            shaperotation++;
            shape_flag=0;
            return co;
        }
       else
       {
             int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
         int c=0;
           for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }
            if(val==0)
                rotate_Stick('l');
           else if(val==1)
               rotate_TShape('l');
           else if(val==3)
               rotate_LShape('l');
           else if(val==4)
               rotate_ZShape('l');
              for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
                   c=1;
           }
         if(c==1)
             co=newco;
         else
             newco=co;

       if(previousshaperotation==shaperotation)
           shape_flag=0;
           else
               shape_flag=1;
        return newco;
        }

    }

    public int[][] rotateright(char [][]screen){
        int previousshaperotation=shaperotation;
        if (val==2)
        {
            shaperotation++;
            shape_flag=0;
           return co;
        }
     else
       {

           int newco[][]=new int[4][2];
        for(int i=0;i<4;i++)
        {
            newco[i][0]=co[i][0];
            newco[i][1]=co[i][1];
        }
         int c=0;
        for(int i=0;i<4;i++)
            {
                    screen[co[i][0]][co[i][1]]=' ';
            }
            if(val==0)
                rotate_Stick('r');
           else if(val==1)
               rotate_TShape('r');
           else if(val==3)
               rotate_LShape('r');
           else if(val==4)
               rotate_ZShape('r');
           for(int i=0;i<4;i++)
           {
               if(screen[co[i][0]][co[i][1]]=='#')
               { c=1;
                break;
               }
           }
         if(c==1)
             co=newco;
         else
             newco=co;
         if(previousshaperotation==shaperotation)
             shape_flag=0;
         else
             shape_flag=1;
         return newco;
        }

    }

}
