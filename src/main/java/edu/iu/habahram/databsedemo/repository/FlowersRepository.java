package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.Flower;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowersRepository
        extends CrudRepository<Flower, Integer> {

    List<Flower> findAllByOrderByCostAsc(); // Sorted low to high by price

    List<Flower> findAllByOrderByCostDesc(); // Sorted high to low by price
}
