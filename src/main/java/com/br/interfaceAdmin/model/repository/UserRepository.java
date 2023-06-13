package com.br.interfaceAdmin.model.repository;

import com.br.interfaceAdmin.model.entity.User;
import com.br.interfaceAdmin.model.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email, String password);

    List<UserProjection> findAllProjectedBy();
}
