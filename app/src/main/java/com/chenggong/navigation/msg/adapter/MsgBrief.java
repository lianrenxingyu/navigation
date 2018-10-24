package com.chenggong.navigation.msg.adapter;

import android.graphics.Bitmap;

/**
 * Created by chenggong on 18-10-13.
 * <p>
 * java bean 类
 * 在消息fragment中 recycleView item 项的数据封装类型
 */

public class MsgBrief {
    private String headImagePath;   //头像
    private String name;    //名字
    private String brief;   //消息简述
    private String time;    //消息时间
    private int type;  //消息类型

    public MsgBrief(String headImagePath, String name, String brief, String time, int type) {
        this.headImagePath = headImagePath;
        this.name = name;
        this.brief = brief;
        this.time = time;
        this.type = type;
    }

    public String getHeadImagePath() {
        return headImagePath;
    }

    public void setHeadImagePath(String headImagePath) {
        this.headImagePath = headImagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MsgBrief{" +
                "headImagePath='" + headImagePath + '\'' +
                ", name='" + name + '\'' +
                ", brief='" + brief + '\'' +
                ", time='" + time + '\'' +
                ", type=" + type +
                '}';
    }

}
