package ua.chup.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Utils")
@NoArgsConstructor
@Getter
@Setter
public class Util {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name_u")
    private String name;

    @Column( length = 65535, columnDefinition="TEXT")
    private String description;

    @Column(length = 65535, columnDefinition="TEXT")
    private String example;

    @Column(name = "path_v")
    private String path;

    public Util(String name, String description, String example, String path) {
        this.name = name;
        this.description = description;
        this.example = example;
        this.path = path;
    }
}
