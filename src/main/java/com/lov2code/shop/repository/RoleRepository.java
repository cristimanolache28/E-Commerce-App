package com.lov2code.shop.repository;

import com.lov2code.shop.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepository extends CrudRepository<Role, Integer> {

}
