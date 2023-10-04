package br.com.digitalhouse.games.domain.repository;

import br.com.digitalhouse.games.domain.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDetail, UUID> {
    Optional<UserDetail> findByEmail(String name);
}
