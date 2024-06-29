package finalproject.az.farmfresh.services;

import finalproject.az.farmfresh.dtos.teammemberdtos.*;
import finalproject.az.farmfresh.models.TeamMember;

import java.util.List;

public interface TeamMemberService  {
    List<TeamMemberDto>getTeamMembers();
    void addTeamMember(TeamMemberCreateDto teamMemberDto);
    List<TeamMemberHomeDto> getHomeTeamMembers();
    void updateTeamMember(TeamMemberUpdateDto teamMemberDto);
    TeamMemberUpdateDto findUpdateTeamMember(Long id);
    TeamMemberDetailDto teamMemberDetail(Long id);
    void removeTeamMember(Long teamMemberId);
}
