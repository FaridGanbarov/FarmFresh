package finalproject.az.farmfresh.controller;


import finalproject.az.farmfresh.dtos.aboutusdtos.AboutUsHomeDto;
import finalproject.az.farmfresh.dtos.factdtos.FactHomeDto;
import finalproject.az.farmfresh.dtos.teammemberdtos.TeamMemberHomeDto;
import finalproject.az.farmfresh.services.AboutUsService;
import finalproject.az.farmfresh.services.FactService;
import finalproject.az.farmfresh.services.TeamMemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AboutController {

    @Autowired
    private TeamMemberService teamMemberService;
    @Autowired
    private AboutUsService aboutUsService;

    @Autowired
    private FactService factService;
    @GetMapping("/about")
    public String index(Model model)
    {

        List<TeamMemberHomeDto> homeTeamMembers = teamMemberService.getHomeTeamMembers();
        model.addAttribute("teamMembers", homeTeamMembers);
        List<AboutUsHomeDto> homeAboutUses = aboutUsService.getHomeAboutUses();
        model.addAttribute("aboutUses", homeAboutUses);
        List<FactHomeDto> homeFacts = factService.getHomeFacts();
        model.addAttribute("facts", homeFacts);

        return "about";
    }
}
