package onlinecatalog.onlinecatalog;

import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.repository.StudentRepository;
import onlinecatalog.onlinecatalog.repository.UserRepository;
import onlinecatalog.onlinecatalog.service.SendGridEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SendGridEmailService sendGridEmailService;

    public static void main(String[] args) {
        SpringApplication.run(OnlinecatalogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            userRepository.deleteById(2);
        } catch (Exception ex) {

        }
        //sendGridEmailService.sendHTML("buhaidebalta.15@gmail.com","buhaidebalta.15@gmail.com", "Hello from the other side!", "Hello!");
        //#Admins15  parola la mail
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
