package io.pivotal.kafka.data;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserObject {
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

    public UserObject() {
    }

    public UserObject(long registertime, String userid, String regionid, String gender) {
        setRegistertime(registertime);
        setUserid(userid);
        setRegionid(regionid);
        setGender(gender);
    }

    private static ObjectMapper objectMapper;
    
    static {
        objectMapper = new ObjectMapper();
    }

    public static UserObject parse(String msg) {
        UserObject user = new UserObject();
        try {
            user = objectMapper.readValue(msg, UserObject.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}