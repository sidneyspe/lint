package com.sidneyspe.repository;

import com.sidneyspe.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TokenRepository extends JpaRepository<Token, Long> {
    List<Token> findByHash(String hash);
}
