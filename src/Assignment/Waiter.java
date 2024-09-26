package Assignment;

public class Waiter extends Thread
{
   //restaurant object
   private Restaurant restaurant;
   
    //constructor for the waiter class
    public Waiter(Restaurant restaurant)
    {
        //initializing the restaurant object
        this.restaurant = restaurant;
     
    }

    //run method for the waiter class
    public void run()
    {
        while(true)
        {
            //if the dish is ready, the waiter serves the dish
            if(restaurant.isDishReady())
            {
                Dish dish = restaurant.serveDish();
                
            }
            else
            {
                //if the dish is not ready, the waiter waits
                //for the chef to prepare the dish
                //using synchronization to prevent the waiter from accessing the dish if the chef hasn't finished 
                //preparing the dish
                synchronized(restaurant)
                {
                    try
                    {
                        restaurant.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
