package learn.web.po.mongdb_model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Vigo on 16/8/23.
 */
@Document(collection = "user")
public class User {
    @Id
    private String id;
    private NameEntity name;
    private int age;
    private int works;
    private Date birth;
    private String password;
    private String regionName;
    private String[] special;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NameEntity getName() {
        return name;
    }

    public void setName(NameEntity name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorks() {
        return works;
    }

    public void setWorks(int works) {
        this.works = works;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String[] getSpecial() {
        return special;
    }

    public void setSpecial(String[] special) {
        this.special = special;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", age=" + age +
                ", works=" + works +
                ", birth=" + birth +
                ", password='" + password + '\'' +
                ", regionName='" + regionName + '\'' +
                ", special=" + Arrays.toString(special) +
                '}';
    }
}
