package io.pivotal.kafka.data;

import java.io.IOException;
import java.io.StringReader;

import com.opencsv.CSVReader;

public class EnrichedPageviewObject {

    private String userId;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    private String pageId;

    public String getPageId() { return pageId; }
    public void setPageId(String pageId) { this.pageId = pageId; }

    private String regionId;

    public String getRegionId() { return regionId; }
    public void setRegionId(String regionId) { this.regionId = regionId; }

    private String gender;

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public EnrichedPageviewObject() { }

    public EnrichedPageviewObject(String userId, String pageId, String regionId, String gender) { 
        setUserId(userId);
        setPageId(pageId);
        setRegionId(regionId);
        setGender(gender);
    }

    public static EnrichedPageviewObject parse(String msg) {
        EnrichedPageviewObject po = new EnrichedPageviewObject();
        try {
            CSVReader reader = new CSVReader(new StringReader(msg));
            String[] pv = reader.readNext();
            if (pv == null) {
                System.out.println("EnrichedPageviewObject::parse: no values successfully read");
            }
            else {
                System.out.println("EnrichedPageviewObject::parse: csv read n values: " + pv.length);
                po.setUserId(pv[0]);
                po.setPageId(pv[1]);
                po.setRegionId(pv[2]);
                po.setGender(pv[3]);
            }
            reader.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return new EnrichedPageviewObject();
        }
        return po;
    }
}
