package www.MyBatis.com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import www.MyBatis.com.dao.PersonDao;
import www.MyBatis.com.daoImpl.PersonDaoImpl;
import www.MyBatis.com.entity.Person;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/9/8 12:52
 * @description：peron操作
 * @modified By：
 * @version: $
 */
public class PersonService {
    private SqlSession sqlSession;
    public void initMybatis() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    public PageInfo<Person> personList (int pageNum,int pageSize) {
        PersonDao personDao = new PersonDaoImpl(sqlSession);
        PageHelper.startPage(pageNum, pageSize);
        List<Person> person = personDao.getPerson();
        PageInfo<Person> pageInfo = new PageInfo<>(person);
        return  pageInfo;
    }

    public void closeSqlSesssion() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    public List<Person> getPersonList() {
        PersonDao personDao = new PersonDaoImpl(sqlSession);
        return personDao.getPerson();
    }
}
