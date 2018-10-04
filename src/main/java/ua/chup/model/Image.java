package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Image")
@NoArgsConstructor
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "desc", columnDefinition = "LONGTEXT")
    private String desc;

    @Column
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "other_id")
    private Installation installation;

}
