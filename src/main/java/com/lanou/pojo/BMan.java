package com.lanou.pojo;


import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public class BMan implements Serializable {

  //@id:mapper识别哪一个是主键
  @Id
  private Integer id;
  private String name;
  private Integer age;
  private List<BWoman> womanList;

  //为了映射

  public List<BWoman> getWomanList() {
    return womanList;
  }

  public void setWomanList(List<BWoman> womanList) {
    this.womanList = womanList;
  }


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "BMan{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", womanList=" + womanList +
            '}';
  }
}
