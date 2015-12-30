package com.yl.model;

import java.util.Date;

/**
 * Created by Administrator on 2015/12/4.
 */
public class Goods {
    private Long id;
    private String name;
    private String detail;
    private String detailUrl;
    private String gotoBuyUrl;
    /**
     * 图
     */
    private String pic;
    /**
     * 信息来源站点
     */
    private String source;

    /**
     * 信息来源站点
     */
    private int sourceNum=1;
    /**
     * 信息来源站点
     */
    private Date syncTime;



    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getGotoBuyUrl() {
        return gotoBuyUrl;
    }

    public void setGotoBuyUrl(String gotoBuyUrl) {
        this.gotoBuyUrl = gotoBuyUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSourceNum() {
        return sourceNum;
    }

    public void setSourceNum(int sourceNum) {
        this.sourceNum = sourceNum;
    }

    public Date getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }
}
