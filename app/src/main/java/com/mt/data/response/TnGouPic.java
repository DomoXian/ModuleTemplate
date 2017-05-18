package com.mt.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xianguo on 27/4/17.
 * 天狗图片
 */

public class TnGouPic {

    @SerializedName("id")
    @Expose
    public int id;

    @SerializedName("img")
    @Expose
    public String img;

}
