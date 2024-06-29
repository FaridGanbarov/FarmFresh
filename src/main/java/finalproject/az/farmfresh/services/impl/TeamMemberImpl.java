package finalproject.az.farmfresh.services.impl;

import finalproject.az.farmfresh.dtos.blogdtos.BlogDetailDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogHomeDto;
import finalproject.az.farmfresh.dtos.blogdtos.BlogUpdateDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.*;
import finalproject.az.farmfresh.models.Blog;
import finalproject.az.farmfresh.models.CategoryBlog;
import finalproject.az.farmfresh.models.TeamMember;
import finalproject.az.farmfresh.repositories.TeamMemberRepository;
import finalproject.az.farmfresh.services.TeamMemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamMemberImpl implements TeamMemberService {
    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TeamMemberDto> getTeamMembers() {
        List<TeamMember> findTeamMembers = teamMemberRepository.findAll();
        List<TeamMemberDto> teamMembers=findTeamMembers.stream().map(teamMember -> modelMapper.map(teamMember, TeamMemberDto.class)).collect(Collectors.toList());
        return teamMembers;
    }

    @Override
    public void addTeamMember(TeamMemberCreateDto teamMemberDto) {
        try{
            TeamMember teamMember = new TeamMember();
            teamMember.setName(teamMemberDto.getName());
            teamMember.setPhotoUrl(teamMemberDto.getPhotoUrl());

            teamMember.setIsDeleted(false);
            teamMember.setDesignation(teamMemberDto.getDesignation());

            teamMemberRepository.save(teamMember);

        }catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<TeamMemberHomeDto> getHomeTeamMembers() {
        List<TeamMemberHomeDto> teamMemberDtoList = teamMemberRepository.findAll().stream()
                .filter(x->x.getIsDeleted()==false)
                .map(teamMember -> modelMapper.map(teamMember, TeamMemberHomeDto.class))
                .collect(Collectors.toList());
        return teamMemberDtoList;
    }

    @Override
    public void updateTeamMember(TeamMemberUpdateDto teamMemberDto) {
        TeamMember findTeamMember = teamMemberRepository.findById(teamMemberDto.getId()).orElseThrow();
        findTeamMember.setId(teamMemberDto.getId());
        findTeamMember.setName(teamMemberDto.getName());
        findTeamMember.setDesignation(teamMemberDto.getDesignation());
        findTeamMember.setPhotoUrl(teamMemberDto.getPhotoUrl());
        teamMemberRepository.saveAndFlush(findTeamMember);
    }

    @Override
    public TeamMemberUpdateDto findUpdateTeamMember(Long id) {
        TeamMember teamMember = teamMemberRepository.findById(id).orElseThrow();
        TeamMemberUpdateDto teamMemberUpdateDto = modelMapper.map(teamMember, TeamMemberUpdateDto.class);
        return teamMemberUpdateDto;
    }

    @Override
    public TeamMemberDetailDto teamMemberDetail(Long id) {
        TeamMember teamMember = teamMemberRepository.findById(id).orElseThrow();
        TeamMemberDetailDto teamMemberUpdateDto = modelMapper.map(teamMember,TeamMemberDetailDto.class);
        return teamMemberUpdateDto;
    }


    @Override
    public void removeTeamMember(Long teamMemberId) {
        TeamMember teamMember = teamMemberRepository.findById(teamMemberId).orElseThrow();
        teamMember.setIsDeleted(true);
        teamMemberRepository.save(teamMember);
    }
}
