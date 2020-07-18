package onlinecatalog.onlinecatalog.controller.rest;

import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    private ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentRepository.findAll());
    }

    @GetMapping("/students/{id}")
    private ResponseEntity<Student> getStudent(@PathVariable Integer id) {
        return ResponseEntity.of(studentRepository.findById(id));
    }

    @PostMapping("student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok(student);

    }

    //    @PatchMapping("student/edit")
//    public ResponseEntity<Student> editStudent(@RequestBody Student student){
//        studentRepository.save(student);
//        return ResponseEntity.ok(student);
//
//    }
    @DeleteMapping("student/delete{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Integer id) {
        try {
            studentRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
