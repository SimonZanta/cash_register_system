package com.example.DBConnected.Desk;

import com.example.DBConnected.Desk.Desk;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeskRepo extends CrudRepository <Desk, Integer> {
}
