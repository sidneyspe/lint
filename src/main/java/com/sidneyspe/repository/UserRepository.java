package com.sidneyspe.repository;

import com.sidneyspe.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
