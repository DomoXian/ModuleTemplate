package com.mt.rpc;

import java.util.HashMap;

/**
 * Created by xianguo on 1/4/17.
 * 提供各个module对外暴露的接口
 */

public class ModuleServiceManager {
    private final static HashMap<String, IModule> sModuleMap = new HashMap<>();

    public static <T extends IModule> T getModule(String moduleName) throws ModuleNotAssembledException {
        T moduleInstance = (T) sModuleMap.get(moduleName);
        if (moduleInstance != null) {
            return moduleInstance;
        } else {
            try {
                Class<?> moduleClass = Class.forName(moduleName);
                IModule newModuleInstance = (IModule) moduleClass.newInstance();
                sModuleMap.put(moduleName, newModuleInstance);
                return (T) newModuleInstance;
            } catch (Exception e) {
                e.printStackTrace();
                throw new ModuleNotAssembledException(moduleName);
            }
        }
    }
}
