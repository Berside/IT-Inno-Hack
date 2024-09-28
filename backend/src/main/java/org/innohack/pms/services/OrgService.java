package org.innohack.pms.services;

import org.innohack.pms.exceptions.NotFoundException;
import org.innohack.pms.models.OrgMembersModel;
import org.innohack.pms.models.OrgModel;
import org.innohack.pms.models.UserModel;
import org.innohack.pms.repositories.OrgMembersRepo;
import org.innohack.pms.repositories.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrgService {
    private final OrgRepo orgRepo;
    private final OrgMembersRepo orgMembersRepo;

    @Autowired
    public OrgService(OrgRepo orgRepo, OrgMembersRepo orgMembersRepo) {
        this.orgRepo = orgRepo;
        this.orgMembersRepo = orgMembersRepo;
    }

    public void addOrganization(OrgModel org){
        orgRepo.save(org);
    }

    public OrgModel getOrgById(Long org_id){
        return orgRepo.findById(org_id).orElseThrow(() -> new NotFoundException(org_id, "Organization"));
    }

    public void addMember(OrgMembersModel orgMember){
        orgMembersRepo.save(orgMember);
    }

    public List<OrgMembersModel> getMembers(Long org_id){
        return orgMembersRepo.findAllByOrgId(org_id);
    }
}
