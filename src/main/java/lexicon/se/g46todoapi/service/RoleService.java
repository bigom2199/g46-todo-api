package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.entity.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public interface RoleService {
    @Override
   public   List<RoleDToView> getAll(){
        for(Role entity : roles){
            rolrConverter.toRoleDTOView(entity);
        }
        return null;
    }
}
