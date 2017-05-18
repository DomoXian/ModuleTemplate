package com.mt.data;

import com.mt.base.data.BaseResponse;
import com.mt.base.data.PageRequest;
import com.mt.data.response.TnGouPic;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by xianguo on 27/4/17.
 * api
 */

public interface DataService {
    @POST("http://www.tngou.net/tnfs/api/list")
    Observable<BaseResponse<List<TnGouPic>>> getPicList(@Body PageRequest request);
}
