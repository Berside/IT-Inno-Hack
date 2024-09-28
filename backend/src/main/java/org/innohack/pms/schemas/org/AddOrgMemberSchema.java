package org.innohack.pms.schemas.org;

import lombok.Getter;
import lombok.Setter;
import org.innohack.pms.types.enums.OrgRole;

@Getter
@Setter
public class AddOrgMemberSchema {
    public Long user_id;
    public Long org_id;
    public OrgRole orgRole = OrgRole.MEMBER;
}
