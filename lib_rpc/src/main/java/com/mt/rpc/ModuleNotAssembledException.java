package com.mt.rpc;

/**
 * Created by xianguo on 1/4/17.
 * module 组合异常
 */

public class ModuleNotAssembledException extends Exception {

    private String mModuleClassName;

    public ModuleNotAssembledException(String moduleClassName) {
        mModuleClassName = moduleClassName;
    }

    public String getMessage() {
        return "the" + mModuleClassName + "does not exist";
    }

    public String getModuleNotExist() {
        return "组件不存在";
    }
}
