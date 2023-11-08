package lexicon.se.g46todoapi.controller;

import lexicon.se.g46todoapi.domain.UserDTOForm;
import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.dto.UserDTOView;
import lexicon.se.g46todoapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {
    private UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping("/")
    public ResponseEntity<UserDTOView> getUserByEmail(@RequestParam String email){
        System.out.println("getUserEmail");
        System.out.println("Email:" + email);
                        UserDTOView responseBody= userService.getByEmail(email);

/*
    //    Set<RoleDToView> roleDToViews = new HashSet<>();
        roleDToViews.add(new RoleDToView(1L,"ADMIN"));

        UserDTOView responseBody = new UserDTOView.builder().email("test.test@test.com").role(roleDToViews).build();*/
//

            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    @PostMapping
    public ResponseEntity<UserDTOView> doRegister(@RequestBody UserDTOForm userDTOForm){
        System.out.println("DTO from:" + userDTOForm);

       UserDTOForm responseBody = UserService.register(userDTOForm);
       return responseBody.status(HttpStatus.CREATED).body(responseBody);

    }
    @PutMapping
    public ResponseEntity<Void> doDisableUserByEmail(@RequestParam("email") String email){
    userService.disableByEmail(email);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
