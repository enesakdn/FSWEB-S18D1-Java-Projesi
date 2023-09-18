package com.workintech.s18g1.controller;

import com.workintech.s18g1.dao.BurgerDao;
import com.workintech.s18g1.entity.BreadType;
import com.workintech.s18g1.entity.Burger;
import jakarta.persistence.GeneratedValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerdao;
@Autowired
    public BurgerController(BurgerDao burgerdao) {
        this.burgerdao = burgerdao;
    }
    @GetMapping("/")
    public List<Burger> getAll() {
       return burgerdao.findAll();
    }
    @GetMapping("/{id}")
    public Burger  getById(@PathVariable int id) {
       return  burgerdao.findById(id);
    }
    @PostMapping("/")
    public Burger save(@RequestBody Burger burger) {
        return burgerdao.save(burger);
    }
    @PutMapping("/")
    public Burger update(@RequestBody Burger burger) {
        return burgerdao.update(burger);
    }
    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id) {
        Burger burger = burgerdao.findById(id);
        burgerdao.delete(id);
        return burger;
    }
    @GetMapping("/findByP/{price}")
    public List<Burger> findByP(@PathVariable int price) {
        return burgerdao.findByPrice(price);
    }
    @GetMapping("/findByB/{breadType}")
    public List<Burger> findByB(@PathVariable BreadType breadType) {
        return burgerdao.findByBreadType(breadType);
    }
    @GetMapping("/findByC/{content}")
    public List<Burger> findByC(@PathVariable String content) {
        return burgerdao.findByContent(content);
    }
}
