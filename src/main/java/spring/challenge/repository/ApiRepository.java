package spring.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.challenge.entity.Domain;

public interface ApiRepository extends JpaRepository<Domain, Long> {
}
