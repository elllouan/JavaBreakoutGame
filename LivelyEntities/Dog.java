package LivelyEntities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Dog extends Animal 
{
	public Dog(String birth, int[] position)
	{
		this.birth=birth;
		this.location=position;
	}

	// Accessors
	public Human getOwner()
	{
		return this.owner;
	}

	public int[] getLocation()
	{
		return this.location;
	}

	// Public Methods
	public void tame(Human h) //throws Exception
	{
		try
		{
			BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Which name do you " + h.getName() + " choose for your new Dog ?");
			this.name = bfr.readLine();
		}
		catch(IOException e)
		{
			System.out.println("PB!");
		}
		
		this.owner=h;
		System.out.println(h.getName() + " has tamed this Animal and gave it the following name : " + this.name);
	}

	// Abstract Specifications
	public void eat()
	{
		System.out.println("Ouaf");
	}

	public void move(int m)
	{
		if (m==0) {
			this.run();
		}
		if (m==1) {
			this.jmp();
		}
	}

	// Private Methods
	private void jmp()
	{
		this.location[1]+=1;
	}

	private void run()
	{
		this.location[0]+=1;
	}

	private Human owner;
	private String name, race;
	private int[] location = new int[2];
}