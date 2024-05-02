package edu.iu.habahram.databsedemo.repository;

import edu.iu.habahram.databsedemo.model.Customer;
import edu.iu.habahram.databsedemo.model.Recipient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends CrudRepository<Recipient, Integer> {

    Recipient findById(int id);

}
