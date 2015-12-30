package com.yl.service;

/**
 * Created by Administrator on 2015/12/14.
 */
public class Test implements Cloneable {
    public int p;
    static {
        System.out.println("here is Test static block");
    }

    public Test clone(){
        try {
            return (Test)super.clone();
        }catch (CloneNotSupportedException e){
            return null;
        }
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}
