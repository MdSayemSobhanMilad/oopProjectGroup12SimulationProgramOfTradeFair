package cse213.todayjava;

public class User {
    private String userid;
    private String userType;

    public User(String userid, String userType) {
        this.userid = userid;
        this.userType = userType;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
