package Assignment;

//chef class
public class Chef extends Thread
{
    //restaurant object
    private Restaurant restaurant;

    //constructor for the chef class
    public Chef(Restaurant restaurant)
    {
        //initializing the restaurant object
        this.restaurant = restaurant;
    }

    //run method for the chef class
    public void run()
    {
        //while there are dishes in the list of dishes, the chef prepares the dish
        while (restaurant.hasDishes())
        {
            //the chef prepares the dish
            Dish dish = restaurant.serveDish();
            //if the dish is not null, the chef prepares the dish
            if (dish != null)
            {
                try
                {
                    //the chef prepares the dish for 8 seconds
                    Thread.sleep(8000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                
                //the dish is ready
                dish.setReady(true);
                //the chef notifies the waiter that the dish is ready
                System.out.println("Chef has prepared the dish: " + dish.getDish());

                //notifies the thread waiting on this object ie the waiter
                synchronized (restaurant)
                {
                    restaurant.notify();
                }
                
            }
        }
    }
}
