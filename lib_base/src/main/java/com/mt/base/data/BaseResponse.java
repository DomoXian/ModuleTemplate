package com.mt.base.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xianguo on 27/4/17.
 * 返回结果的基类
 */

public class BaseResponse<T> {

    @SerializedName("status")
    @Expose
    public boolean status;

    @SerializedName("code")
    @Expose
    public String code = "101";

    @SerializedName("desc")
    @Expose
    public String desc = "业务异常";

    @SerializedName("tngou")
    @Expose
    public T result;
}
