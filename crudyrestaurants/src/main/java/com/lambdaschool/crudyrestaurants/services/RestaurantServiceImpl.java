package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.model.Restaurant;
import com.lambdaschool.crudyrestaurants.repos.RestaurantRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired
    private RestaurantRespository restrepos;

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
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Override
    public Restaurant save(Restaurant restaurant)
    {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant, long id)
    {
        return null;
    }
}
