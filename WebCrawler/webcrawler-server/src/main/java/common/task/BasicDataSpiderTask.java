package common.task;

import common.utils.CommonUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BasicDataSpiderTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        System.out.println("定时任务测试："+CommonUtils.getCurrentDateAndTime());
    }
}
