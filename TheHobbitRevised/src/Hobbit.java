
public class Hobbit extends Traveler
{
	  
	//Hobbits travel just like any other Traveler. Do they need a travel method?  
	//  Try it without and find out.  =]  
	
	//fields
	private boolean ringObsessed;
	
	//Call Traveler's constructor (look it up p587) to set the name field and then 
	//   set the value of ringobssessed to false.
	public Hobbit(String name)
	{
		super(name);
		ringObsessed = false;
	}	
}
