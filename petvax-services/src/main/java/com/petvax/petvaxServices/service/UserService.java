package com.petvax.petvaxServices.service;

import com.petvax.petvaxServices.config.JwtUtil;
import com.petvax.petvaxServices.converter.UserConverter;
import com.petvax.petvaxServices.dto.UserResponse;
import com.petvax.petvaxServices.entity.UserEntity;
import com.petvax.petvaxServices.exception.NotFoundException;
import com.petvax.petvaxServices.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private UserEntity userDetail;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserConverter userConverter;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        userDetail = userRepository.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found with username: " + username));

        return new org.springframework.security.core.userdetails.User(
                userDetail.getUsername(),
                userDetail.getPassword(),
                new ArrayList<>()
        );
    }
    public UserEntity getUserDetail() {
        return userDetail;
    }

    public ResponseEntity<String> login(Map<String, String> requestMap) {
        LOG.info("Inside Info");
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("username"), requestMap.get("password"))
            );
            if(auth.isAuthenticated()) {
                if(this.getUserDetail().getStatus().equalsIgnoreCase("true")) {
                    return new ResponseEntity<String>("{\"token\":\""+
                            jwtUtil.generateToken(this.getUserDetail().getUsername(),
                                    this.getUserDetail().getRole()) + "\"}",
                    HttpStatus.OK);
                } else {
                    return new ResponseEntity<String>("{\"message\":\""+
                            "Wait for admin approval."+"\"}",
                            HttpStatus.BAD_REQUEST);
                }
            }
        } catch(Exception ex) {
            LOG.error("{}", ex);
        }
        return new ResponseEntity<String>("{\"message\":\""+
                "Bad Credentials."+"\"}",
                HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> checkToken() {
        ResponseEntity<String> message = new ResponseEntity("Success!", HttpStatus.OK);
        return message;
    }

    /**
     * @param username
     * @return
     */
    @Transactional(readOnly = true)
    public UserResponse findByUsername(String username) {
        // Optional object used in the case that the request returns a null value
        // Uses the map function to determine whether or not to build the response
        // If the user object is null then it will throw the NotFoundException exception
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(userConverter::convertUserToUserResponse).orElseThrow(() -> new NotFoundException(String.format("User not found: [%s]", username)));
    }
}
