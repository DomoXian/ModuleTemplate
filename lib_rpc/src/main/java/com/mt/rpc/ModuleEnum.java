package com.mt.rpc;

/**
 * Created by xianguo on 5/4/17.
 * module 枚举类
 */

public enum ModuleEnum {
    ;


    private String modulePath;
    private String moduleName;

    ModuleEnum(String modulePath, String moduleName) {
        this.moduleName = moduleName;
        this.modulePath = modulePath;
    }

    public String getModulePath() {
        return modulePath;
    }

    public String getModuleName() {
        return moduleName;
    }
}
