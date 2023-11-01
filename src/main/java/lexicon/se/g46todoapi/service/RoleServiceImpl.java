package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.converter.RoleConverter;
import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.entity.Role;
import lexicon.se.g46todoapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService  {
       private final RoleRepository roleRepository ;
       private  final RoleConverter roleConverter ;
  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository,RoleConverter roleConverter){
      this.roleRepository = roleRepository;
      this.roleConverter = roleConverter;
  }
    @Override
    public List<RoleDToView> getAll(){
        List<Role> roles = roleRepository.findAll();
        List<RoleDToView> roleDTOList = new ArrayList<>();
        for(Role entity : roles){
            roleDTOList.add(roleConverter.toRoleVDTOView(entity));
        }

        return roleDTOList;
    }
}
