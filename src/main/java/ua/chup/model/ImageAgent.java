package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ImageAgent")
@NoArgsConstructor
@Getter
@Setter
public class ImageAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "desc", columnDefinition = "LONGTEXT")
    private String desc;

    @Column
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "other_id")
    private Agent agent;
}
