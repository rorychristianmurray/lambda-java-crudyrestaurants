package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.model.Menu;
import com.lambdaschool.crudyrestaurants.model.Restaurant;
import com.lambdaschool.crudyrestaurants.repos.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findAll()
    {
        List<Restaurant> list = new ArrayList<>();

        // list::add is a shortcut to add to arraylist
        restrepos.findAll().iterator().forEachRemaining(list::add);

        // normal arraylist
        return list;
    }

    @Override
    public Restaurant findRestaurantById(long id)
    {
        return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Restaurant findRestaurantByName(String name)
    {
        Restaurant restaurant = restrepos.findByName(name);

        if (restaurant == null)
        {
            throw new EntityNotFoundException("Restaurant " + name + " not found!");
        }

        return restaurant;
    }

    @Override
    public void delete(long id)
    {
        if (restrepos.findById(id).isPresent())
        {
            restrepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());

       // wrong - saves pointer to memory location newRestaurant.setMenus(restaurant.getMenus());

        for (Menu m : restaurant.getMenus())
        {
            newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
        }
        return restrepos.save(newRestaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, long id)
    {
        return null;
    }
}
