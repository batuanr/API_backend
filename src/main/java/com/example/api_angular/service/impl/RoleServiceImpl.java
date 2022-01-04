package com.example.api_angular.service.impl;


import com.example.api_angular.model.Role;
import com.example.api_angular.model.RoleName;
import com.example.api_angular.repository.IRoleRepository;
import com.example.api_angular.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
