package ua.chup.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CommentInst")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body", columnDefinition = "LONGTEXT")
    private String body;

    @Column
    private String user;

    @Column(name = "path_avatar")
    private String pathAvatar;

    @Column
    private int step;

    @Column
    private String time;

    @Column(name = "other_id" )
    private int otherId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "other_id",insertable = false,updatable = false)
    private Installation installation;


    public Comment(String body,  String pathAvatar , Integer step,  String time ,String user, Integer otherId){
        this.time = time;
        this.user = user;
        this.body = body;
        this.step = step;
        this.pathAvatar = pathAvatar;
        this.otherId = otherId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPathAvatar() {
        return pathAvatar;
    }

    public void setPathAvatar(String pathAvatar) {
        this.pathAvatar = pathAvatar;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getOtherId() {
        return otherId;
    }

    public void setOtherId(int otherId) {
        this.otherId = otherId;
    }

    public Installation getInstallation() {
        return installation;
    }

    public void setInstallation(Installation installation) {
        this.installation = installation;
    }
}
