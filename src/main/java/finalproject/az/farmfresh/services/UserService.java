package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.authdtos.RegisterDto;
import finalproject.az.farmfresh.dtos.userdtos.UserAddRoleDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDashboardListDto;
import finalproject.az.farmfresh.dtos.userdtos.UserDto;
import finalproject.az.farmfresh.models.UserEntity;

import java.util.List;

public interface UserService {
    boolean register(RegisterDto register);
    boolean confirmEmail(String email,String token);
    List<UserDashboardListDto> getDashboardUsers();
    UserDto getUserById(Long id);
    void addRole(UserAddRoleDto userAddRole);




}
