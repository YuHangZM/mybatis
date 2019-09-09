package www.MyBatis.com.daoImpl;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.MyBatis.com.dao.PersonDao;
import www.MyBatis.com.entity.Person;

import java.util.HashMap;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/9/6 13:16
 * @description：真实调用者
 * @modified By：
 * @version: $
 */
public class PersonDaoImpl implements PersonDao {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    private SqlSession sqlSession;

    public PersonDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Person> getPerson() {
        List<Person> personList = sqlSession.selectList("myMapper.selectPerson");
        for (Person person : personList) {
            logger.info("输出的person是:...." + person);
        }
        return personList;
    }

    @Override
    public Person getOldPerson() {
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("username", "wangwei");
        parameters.put("old", 28);
        Person person = sqlSession.selectOne("myMapper.selectPersonOld", parameters);
        return person;
    }

    @Override
    public List<Person> selectPerson() {
//        sqlSession.selectList("myMapper.")
        return null;
    }


}
