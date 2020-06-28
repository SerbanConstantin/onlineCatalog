package onlinecatalog.onlinecatalog;

import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnlinecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Student student = new Student();
//        student.setFirstName("John");
//        student.setLastName("Doe");
//
//		Student student2 = new Student();
//		student2.setFirstName("John");
//		student2.setLastName("Doe");
//
//        Student student3 = new Student();
//        student3.setFirstName("John");
//        student3.setLastName("Doe");
//
//        studentRepository.save(student);
//		studentRepository.save(student2);
//        studentRepository.save(student3);
//
//
//        System.out.println("******before delete*****");
//
//		for (Student s: studentRepository.findAll()) {
//			System.out.println(s.getStudentId() + ". " + s.getFirstName() + " " + s.getLastName());
//
//		}
//        System.out.println("******after delete*****");
//
//		studentRepository.deleteById(2);
//
//        for (Student s: studentRepository.findAll()) {
//            System.out.println(s.getStudentId() + ". " + s.getFirstName() + " " + s.getLastName());
//        }

    }
}
