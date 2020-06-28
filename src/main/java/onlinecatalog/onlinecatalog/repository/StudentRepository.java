package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
}
