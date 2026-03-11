package java_advanced.framework_hibernate_one_to_one.mini_project.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class University implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

private String name;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "college_id")
private College college;

public University(){}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public College getCollege() {
return college;
}

public void setCollege(College college) {
this.college = college;
}

}