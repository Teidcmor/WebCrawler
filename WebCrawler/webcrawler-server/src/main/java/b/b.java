package b;


import initialUrl.controller.InitialUrlControllerImpl;
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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        InitialUrlControllerImpl initialUrlController = applicationContext.getBean(InitialUrlControllerImpl.class);
        System.out.println(initialUrlController.get().toString());
    }
}
