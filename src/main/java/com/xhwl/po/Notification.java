package com.xhwl.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "image_Path")
    private String imagePath;

    @Column(name = "image_Name")
    private String imageName;

    @Column(name = "expire_Time")
    private Date expireTime;

    @Column(name = "create_Time")
    private Date createTime;

    @Column(name = "msg_Content")
    private String msgContent;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return image_Path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     * @return image_Name
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * @param imageName
     */
    public void setImageName(String imageName) {
        this.imageName = imageName == null ? null : imageName.trim();
    }

    /**
     * @return expire_Time
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * @return create_Time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return msg_Content
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * @param msgContent
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }
}