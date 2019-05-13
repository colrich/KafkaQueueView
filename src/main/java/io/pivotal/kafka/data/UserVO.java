package io.pivotal.kafka.data;

public class UserVO implements VO {
    private int index;

    public void setIndex(int index) { this.index = index; }
    public int getIndex() { return index; }

    private long registertime;

    public long getRegistertime() { return registertime; }
    public void setRegistertime(long registertime) { this.registertime = registertime; }

    private String userid;

    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }

    private String regionid;

    public String getRegionid() { return regionid; }
    public void setRegionid(String regionid) { this.regionid = regionid; }

    private String gender;

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public UserVO(int index, UserObject user) {
        setIndex(index);
        setRegistertime(user.getRegistertime());
        setUserid(user.getUserid());
        setRegionid(user.getRegionid());
        setGender(user.getGender());
    }
}