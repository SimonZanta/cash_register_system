package com.example.DBConnected.Authorization;

import com.example.DBConnected.Authorization.Authorization;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizationRepo extends CrudRepository<Authorization, Integer> {
}
