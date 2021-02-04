package org.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.team.domain.LogEvent;

@Repository
public interface LogEventRepository extends JpaRepository<LogEvent, Long> {
}
