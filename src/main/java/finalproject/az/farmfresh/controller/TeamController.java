package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberHomeDto;
import finalproject.az.farmfresh.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TeamController {


    @Autowired
    private TeamMemberService teamMemberService;
    @GetMapping("/team")
    public String index(Model model)
    {
        List<TeamMemberHomeDto> homeTeamMembers = teamMemberService.getHomeTeamMembers();
        model.addAttribute("teamMembers", homeTeamMembers);
        return "team";
    }
}
