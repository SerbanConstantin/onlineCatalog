package onlinecatalog.onlinecatalog.service;

import onlinecatalog.onlinecatalog.model.Professor;
import onlinecatalog.onlinecatalog.model.SchoolGroup;
import onlinecatalog.onlinecatalog.model.Student;
import onlinecatalog.onlinecatalog.repository.ProfessorRepository;
import onlinecatalog.onlinecatalog.repository.SchoolGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ISchoolGroupService")
public class SchoolGroupService {
    @Autowired
    private SchoolGroupRepository schoolGroupRepository;

    public List<SchoolGroup> findAll() {
        return schoolGroupRepository.findAll();
    }

    public void save(SchoolGroup schoolGroup) {
        schoolGroupRepository.save(schoolGroup);
    }

//    public SchoolGroup findById(Integer id) {
//        Optional<SchoolGroup> schoolGroup = schoolGroupRepository.findById(id);
//        if (schoolGroup.isPresent()) {
//            return schoolGroup.get();
//        }
//
//        return null;
//    }
//
//    public void deleteById(Integer id) {
//        schoolGroupRepository.deleteById(id);
//    }

    public List<Student> findStudentsByGroup(Integer id) {
        //TODO: try catch / check if present
        return schoolGroupRepository.findById(id).get().getStudents();
    }


}
