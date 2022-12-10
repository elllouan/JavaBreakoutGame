package LivelyEntities;

public class Human extends Animal
{
	public Human(String name, int age)
	{
		this.name=name;
		this.age=age;
		nbHumans+=1;
	}

	public String getName()
	{
		return this.name;
	}

	public static int get_nb()
	{
		return nbHumans;
	}

	// Abstract Specifications
	public void eat()
	{
		System.out.println("Miam");
	}

	public void move(int m){}

	private static int nbHumans=0;
	private String name;
	private int age;
	private Animal animal;
}

