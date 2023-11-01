package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.domain.UserDTOForm;
import lexicon.se.g46todoapi.dto.RoleDToView;
import lexicon.se.g46todoapi.dto.UserDTOView;
import lexicon.se.g46todoapi.entity.Role;
import lexicon.se.g46todoapi.entity.User;
import lexicon.se.g46todoapi.exception.DataDuplicateException;
import lexicon.se.g46todoapi.exception.DataNotFoundException;
import lexicon.se.g46todoapi.repository.RoleRepository;
import lexicon.se.g46todoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository = userRepository ;
        this.roleRepository = roleRepository;
    }
    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        if(userDTOForm == null) throw new IllegalAccessException("user form is null.");
        boolean isExistEmail = userRepository.existsByEmail(userDTOForm.getEmail());
        if(isExistEmail) throw new DataDuplicateException("Email is already exist.");
        // create password hash
      List<Role> roleList = userDTOForm.getRoles()
                .stream()
                .map(roleDToFrm -> roleRepository.findById(roleDToFrm.getId()))
                .orElseThrow(() -> new DataNotFoundException("Role is not valid."))
                .toList();

     return null;
    }

    @Override
    public UserDTOView getByEmail(String email) {
        User user = userRepository.findById(email).orElseThrow(() -> new DataNotFoundException("Email does not exist."));
        Set<RoleDToView> roleDToViews = user.getRoles()
                .stream()
                .map((role -> RoleDToView.builder()
                        .id(role.getId())
                        .name(role.getName())
                        .build()
                        .collect(collectors.toSet())
                ));
        return UserDTOView.builder().email(user.getEmail()).roles(roleDToViews).build();
    }

    @Override
    public void disableByEmail(String email) {
        isEmailTaken(email);
        userRepository.updateExpiredByEmail(email,true);

    }

    @Override
    public void enableByEmail(String email) {
        isEmailTaken(email);
        userRepository.updateExpiredByEmail(email,false);

    }
}
