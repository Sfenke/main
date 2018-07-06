
package javaapp1;


public class Segment {
    private double  beginX;
    private double  beginY;
    private double  beginZ;
    private double  endX;
    private double  endY;
    private double  endZ;
        
    public Segment(){}

    public Segment(double beginX, double beginY, double beginZ, double endX, double endY, double endZ) {
        this.beginX = beginX;
        this.beginY = beginY;
        this.beginZ = beginZ;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
    }
    public void setSegment (double beginX, double beginY, double beginZ, double endX, double endY, double endZ){
        this.beginX = beginX;
        this.beginY = beginY;
        this.beginZ = beginZ;
        this.endX = endX;
        this.endY = endY;
        this.endZ = endZ;
    }

    public void setBeginX(double beginX) {
        this.beginX = beginX;
    }

    public void setBeginY(double beginY) {
        this.beginY = beginY;
    }

    public void setBeginZ(double beginZ) {
        this.beginZ = beginZ;
    }

    public void setEndX(double endX) {
        this.endX = endX;
    }

    public void setEndY(double endY) {
        this.endY = endY;
    }

    public void setEndZ(double endZ) {
        this.endZ = endZ;
    }
        
    public double getBeginX() {
        return beginX;
    }

    public double getBeginY() {
        return beginY;
    }

    public double getBeginZ() {
        return beginZ;
    }

    public double getEndX() {
        return endX;
    }

    public double getEndY() {
        return endY;
    }

    public double getEndZ() {
        return endZ;
    }
    
    @Override
    public String toString() {
        return "Отрезок имеет координаты:{" + "Начало " + beginX + ", " + beginY + ", " + beginZ + " Конец " + endX + ", " + endY + ", " + endZ + '}';
    }
   
    public double length(){
        return  Math.sqrt((this.endX-this.beginX)*(this.endX-this.beginX)+
                (this.endY-this.beginY)*(this.endY-this.beginY)+
                    (this.endZ-this.beginZ)*(this.endZ-this.beginZ));
    }
    public double lengthAll(double beginX, double beginY, double beginZ, double endX, double endY, double endZ){
        return Math.sqrt((endX-beginX)*(endX-beginX)+
                (endY-beginY)*(endY-beginY)+
                    (endZ-beginZ)*(endZ-beginZ));
    }
    public double  fromPointToSegment (double xPoint,double yPoint,double zPoint){
                
                double a=length();
                double b=lengthAll(this.endX, this.endY, this.endZ, xPoint, yPoint, zPoint);
                double c=lengthAll(this.beginX,this.beginY,this.beginZ,xPoint, yPoint, zPoint);
                double p=(a+b+c)/2;
                double h=2*(Math.sqrt(p*(p-a)*(p-b)*(p-c))/a);
                if(h==0){
                     if (c>b) {return c-b;} 
                        else {return b-c;}}
                else if((a*a + b*b )< c*c){
                        if (c>b) {return b;} 
                        else {return c;}
                        }else
                return h;
     
    }
                
    
}
    
    
    
    

