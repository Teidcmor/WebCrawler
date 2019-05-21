package common.container;

import common.mapper.SysParamMapper;
import common.pojo.SysParam;
import common.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SysParamContainerUtils implements ApplicationListener {

    @Autowired
    private SysParamMapper sysParamMapper;

    private static Map<String,String> sysParamContainer = new Hashtable<String, String>();

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextRefreshedEvent){
            sysParamContainerInit();
        }
    }

    /**
     * 初始化系统参数表缓存map
     */
    private void sysParamContainerInit(){
        //如果自动注入依赖失败，手动注入
        if(sysParamMapper == null )
            sysParamMapper = SpringContextUtils.getAppContext().getBean(SysParamMapper.class);
        //获取所有系统参数
        ArrayList<SysParam> sysParams = sysParamMapper.getAllSysParam();
        Iterator iterator = sysParams.iterator();
        while (iterator.hasNext()){
            SysParam current = (SysParam) iterator.next();
            String name = current.getParamName();
            String value = current.getParamValue();
            sysParamContainer.put(name,value);
        }
    }

    /**
     * 通过参数名获取参数值
     * 系统参数的参数名和参数值都在数据库层控制不为空
     * @param name
     * @return
     */
    public static String getParamValueByParamName(String name) {
        String target = sysParamContainer.get(name);
        return target;
    }

    /**
     * 修改系统参数的值
     * @param sysParam
     */
    public static void editSysParam(SysParam sysParam){
         if(sysParam.getParamName()!=null&&sysParam.getParamValue()!=null){
            sysParamContainer.put(sysParam.getParamName(),sysParam.getParamValue());
        }
    }

}
