package com.mt.base.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by xianguo on 27/4/17.
 * 分页请求
 */

public class PageRequest extends BaseRequest {

    @SerializedName("rows")
    @Expose
    public int pageSize;

    @SerializedName("page")
    @Expose
    public int pageIndex;

}
