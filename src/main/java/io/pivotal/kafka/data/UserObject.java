package io.pivotal.kafka.data;

import java.io.IOException;
import java.io.StringReader;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

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


    public static UserObject parse(String msg) {
        UserObject user = new UserObject();
        try {
            CSVReader reader = new CSVReader(new StringReader(msg));
            String[] pv = reader.readNext();
            if (pv == null) {
                System.out.println("UserObject::parse: no values successfully read");
            }
            else {
                System.out.println("UserObject::parse: csv read n values: " + pv.length);
                user.setRegistertime(Long.parseLong(pv[0]));
                user.setUserid(pv[1]);
                user.setRegionid(pv[2]);
                user.setGender(pv[3]);
            }
            reader.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return new UserObject();
        }
        return user;
    }



/*        
    private static ObjectMapper objectMapper;
    
    static {
        objectMapper = new ObjectMapper();
    }

    private static UserObject parse(String msg) {
        UserObject user = new UserObject();
        try {
            user = objectMapper.readValue(msg, UserObject.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
*/

}