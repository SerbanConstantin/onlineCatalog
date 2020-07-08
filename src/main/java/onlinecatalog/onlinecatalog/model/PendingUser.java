package onlinecatalog.onlinecatalog.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
@NoArgsConstructor
public class PendingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String activationCode;
    private Date expireDate;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;

}
