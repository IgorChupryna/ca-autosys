package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Download")
@NoArgsConstructor
@Getter
@Setter
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String path;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    private String name;

    @Column
    private String description;

    public Download(String path, String name, String description) {
        this.path = path;
        this.name = name;
        this.description = description;
    }
}
