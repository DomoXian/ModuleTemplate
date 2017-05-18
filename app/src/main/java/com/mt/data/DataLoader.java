package com.mt.data;

import com.mt.base.net.DataServiceProvider;

/**
 * Created by xianguo on 27/4/17.
 * DataService实例化 提供者
 */

public class DataLoader {

    public static DataService getInstance() {
        return DataServiceProvider.getInstance().provider(DataService.class);
    }
}
