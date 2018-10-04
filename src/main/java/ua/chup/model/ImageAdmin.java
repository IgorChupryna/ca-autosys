package ua.chup.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ImageAdmin")
@NoArgsConstructor
@Getter
@Setter
public class ImageAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "desc", columnDefinition = "LONGTEXT")
    private String desc;

    @Column
    private String path;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "other_id")
    private Administration administration;
}
