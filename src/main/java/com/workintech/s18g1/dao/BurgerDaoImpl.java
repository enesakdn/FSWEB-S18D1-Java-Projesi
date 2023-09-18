package com.workintech.s18g1.dao;

import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public class BurgerDaoImpl implements BurgerDao{

private EntityManager entitymanager;

@Autowired
public BurgerDaoImpl(EntityManager entitymanager) {
    this.entitymanager = entitymanager;
}
    @Override
    @Transactional
    public Burger save(Burger burger) {
      entitymanager.persist(burger);
      return burger;
    }

    @Override
    public Burger findById(int id) {
       return  entitymanager.find(Burger.class,id);
    };

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query =entitymanager.createQuery("SELECT b FROM Burger b",Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(int price) {
        TypedQuery<Burger> query = entitymanager.createQuery("SELECT b FROM Burger b WHERE b.price >= :price ORDER BY b.price DESC", Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entitymanager.createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.breadType", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entitymanager.createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%', :content, '%')", Burger.class);
        query.setParameter("content", content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entitymanager.merge(burger);
    }
    @Transactional
    @Override
    public Burger delete(int id) {
        Burger burger = findById(id);
        entitymanager.remove(burger);
        return burger;
    }
}
