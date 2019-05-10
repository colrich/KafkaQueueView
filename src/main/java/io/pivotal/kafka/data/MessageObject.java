package io.pivotal.kafka.data;

public class MessageObject {
    private String testval;
    public void setTestval(String testval) { this.testval = testval; }
    public String getTestval() { return testval; }

    public MessageObject() {

    }

    public MessageObject(String testval) {
        setTestval(testval);
    }
}