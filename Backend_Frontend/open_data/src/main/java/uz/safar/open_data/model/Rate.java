package uz.safar.open_data.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String comment;

    public int status;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn
    public Employee employee;

    @ManyToOne
    @JoinColumn
    public User user;


    public Rate(String comment,int status,Timestamp createdAt,Employee employee,User user){
        this.comment=comment;
        this.status =status;
        this.createdAt=createdAt;
        this.employee=employee;
        this.user=user;
    }
}
