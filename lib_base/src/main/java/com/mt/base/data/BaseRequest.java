package com.mt.base.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xianguo on 27/4/17.
 * 请求参数的基类
 */

public class BaseRequest {

    @SerializedName("sessionId")
    @Expose
    public String sessionId;

    @SerializedName("ime")
    @Expose
    public String ime;

}
