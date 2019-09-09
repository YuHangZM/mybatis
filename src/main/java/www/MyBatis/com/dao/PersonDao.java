package www.MyBatis.com.dao;

import www.MyBatis.com.entity.Person;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2019/9/6 13:15
 * @description：创建dao接口
 * @modified By：
 * @version: $
 */
public interface PersonDao {
    List<Person> getPerson();
    Person getOldPerson();
    List<Person> selectPerson();
}
