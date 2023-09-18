package com.workintech.s18g1.dao;

import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface BurgerDao {
    Burger  save(Burger burger);
    Burger findById(int id);
    List<Burger> findAll();
    List<Burger> findByPrice(int price);
    List<Burger> findByBreadType (BreadType breadType);
    List<Burger> findByContent (String content);
    Burger  update(Burger burger);
    Burger delete(int id);
}
