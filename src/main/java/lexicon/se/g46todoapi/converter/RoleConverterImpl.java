package lexicon.se.g46todoapi.converter;

import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleConverterImpl implements RoleConverter{
    @Override
    public RoleDToView toRoleVDTOView(Role entity) {
        return new RoleDToView(entity.getId(), entity.getName());

    }

    @Override
    public Role toRoleEntity(RoleDToView dToView) {
        return new Role(dToView.getId(), dToView.getName());
    }
}
