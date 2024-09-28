package org.innohack.pms.controllers;

import org.innohack.pms.models.OrgModel;
import org.innohack.pms.models.UserModel;
import org.innohack.pms.schemas.user.GetUserSchema;
import org.innohack.pms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:6702")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/get")
    public List<UserModel> getUsers(GetUserSchema userData){
        return userService.getUsers(userData);
    }

    @GetMapping("/getAll")
    public List<UserModel> getAllUsers(){
        return userService.getAll();
    }

    @DeleteMapping("/{id}/delete")
    public void deleteUser(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/{id}/orgs_own")
    public List<OrgModel> getAllOwnedOrgs(@PathVariable Long id){
        return userService.getUserOrgs(id);
    }

}
