package MaterialEntities;

import java.awt.event.KeyEvent;

abstract public class Engine 
{
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public void setX(int x){this.x = x;}
	public void setY(int y){this.y = y;}
	public int getSpeed(){return this.speed;}
	public void setSpeed(int s){this.speed = s;}

	abstract public int moveForward();
	abstract public int moveBackward();
	abstract public int moveUpward();
	abstract public int moveDownward();
	abstract public int nextPosition();
	abstract public int brake();
	abstract public boolean crash(Engine e);

	protected int x,y,speed;
	protected char state;
}