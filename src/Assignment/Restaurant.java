package Assignment;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

//restaurant class
public class Restaurant 
{
    //list of dishes
    private List<Dish> dishes;

    public Restaurant()
    {
        //creating the list of dishes
        dishes = new ArrayList<Dish>();
    }

    //method to add a dish to the list of dishes using synchronization
    //to prevent the waiter and chef from accessing the list at the same time
    public synchronized void addDish(Dish dish)
    {
        //the dish is added to the list of dishes
        dishes.add(dish);
        System.out.println("Waiter bringing table " + dish.getTableNumber() + "'s order to the chef.");
        System.out.println("Chef preparing chosen dish: " + dish.getDish());
        
        //notifies both threads waiting on this object
        notifyAll();
    }

    //method to serve a dish from the list of dishes using synchronization allowing only one thread to access the list at a time
    public synchronized Dish serveDish()
    {
        //if the list of dishes is empty, the method returns null
        if(dishes.isEmpty())
        {
            return null;
        }

        //the dish is removed from the list of dishes
        Dish dish = dishes.remove(0);
        System.out.println("Waiter serving chosen dish " + dish.getDish() + " to table number " + dish.getTableNumber());
        
        //the dish is returned
        return dish;
    }

    //method to check if a dish is ready using synchronization
    //to prevent the waiter and chef from accessing the list at the same time
    public synchronized boolean isDishReady()
    {
        return !dishes.isEmpty();
    }

    //method to check if there are dishes in the list using synchronization
    public synchronized boolean hasDishes()
    {
        return !dishes.isEmpty();
    }

    //main method to run the program
    public static void main(String[] args)
    {
        //creating a scanner object to take in user input
        Scanner scan = new Scanner(System.in);
        //creating a restaurant object, waiter object, and chef object
        Restaurant restaurant = new Restaurant();
        Waiter waiter = new Waiter(restaurant);
        Chef chef = new Chef(restaurant);
        String item;
        int tableNumber;

        //starting the threads
        waiter.start();
        chef.start();

        while(true)
        {
            System.out.println("Enter table number: ");
            tableNumber = scan.nextInt();
            System.out.println("Enter dish: ");
            item = scan.next();
            Dish dish = new Dish(tableNumber, item);
            restaurant.addDish(dish);
        }

    }
}


