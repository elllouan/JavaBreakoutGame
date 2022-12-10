package MaterialEntities;

public class Car extends Engine
{
	public Car(int x, int y, int speed, char state)
	{
		this.x = x; 
		this.y = y;
		this.speed = speed;
		this.state = state;
		this.slow_down = false;
	}

	public void set_state(char s)
	{
		this.state=s;
	}

	public int moveForward()
	{
		this.x += this.x*speed;
		return this.x;
	}
	public int moveBackward()
	{
		this.x -= this.x*speed;
		return this.x;
	}
	public int moveUpward()
	{
		this.y += this.y*speed;
		return this.y;
	}
	public int moveDownward()
	{
		this.y -= this.y*speed;
		return this.y;
	}
	public int brake()
	{
		this.speed = 0;
		return this.speed;
	}
	public void speed_decrease()
	{
		if (this.slow_down) {
			this.speed -= 0.5;
		}
	}
	
	public int nextPosition()
	{
		switch (this.state) {
			case 'd' : return this.moveDownward();
			case 'u' : return this.moveUpward();
			case 'l' : return this.moveBackward();
			case 'r' : return this.moveForward();
			case 'b' : return this.brake();
		}
		return 1;
	}
	public boolean crash(Engine e)
	{
		if (this.nextPosition() == e.nextPosition())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void drive()
	{

	}

	// attributs
	private boolean slow_down;
}
