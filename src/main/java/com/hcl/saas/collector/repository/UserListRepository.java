package com.hcl.saas.collector.repository;

import com.hcl.saas.collector.model.UserList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserListRepository extends CrudRepository<UserList, String> {

    Optional<UserList> findById(String id);

}
