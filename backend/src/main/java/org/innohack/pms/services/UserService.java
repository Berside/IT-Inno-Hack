package org.innohack.pms.services;

import io.micrometer.common.util.StringUtils;
import org.innohack.pms.exceptions.NotFoundException;
import org.innohack.pms.models.OrgModel;
import org.innohack.pms.models.UserModel;
import org.innohack.pms.repositories.OrgRepo;
import org.innohack.pms.repositories.UserRepo;
import org.innohack.pms.schemas.user.GetUserSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    private final UserRepo userRepo;
    private final OrgRepo orgRepo;

    @Autowired
    public UserService(UserRepo userRepository, OrgRepo orgRepository) {
        this.userRepo = userRepository;
        this.orgRepo = orgRepository;
    }

    public void addUser(UserModel user){
        userRepo.save(user);
    }

    public UserModel getUserById(Long user_id){
        return userRepo.findById(user_id).orElseThrow(() -> new NotFoundException(user_id, "User"));
    }

    public List<UserModel> getUsers(GetUserSchema userData){
        Specification<UserModel> spec = Specification.where(null);

        if (userData.firstName != null){
            spec = spec.and(((root, query, cb) -> cb.equal(root.get("firstName"), userData.firstName)));
        }

        if (userData.lastName != null){
            spec = spec.and(((root, query, cb) -> cb.equal(root.get("lastName"), userData.lastName)));
        }

        if (userData.email != null){
            spec = spec.and(((root, query, cb) -> cb.like(root.get("email"), '%' + userData.email + '%')));
        }

        if (userData.userRole != null){
            spec = spec.and(((root, query, cb) -> cb.equal(root.get("role"), userData.userRole)));
        }

        return this.userRepo.findAll(spec);
    }

    public List<UserModel> getAll(){
        return this.userRepo.findAll();
    }

    public void deleteById(Long user_id){
        this.userRepo.deleteById(user_id);
    }

    public List<OrgModel> getUserOrgs(Long user_id){
        return this.orgRepo.findAllByUserId(user_id);
    }

}
