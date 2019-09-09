package www.MyBatis.com;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.MyBatis.com.entity.Person;
import www.MyBatis.com.service.PersonService;

import java.io.IOException;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/9/6 10:27
 * @description：MyBatis测试
 * @modified By：
 * @version: $
 */
public class MybatisTest {
    private static Logger logger = LoggerFactory.getLogger(MybatisTest.class);
    public static void main(String[] args) throws IOException {
        PersonService personService = new PersonService();
        personService.initMybatis();
        PageHelper.startPage(1, 2);
        List<Person> personList = personService.getPersonList();
//        PageInfo<Person> pageInfo = new PageInfo<>(personList);
        personService.closeSqlSesssion();
//        logger.info("页码:..."+pageInfo.getPageNum()+" 总数:..."+pageInfo.getTotal());
    }
}
