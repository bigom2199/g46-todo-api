package lexicon.se.g46todoapi.converter;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.entity.Role;

public interface RoleConverter {
    RoleDToView toRoleVDTOView(Role entity);
    Role toRoleEntity(RoleDToView dToView);
}
