package org.innohack.pms.controllers;

import org.innohack.pms.models.OrgMembersModel;
import org.innohack.pms.models.OrgModel;
import org.innohack.pms.models.UserModel;
import org.innohack.pms.schemas.org.AddOrgMemberSchema;
import org.innohack.pms.schemas.org.CreateOrgSchema;
import org.innohack.pms.services.OrgService;
import org.innohack.pms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/org")
public class OrgController {
    private final OrgService orgService;
    private final UserService userService;

    @Autowired
    public OrgController(OrgService orgService, UserService userService) {
        this.orgService = orgService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public OrgModel getOrgById(@PathVariable Long id){
        return orgService.getOrgById(id);
    }

    @PostMapping("/add")
    public String addOrg(@RequestBody CreateOrgSchema org){
        UserModel user = userService.getUserById(org.owner_id);
        OrgModel orgModel = new OrgModel(user, org.name);
        orgService.addOrganization(orgModel);
        return "Success";
    }

    @PostMapping("/addOrgMember")
    public String addOrgMember(@RequestBody AddOrgMemberSchema _org){
        UserModel user = userService.getUserById(_org.user_id);
        OrgModel org = orgService.getOrgById(_org.org_id);
        OrgMembersModel orgMemberModel = new OrgMembersModel(user, org, _org.orgRole);
        orgService.addMember(orgMemberModel);
        return "Success";
    }

    @GetMapping("/{id}/getMembers")
    public List<OrgMembersModel> getMembers(@PathVariable Long id){
        return orgService.getMembers(id);
    }
}
