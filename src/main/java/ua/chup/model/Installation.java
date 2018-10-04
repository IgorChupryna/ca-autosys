package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Installation")
@NoArgsConstructor
@Getter
@Setter
public class Installation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "path_video")
    private String pathVideo;

    @Column(name = "path_icon")
    private String pathIcon;

    @OneToMany(mappedBy = "installation",cascade = CascadeType.ALL)
    private List<Image> imgs=new ArrayList<>();

    @OneToMany(mappedBy = "installation",cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();

    @Column
    private String algoritm;

    @Column
    private String requirements;

    public Installation(String name, String shortDesc, String pathVideo, List<Image> imgs, List<Comment> comments, String algoritm, String requirements,  String pathIcon) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.pathVideo = pathVideo;
        this.imgs = imgs;
        this.comments=comments;
        this.algoritm = algoritm;
        this.requirements = requirements;
        this.pathIcon = pathIcon;
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public String getPathIcon() {
        return pathIcon;
    }

    public void setPathIcon(String pathIcon) {
        this.pathIcon = pathIcon;
    }

    public List<Image> getImgs() {
        return imgs;
    }

    public void setImgs(List<Image> imgs) {
        this.imgs = imgs;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAlgoritm() {
        return algoritm;
    }

    public void setAlgoritm(String algoritm) {
        this.algoritm = algoritm;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }
}
