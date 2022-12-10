package LivelyEntities;

abstract public class Animal // No Constructor
{
	public String getBirth()
	{
		return this.birth;
	}

	// These need to be implemented in other classes
	abstract public void eat();
	abstract public void move(int m);

	protected String birth;
}
