package com.lanou.pojo;


import javax.persistence.Id;

public class BWoman {

  @Id
  private Integer id;
  private String name;
  private Integer age;
  private BMan man;

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

  public BMan getMan() {
    return man;
  }

  public void setMan(BMan man) {
    this.man = man;
  }

  @Override
  public String toString() {
    return "BWoman{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", man=" + man +
            '}';
  }
}
