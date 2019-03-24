package b;
import a.a;
import a.c;
import common.utils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class b {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\workSpace\\idea\\WebCrawler\\WebCrawler\\webcrawler-web\\src\\main\\resources\\common\\applicationContext.xml");
        System.out.println(applicationContext);
    }
}
