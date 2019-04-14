package b;


import common.utils.CommonUtils;
import initialUrl.controller.InitialUrlControllerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class b {

    public static String addMonth(String date, int months) {
        if (date.length() != 6) {
            return "";
        } else {
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));

            for(month += months; month <= 0; month += 12) {
                --year;
            }

            while(month > 12) {
                ++year;
                month -= 12;
            }

            String ret = "" + year;
            if (month >= 10) {
                ret = ret + month;
            } else {
                ret = ret + "0" + month;
            }

            return ret;
        }
    }
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");
        logger.fatal("fatal level");
        System.out.println(CommonUtils.getCurrentDate());
        System.out.println(CommonUtils.getCurrentDateAndTime());
        System.out.println(CommonUtils.getCurrentTime());
        logger.info("info","level","error");
    }
}
