package io.pivotal.kafka.data;

import java.io.IOException;
import java.io.StringReader;

import com.opencsv.CSVReader;

public class PageviewObject {

    private long timestamp;

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    private String userId;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    private String pageId;

    public String getPageId() { return pageId; }
    public void setPageId(String pageId) { this.pageId = pageId; }

    public PageviewObject() { }

    public PageviewObject(long timestamp, String userId, String pageId) { 
        setTimestamp(timestamp);
        setUserId(userId);
        setPageId(pageId);
    }

    public static PageviewObject parse(String msg) {
        PageviewObject po = new PageviewObject();
        try {
            CSVReader reader = new CSVReader(new StringReader(msg));
            String[] pv = reader.readNext();
            if (pv == null) {
                System.out.println("PageviewObject::parse: no values successfully read");
            }
            else {
                System.out.println("PageviewObject::parse: csv read n values: " + pv.length);
                po.setTimestamp(Long.parseLong(pv[0]));
                po.setUserId(pv[1]);
                po.setPageId(pv[2]);
            }
            reader.close();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return new PageviewObject();
        }
        return po;
    }
}