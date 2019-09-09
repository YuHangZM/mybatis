package www.MyBatis.com.entity;

/**
 * @author ：mmzs
 * @date ：Created in 2019/9/6 10:19
 * @description：创建Person实体
 * @modified By：
 * @version: $
 */
public class Person {
    private String personName;
    private Integer old;

    public Person() {
    }

    public Person(String personName, Integer old) {
        this.personName = personName;
        this.old = old;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getOld() {
        return old;
    }

    public void setOld(Integer old) {
        this.old = old;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", old=" + old +
                '}';
    }
}
