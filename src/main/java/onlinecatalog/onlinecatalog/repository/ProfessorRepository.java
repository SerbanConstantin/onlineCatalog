package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.Professor;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}