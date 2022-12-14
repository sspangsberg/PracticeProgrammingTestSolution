/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pgn
 */
public class CarDealerShip
{
    private List<Car> carsForSale = new ArrayList<>();
    
    /**
     * Adds another car for sale but only if the value is not null, and only if
     * the car has a price greater than zero.
     *
     * @param car The car to add to list of cars for sale.
     */
    public void addCarForSale(Car car)
    {
        if (car != null && car.getPrice() > 0)
            carsForSale.add(car);
    }
    
    /**
     * Gets the total value of all cars for sale.
     * @return the total value of all cars for sale.
     */
    public double getTotalCarValues()
    {
        double total = 0;

        for (Car c: carsForSale) {
            total = total + c.getPrice();
        }
        return total;
    }
    
    /**
     * Gets the cheapest car from the list ov cars for sale.
     * @return the cheapest car from the list ov cars for sale.
     */
    public Car getCheapestCar()
    {
        Car cheapest = null;

        if (carsForSale.size() > 0) {
            cheapest = carsForSale.get(0);
            for (int i = 1; i < carsForSale.size(); i++) {
                if (carsForSale.get(i).getPrice() < cheapest.getPrice())
                    cheapest = carsForSale.get(i);
            }
        }
        return cheapest;
    }
    
    /**
     * Sells the car in the parameter.
     * @param car The car to be sold.
     */
    public void sellCar(Car car)
    {
        carsForSale.remove(car);
    }

    /**
     * Nothing to do here
     * @return 
     */
    public List<Car> getCarsForSale()
    {
        return carsForSale;
    }
        
    /**
    * Sort the list of cars for sale in order from cheapest to most expensive
    */    
    public void sortCarsByPrice() {

        Comparator comp = Comparator.comparingDouble(Car::getPrice);

        carsForSale.sort(comp);
    }
    
    /**
    * Sort the list of cars for sale in order from slowest to fastest.
    */    
    public void sortCarsByMaxSpeed()
    {
        carsForSale.sort(Comparator.comparingInt(Car::getMaxKilometersPerHour));
    }
    
    /**
     * Get a random car for sale.
     * @return a randomly selected car for sale.
     */
    public Car presentRandomCarToCustomer()
    {
        // Create object
        Random rnd = new Random();

        // Get random number (between 0 and size of carsForSale - 1)
        int randomNumber = rnd.nextInt(carsForSale.size());

        // Return "random" Car based on index
        return carsForSale.get(randomNumber);
    }
}