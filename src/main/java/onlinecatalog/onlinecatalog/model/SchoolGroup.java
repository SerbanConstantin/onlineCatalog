package onlinecatalog.onlinecatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SchoolGroup {
    private String groupName;

    private Date groupYear;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int groupId;

    @OneToMany(
            mappedBy = "schoolGroup",
            cascade = CascadeType.ALL
    )
    private List<Student> students;

}

