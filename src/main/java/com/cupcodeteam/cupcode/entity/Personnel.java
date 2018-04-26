package com.cupcodeteam.cupcode.entity;

import com.cupcodeteam.cupcode.helper.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by YusReE_MS on 4/11/2018.
 */
@Entity
@Table(name = "personnel")
public class Personnel {
    private Integer id;

//    @JsonView(JsonViews.Normal.class)
    private String name_sername;

//    @JsonView(JsonViews.Normal.class)
    private String nickname;
//    @CreatedDate
//    @Temporal(TemporalType.DATE)
//    private Date birthday;

//    @JsonView(JsonViews.Normal.class)
    private String birthday;

//    @JsonView(JsonViews.Normal.class)
    private String position;

//    @JsonView(JsonViews.Normal.class)
    private String image;

//    @JsonView(JsonViews.Normal.class)
    private String tell;

//    @JsonView(JsonViews.Normal.class)
    private String email_per;

//    @JsonView(JsonViews.Normal.class)
    private String facebook;

//    @JsonView(JsonViews.Normal.class)
    private String line;

//    @JsonView(JsonViews.Normal.class)
    private String twitter;

//    @JsonView(JsonViews.Normal.class)
    private String instagram;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_per")
    public Integer getId() { return id; }

    public void setId(Integer id)  {this.id = id; }

    @Basic
    @Column(name = "name_sername")
    public String getName_sername() { return name_sername;}

    public void setName_sername(String name_sername) { this.name_sername = name_sername; }

    @Basic
    @Column(name = "nickname")
    public String getNickname() { return nickname; }

    public void setNickname(String nickname) { this.nickname = nickname; }

//    @Basic
//    @Column(name = "birth_day")
//    public Date getBirthday() { return birthday; }
//
//    public void setBirthday(Date birthday) { this.birthday = birthday; }
    @Basic
    @Column(name = "birth_day")
    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }

    @Basic
    @Column(name = "position")
    public String getPosition() { return position; }

    public void setPosition(String position) { this.position = position; }

    @Basic
    @Column(name = "image")
    public String getImage() { return image;}

    public void setImage(String image) { this.image = image; }

    @Basic
    @Column(name = "tell")
    public String getTell() { return tell; }

    public void setTell(String tell) { this.tell = tell; }

    @Basic
    @Column(name = "email")
    public String getEmail_per() { return email_per; }

    public void setEmail_per(String email_per) { this.email_per = email_per; }

    @Basic
    @Column(name = "facebook")
    public String getFacebook() { return facebook;}

    public void setFacebook(String facebook) {this.facebook = facebook; }

    @Basic
    @Column(name = "line")
    public String getLine() { return line;}

    public void setLine(String line) {this.line = line; }

    @Basic
    @Column(name = "twitter")
    public String getTwitter() { return twitter;}

    public void setTwitter(String twitter) {this.twitter = twitter; }

    @Basic
    @Column(name = "instagram")
    public String getInstagram() { return instagram;}

    public void setInstagram(String instagram) {this.instagram = instagram; }

}
