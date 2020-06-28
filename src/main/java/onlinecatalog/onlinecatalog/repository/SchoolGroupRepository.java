package onlinecatalog.onlinecatalog.repository;

import onlinecatalog.onlinecatalog.model.SchoolGroup;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SchoolGroupRepository extends JpaRepository<SchoolGroup, Integer> {
}
