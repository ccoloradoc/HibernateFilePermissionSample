package com.colorado.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by colorado on 12/03/17.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    private List<FilePermissions> filePermissionsList= new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<FilePermissions> getFilePermissionsList() {
        return filePermissionsList;
    }

    public void setFilePermissionsList(List<FilePermissions> filePermissionsList) {
        this.filePermissionsList = filePermissionsList;
    }
}
