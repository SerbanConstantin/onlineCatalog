package onlinecatalog.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int gradeId;

    private double grade;

    private Date gradeDate;

    @ManyToMany(mappedBy = "grades")

    private List<Student> students;
}
