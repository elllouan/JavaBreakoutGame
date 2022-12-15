package GeometricShapes; 

public class Rectangle extends Item
{
    public Rectangle(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        System.out.println("Rect created.");
    }

    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getWidth() { return this.width; }
    public int getHeight() { return this.height; }

    private int width, height;
    private int x,y;
    
}