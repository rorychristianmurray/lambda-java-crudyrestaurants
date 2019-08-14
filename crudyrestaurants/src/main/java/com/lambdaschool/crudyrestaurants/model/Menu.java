package com.lambdaschool.crudyrestaurants.model;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.Auto)
    private long menuid;

    @Column(nullable = false)
    private String dish;
    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurauntid",
                nullable = false)
    private Restaurant restaurant;

    public Menu()
    {
    }

    public Menu(String dish, double price, Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public long getMenuid()
    {
        return menuid;
    }

    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}
