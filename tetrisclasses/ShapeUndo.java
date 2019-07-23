package tetrisclasses;

interface stack{
    public void push(int val,int r,int x1,int y1);
    public void pop();
    public Link peek();
    public boolean isEmpty();
}

class Link{
    public int shape,x,y;
    public int shaperotation;
    public Link next;
    public Link(int d,int r,int x1,int y1){
        x=x1;
        y=y1;
        shaperotation=r;
        shape=d;
        next=null;
    }
}

public class ShapeUndo implements stack
{
    public Link top1;
    public ShapeUndo(){
    top1=null;
    }

    public void display(){
    System.out.println(top1.shape);
    }

     public boolean isEmpty()
    {
        return top1 == null;
    }

    public void push(int val,int r,int x1,int y1){
        Link link=new Link(val,r,x1,y1);
        link.next=top1;
        top1=link;
    }

    public void pop(){
    top1=top1.next;
    }

    public Link peek(){
    if(!isEmpty())
    return top1;

    return null;
    }

    public int getshape(){
    return top1.shape;
    }

    public int getshaperotation(){
    return top1.shaperotation;
    }

    public int getx(){
    return top1.x;
    }

    public int gety(){
    return top1.y;
    }
}
