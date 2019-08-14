package com.lambdaschool.crudyrestaurants.repos;

import com.lambdaschool.crudyrestaurants.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRespository extends CrudRepository<Restaurant, Long>
{
}
