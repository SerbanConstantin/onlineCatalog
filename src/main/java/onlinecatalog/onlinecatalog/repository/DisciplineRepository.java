package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.Discipline;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DisciplineRepository extends JpaRepository<Discipline, String> {
}
