package org.innohack.pms.schemas.user;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.innohack.pms.types.enums.UserRole;
import org.springframework.lang.Nullable;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class GetUserSchema {

    @Nullable
    public String firstName;

    @Nullable
    public String lastName;

    @Email
    @Nullable
    public String email;

    @Nullable
    public UserRole userRole;
}
