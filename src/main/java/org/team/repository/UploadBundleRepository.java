package org.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.team.domain.UploadBundle;

@Repository
public interface UploadBundleRepository extends JpaRepository<UploadBundle, Long> {
}
