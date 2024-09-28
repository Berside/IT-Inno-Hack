package org.innohack.pms.repositories;

import org.innohack.pms.models.OrgModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrgRepo extends JpaRepository<OrgModel, Long> {
    @Query(value = "SELECT * FROM orgs where owner_id = ?1", nativeQuery = true)
    List<OrgModel> findAllByUserId(Long user_id);
}
