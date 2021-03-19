package com.emailing;

import java.time.LocalTime;

public class Message {
    private String subject;
    private String content;
    private static int messageId;
    private final LocalTime time;

    public Message(String content){
        this("",content);

    }

    public Message(String subject, String content) {
        this.subject = subject;
        this.content = content;
        time = LocalTime.now();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMessageId() {
        return messageId;
    }

    public void generateMessageId(int messageId) {
        Message.messageId++;
    }

    public LocalTime getTime() {
        return time;
    }

    public String timeFormat(){
        String meridian = time.getHour() >= 12 ? "PM" : "AM";
        return meridian;
    }

    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return String.format("Subject: %s\nContent: %s\nTime sent: %s:%s %s", subject, content, time.getHour(), time.getMinute(),timeFormat());
    }
}
