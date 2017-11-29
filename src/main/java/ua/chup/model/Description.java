package ua.chup.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Description")
@NoArgsConstructor
@Getter
@Setter
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String path;

    @Column(name = "short_desc")
    private String shortDesc;

    public Description(String name, String path, String shortDesc) {
        this.name = name;
        this.path = path;
        this.shortDesc = shortDesc;
    }
}
