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
import lexicon.se.g46todoapi.util.CustomPasswordEncoder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@Setter

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
private final CustomPasswordEncoder passwordEncoder;
    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository,CustomPasswordEncoder passwordEncoder){
        this.userRepository = userRepository ;
        this.roleRepository = roleRepository;
        this.passwordEncoder=passwordEncoder;
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
                .collect(Collectors.toSet());
      //Convert dto to entity
        User user = new User(userDTOForm.getEmail(),passwordEncoder.encode(userDTOForm.getPassword()));
        user.setRoles(roleList);
        // create a new User entity
        User savedUser = userRepository.save(user);


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
                        .collect(collector.toSet())
                ));
        return UserDTOView.builder().email(user.getEmail()).roles(roleDToViews).build();
    }

    @Override
    public void disableByEmail(String email) {
        if(!userRepository.existsByEmail(email)) throw new DataNotFoundException("Email does not exist.");
        userRepository.updateExpiredByEmail(email,true);

    }

    @Override
    public void enableByEmail(String email) {
        if(!userRepository.existsByEmail(email)) throw new DataNotFoundException("Email does not  exist.");
        userRepository.updateExpiredByEmail(email,false);

    }
  private void isEmailTaken(String email){
        if (!userRepository.existsByEmail(email))
            throw new DataNotFoundException("Email does not exist.");
  }
}
