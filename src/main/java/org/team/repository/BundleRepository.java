package org.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.team.domain.Bundle;

@Repository
public interface BundleRepository extends JpaRepository<Bundle, Long> {
}
