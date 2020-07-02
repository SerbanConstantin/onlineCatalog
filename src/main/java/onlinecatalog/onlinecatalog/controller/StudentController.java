package onlinecatalog.onlinecatalog.controller;

import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.repository.StudentRepository;
import onlinecatalog.onlinecatalog.service.SchoolGroupService;
import onlinecatalog.onlinecatalog.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SchoolGroupService schoolGroupService;

    @GetMapping("allstudents")
    public String showAllStudents(Model model) {

        List<Student> studentList = studentService.findAll();
        model.addAttribute("students", studentList);

        return "student/showallstudents";
    }

    @GetMapping("/addstudent")
    public String addStudent(Model model) {
        model.addAttribute("schoolgroups", schoolGroupService.findAll());
        model.addAttribute("student", new Student());// initial bind with the form, to say to the webpage

        return "student/addstudent";
    }

    @PostMapping("/addstudent")
    public String addStudent(@ModelAttribute Student student) {

        studentService.save(student);

        return "redirect:/allstudents";
        //TODO: show in same page on the left all students, on the right add a new student
    }

    @GetMapping("/editstudent/{id}")
    public String editStudent(Model model, @PathVariable Integer id) {
        Student student = studentService.findById(id);

        model.addAttribute("student", student); // initial bind with the form, to say to the webpage
        // what is the type of student th:object

        return "student/editstudent";
    }

    @PostMapping("/editstudent/{id}")
    public String editStudent(@ModelAttribute Student student, @PathVariable Integer id) {
        Student database_student = studentService.findById(id); // to be able to update that id, get it from database
        database_student.setLastName(student.getLastName()); // update fields
        database_student.setFirstName(student.getFirstName());

        System.out.println(database_student);
        studentService.save(database_student); // save it again. SAVE acts as UPDATE
//        return "redirect:/editstudent/"+id;
        return "redirect:/allstudents";
        //TODO: show in same page on the left all students, on the right add a new student
    }

    @GetMapping("/deletestudent/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentService.deleteById(id);

        return "redirect:/allstudents"; // forward
    }


}
