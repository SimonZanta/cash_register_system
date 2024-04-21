package com.example.DBConnected.Menu;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepo extends CrudRepository<Menu, Integer> {

}
