package finalproject.az.farmfresh.services.impl;


import finalproject.az.farmfresh.dtos.roledtos.RoleDto;
import finalproject.az.farmfresh.models.Role;
import finalproject.az.farmfresh.repositories.RoleRepository;
import finalproject.az.farmfresh.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<RoleDto> getRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> result=roles.stream().map(role->modelMapper.map(role, RoleDto.class)).collect(Collectors.toList());
        return result;
    }
}
