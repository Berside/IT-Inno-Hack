package org.innohack.pms.schemas.org;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrgSchema{
    public String name;
    public Long owner_id;
}
