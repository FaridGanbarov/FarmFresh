package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.authdtos.RegisterDto;
import finalproject.az.farmfresh.dtos.userdtos.UserAddRoleDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDashboardListDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDto;
import finalproject.az.farmfresh.helper.ResourceNotFoundException;
import finalproject.az.farmfresh.models.Role;
import finalproject.az.farmfresh.models.UserEntity;
import finalproject.az.farmfresh.repositories.RoleRepository;
import finalproject.az.farmfresh.repositories.UserRepository;
import finalproject.az.farmfresh.services.EmailService;
import finalproject.az.farmfresh.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmailService emailService;


    @Override
    public boolean register(RegisterDto register) {
        UserEntity user =userRepository.findByEmail(register.getEmail());
        if(user != null){
            return false;
        }
        String hashPassword =bCryptPasswordEncoder.encode(register.getPassword());
        String token=bCryptPasswordEncoder.encode(register.getEmail());
        UserEntity newUser=modelMapper.map(register, UserEntity.class);
        newUser.setEmailConfirmed(false);
        newUser.setConfirmationToken(token);
        newUser.setPassword(hashPassword);
        userRepository.save(newUser);
        emailService.sendConfirmationEmail(register.getEmail(), token);
        return true;
    }

    @Override
    public boolean confirmEmail(String email, String token) {
        UserEntity findUser = userRepository.findByEmail(email);
        if(findUser.getConfirmationToken().equals(token) && findUser != null)
        {
            findUser.setEmailConfirmed(true);
            userRepository.saveAndFlush(findUser);
            return true;
        }
        return false;
    }

    @Override
    public List<UserDashboardListDto> getDashboardUsers() {
        List<UserEntity> findUsers=userRepository.findAll();
        List<UserDashboardListDto> users=findUsers.stream().map(user->modelMapper.map(user,UserDashboardListDto.class)).collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDto getUserById(Long id) {
        UserEntity findUser=userRepository.findById(id).orElseThrow();
        UserDto user=modelMapper.map(findUser,UserDto.class);
        return user;
    }

    @Override
    public void addRole(UserAddRoleDto userAddRole) {
        UserEntity findUser=userRepository.findByEmail(userAddRole.getEmail());
        List<Role> roles=roleRepository.findAll().stream().filter(x->x.getId() == userAddRole.getRoleId()).collect(Collectors.toList());
        findUser.setRoles(roles);
        userRepository.save(findUser);
    }

}