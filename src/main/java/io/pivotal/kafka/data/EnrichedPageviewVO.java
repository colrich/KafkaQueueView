package io.pivotal.kafka.data;

public class EnrichedPageviewVO implements VO {
    private int index;
    public void setIndex(int index) { this.index = index; }
    public int getIndex() { return index; }

    private String userId;
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserId() { return userId; }

    private String pageId;
    public void setPageId(String pageId) { this.pageId = pageId; }
    public String getPageId() { return pageId; }
    
    private String regionId;
    public String getRegionId() { return regionId; }
    public void setRegionId(String regionId) { this.regionId = regionId; }

    private String gender;
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public EnrichedPageviewVO(int index, EnrichedPageviewObject po) {
        setIndex(index);
        setUserId(po.getUserId());
        setPageId(po.getPageId());
        setRegionId(po.getRegionId());
        setGender(po.getGender());
    }
}
