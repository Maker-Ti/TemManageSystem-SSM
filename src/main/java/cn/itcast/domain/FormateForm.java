package cn.itcast.domain;

public class FormateForm {
    private String id;
    private String createTime;
    private String isTemAbove;
    private String isAbnormal;
    private String userName;
    private String userNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getIsTemAbove() {
        return isTemAbove;
    }

    public void setIsTemAbove(String isTemAbove) {
        this.isTemAbove = isTemAbove;
    }

    public String getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(String isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
