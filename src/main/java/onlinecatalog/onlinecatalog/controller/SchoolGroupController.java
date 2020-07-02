package onlinecatalog.onlinecatalog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import onlinecatalog.onlinecatalog.model.SchoolGroup;
import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.service.SchoolGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SchoolGroupController {

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allschoolgroups")
    public String showAllSchoolGroups(Model model) {

        List<SchoolGroup> schoolGroups = schoolGroupService.findAll();
        model.addAttribute("schoolgroups", schoolGroups);

        return "schoolgroup/showallschoolgroups";

    }

    @GetMapping("/addschoolgroup")
    public String addSchoolGroup(Model model) {
        model.addAttribute("schoolgroup", new SchoolGroup());// initial bind with the form, to say to the webpage

        return "schoolgroup/addschoolgroup";
    }

    @PostMapping("/addschoolgroup")
    public String addSchoolGroup(@ModelAttribute SchoolGroup schoolGroup) {

        schoolGroupService.save(schoolGroup);

        return "redirect:/allschoolgroups";

    }

    @GetMapping("/group/{id}/students")
    public String viewStudentsInGroup(Model model, @PathVariable Integer id) {
        model.addAttribute("students", schoolGroupService.findStudentsByGroup(id));
        return "schoolgroup/viewstudents";
    }


}
