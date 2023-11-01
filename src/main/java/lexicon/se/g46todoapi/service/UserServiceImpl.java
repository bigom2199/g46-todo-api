package lexicon.se.g46todoapi.service;

import lexicon.se.g46todoapi.domain.UserDTOForm;
import lexicon.se.g46todoapi.dto.UserDTOView;
import lexicon.se.g46todoapi.exception.DataDuplicateException;
import lexicon.se.g46todoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository ;
    }
    @Override
    public UserDTOView register(UserDTOForm userDTOForm) {
        if(userDTOForm == null) throw new IllegalAccessException("user form is null.");
        boolean isExistEmail = userRepository.existsByEmail(userDTOForm.getEmail());
        if(isExistEmail) throw new DataDuplicateException("Email is already exist.");

    }

    @Override
    public UserDTOView getByEmail(String email) {
        return null;
    }

    @Override
    public void disableByEmail(String email) {

    }

    @Override
    public void enableByEmail(String email) {

    }
}
