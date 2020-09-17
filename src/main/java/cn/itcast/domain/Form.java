package cn.itcast.domain;

import lombok.Data;

import java.io.Serializable;
@Data
public class Form implements Serializable {
    @Override
    public String toString() {
        return "Form{" +
                "id=" + id +
                ", istemabove=" + istemabove +
                ", isabnormal=" + isabnormal +
                ", createtime='" + createtime + '\'' +
                ", isfilled='" + isfilled + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private Integer id;

    private Integer istemabove;

    private Integer isabnormal;

    private String createtime;

    private String isfilled;

    private String userNumber;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIstemabove() {
        return istemabove;
    }

    public void setIstemabove(Integer istemabove) {
        this.istemabove = istemabove;
    }

    public Integer getIsabnormal() {
        return isabnormal;
    }

    public void setIsabnormal(Integer isabnormal) {
        this.isabnormal = isabnormal;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getIsfilled() {
        return isfilled;
    }

    public void setIsfilled(String isfilled) {
        this.isfilled = isfilled;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}