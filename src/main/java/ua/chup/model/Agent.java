package ua.chup.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Agent")
@NoArgsConstructor
@Getter
@Setter
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "short_desc")
    private String shortDesc;

    @Column(name = "full_desc")
    private String fullDesc;

    @Column(name = "path_video")
    private String pathVideo;

    @Column(name = "path_icon")
    private String pathIcon;

    @OneToMany(mappedBy = "agent",cascade = CascadeType.ALL)
    private List<ImageAgent> imgs=new ArrayList<>();


    @OneToMany(mappedBy = "agent",cascade = CascadeType.ALL)
    private List<CommentAgent> comments=new ArrayList<>();

    public Agent(String name, String shortDesc, String fullDesc, String pathVideo, String pathIcon) {
        this.name = name;
        this.shortDesc = shortDesc;
        this.fullDesc = fullDesc;
        this.pathVideo = pathVideo;
        this.pathIcon = pathIcon;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFullDesc() {
        return fullDesc;
    }

    public void setFullDesc(String fullDesc) {
        this.fullDesc = fullDesc;
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
}
