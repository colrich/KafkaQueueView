package io.pivotal.kafka.data;

public class MessageVO implements VO {
    private String testval;
    public void setTestval(String testval) { this.testval = testval; }
    public String getTestval() { return testval; }

    private int index;
    public void setIndex(int index) { this.index = index; }
    public int getIndex() { return index; }

    public MessageVO(int index, String testval) {
        this.index = index;
        this.testval = testval;
    }

    public MessageVO(int index, MessageObject obj) {
        setIndex(index);
        setTestval(obj.getTestval());
    }
}