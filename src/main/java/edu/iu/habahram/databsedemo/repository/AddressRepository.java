package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
}
