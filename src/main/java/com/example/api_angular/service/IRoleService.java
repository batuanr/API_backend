package com.example.api_angular.service;



import com.example.api_angular.model.Role;
import com.example.api_angular.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
