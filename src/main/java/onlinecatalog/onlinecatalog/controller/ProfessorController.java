package onlinecatalog.onlinecatalog.controller;

import onlinecatalog.onlinecatalog.model.Professor;
import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.service.ProfessorService;
import onlinecatalog.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("allprofessors")
    public String showAllProfessors(Model model) {

        List<Professor> professorList = professorService.findAll();
        model.addAttribute("professors", professorList);

        return "professor/showallprofessors";
    }


    @GetMapping("/addprofessor")
    public String addProfessor(Model model) {
        model.addAttribute("professor", new Professor());// initial bind with the form, to say to the webpage

        return "professor/addprofessor";
    }

    @PostMapping("/addprofessor")
    public String addprofessor(@ModelAttribute Professor professor) {

//        System.out.println(professor);
        professorService.save(professor);

        return "redirect:/allprofessors";

    }

    @GetMapping("/editprofessor/{id}")
    public String editProfessor(Model model, @PathVariable Integer id) {
        Professor professor = professorService.findById(id);

        model.addAttribute("professor", professor); // initial bind with the form, to say to the webpage
        // what is the type of student th:object

        return "professor/editprofessor";
    }

    @PostMapping("/editprofessor/{id}")
    public String editProfessor(@ModelAttribute Professor professor, @PathVariable Integer id) {
        Professor database_professor = professorService.findById(id); // to be able to update that id, get it from database
        database_professor.setLastName(professor.getLastName()); // update fields
        database_professor.setFirstName(professor.getFirstName());

        System.out.println(database_professor);
        professorService.save(database_professor); // save it again. SAVE acts as UPDATE
//        return "redirect:/editprofessor/"+id;
        return "redirect:/allprofessors";

    }

    @GetMapping("/deleteprofessor/{id}")
    public String deleteProfessor(@PathVariable Integer id) {
        professorService.deleteById(id);

        return "redirect:/allprofessors"; // forward
    }

}
