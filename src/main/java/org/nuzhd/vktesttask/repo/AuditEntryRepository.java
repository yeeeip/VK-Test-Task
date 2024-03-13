package org.nuzhd.vktesttask.repo;

import org.nuzhd.vktesttask.entity.AuditEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditEntryRepository extends JpaRepository<AuditEntry, Long> {
}
