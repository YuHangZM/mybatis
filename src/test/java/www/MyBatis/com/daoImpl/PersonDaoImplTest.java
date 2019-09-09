package www.MyBatis.com.daoImpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import www.MyBatis.com.dao.PersonDao;
import www.MyBatis.com.entity.Person;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class PersonDaoImplTest {

    protected Logger logger = LoggerFactory.getLogger(PersonDaoImplTest.class);

//    @Mock
//    private PersonDaoImpl personDao;
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }

//    @Test
//    public void getPerson() {
//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("wangbadan", 100));
//        personList.add(new Person("goushi",200));
//        Mockito.when(personDao.getPerson()).thenReturn(personList);
//        List<Person> persons = personDao.getPerson();
//        for (Person person1 : persons){
//            logger.info("姓名:"+person1.getPersonName()+"年龄:"+person1.getOld());
//        }
//        Assert.assertNotNull(persons);
//        Assert.assertTrue(persons.size() > 0);
//    }
//
//    @Test
//    public void getOldPerson() {
//        Mockito.when(personDao.getOldPerson()).thenReturn(new Person("wangbadan",1000));
//        Person oldPerson = personDao.getOldPerson();
//        logger.info(oldPerson.toString());
//        Assert.assertNotNull(oldPerson);
//
//    }

    @Test
    public void testMockito() {
        Iterator<String> iterator = Mockito.mock(Iterator.class);
        Mockito.when(iterator.next()).thenReturn("zhangsan").thenReturn("lisi").thenReturn("wangwu");

        logger.info(iterator.next()+" "+iterator.next()+" "+iterator.next());
    }

    @Test
    public void testMy() throws IOException {
        String resources = "mybatis-config.xml";
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resources));
        SqlSession sqlSession = build.openSession(true);
        PersonDao mapper = sqlSession.getMapper(PersonDao.class);
        List<Person> personList = mapper.selectPerson();
        for (Person person : personList) {
            logger.info(person.toString());
        }
    }

}