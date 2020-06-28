package onlinecatalog.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;

    private String firstName;
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    private SchoolGroup schoolGroup;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Student_Grade",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "grade_id")})
    private List<Grade> grades;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Student_Discipline",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "discipline_id")})
    private List<Discipline> disciplines;

}
