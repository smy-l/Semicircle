package club.banyuan.dept.entity;

import java.io.Serializable;

/**
 * t_dept
 * @author
 */
public class Dept implements Serializable {
    private Integer id;

    private String name;

    private String description;

    private static final long serialVersionUID = 1L;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}