package ua.chup.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "path_icon")
    private String pathIcon;

    @OneToMany(mappedBy = "description",cascade = CascadeType.ALL)
    @OrderBy("other_id")
    private List<CommentDesc> comments=new ArrayList<>();

    public Description(String name, String path, String shortDesc, String pathIcon) {
        this.pathIcon=pathIcon;
        this.name = name;
        this.path = path;
        this.shortDesc = shortDesc;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getPathIcon() {
        return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }

    public List<CommentDesc> getComments() {
        return comments;
    }

    public void setComments(List<CommentDesc> comments) {
        this.comments = comments;
    }
}
