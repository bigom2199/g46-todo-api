package lexicon.se.g46todoapi.controller;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    private final RoleService roleService;
   @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public ResponseEntity<List<RoleDToView>> doGetRoles(){
   List<RoleDToView> responseBody = roleService.getAll();
   return ResponseEntity.ok().body(responseBody);

}
}
