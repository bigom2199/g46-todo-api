package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.entity.Role;

import java.util.List;

public interface RoleService {
    @Override
   public   List<RoleDToView> getAll(){
        for(Role entity : roles){
            roleConverter.toRoleDTOView(entity);
        }
        return null;
    }
}
