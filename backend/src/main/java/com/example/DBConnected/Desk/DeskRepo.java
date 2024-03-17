package com.example.DBConnected.Desk;

import com.example.DBConnected.Desk.Desk;
import org.springframework.data.repository.CrudRepository;

public interface DeskRepo extends CrudRepository <Desk, Integer> {
}
