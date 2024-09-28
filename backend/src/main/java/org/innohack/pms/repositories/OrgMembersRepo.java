package org.innohack.pms.repositories;

import org.innohack.pms.models.OrgMembersModel;
import org.innohack.pms.models.OrgModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface OrgMembersRepo extends JpaRepository<OrgMembersModel, Long> {
    @Query(value = "SELECT * FROM org_members where org_id = ?1", nativeQuery = true)
    List<OrgMembersModel> findAllByOrgId(Long org_id);
}
