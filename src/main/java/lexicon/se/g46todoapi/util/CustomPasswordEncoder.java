package lexicon.se.g46todoapi.util;

import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {
    private  PasswordEncoder passwordEncoder ;
    @Override
    public String encode(CharSequence rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword,String encodedPassword) {
        return passwordEncoder.matches(rawPassword,encodedPassword);
    }


    }

