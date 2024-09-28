package org.innohack.pms.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.innohack.pms.types.enums.OrgRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.Date;

@Entity
@Data
@Table(name = "org_members")
public class OrgMembersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    public UserModel user;

    @ManyToOne
    public OrgModel org;

    @Enumerated(EnumType.STRING)
    private OrgRole org_role = OrgRole.MEMBER;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private Date updatedDate;

    public OrgMembersModel(UserModel user, OrgModel org, OrgRole orgRole){
        this.user = user;
        this.org = org;
        this.org_role = orgRole;
    }

    public OrgMembersModel(){

    }
}
