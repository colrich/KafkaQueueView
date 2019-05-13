package io.pivotal.kafka.data;

public class PageviewVO implements VO {
    private int index;
    public void setIndex(int index) { this.index = index; }
    public int getIndex() { return index; }

    private long timestamp;
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
    public long getTimestamp() { return timestamp; }

    private String userId;
    public void setUserId(String userId) { this.userId = userId; }
    public String getUserId() { return userId; }

    private String pageId;
    public void setPageId(String pageId) { this.pageId = pageId; }
    public String getPageId() { return pageId; }
    
    public PageviewVO(int index, PageviewObject po) {
        setIndex(index);
        setTimestamp(po.getTimestamp());
        setUserId(po.getUserId());
        setPageId(po.getPageId());
    }
}