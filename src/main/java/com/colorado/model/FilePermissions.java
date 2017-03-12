package com.colorado.model;

import com.colorado.enums.Permission;

import javax.persistence.*;

/**
 * Created by colorado on 12/03/17.
 */
@Entity
public class FilePermissions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    @ManyToOne
    private User user;

    @OneToOne
    private File file;

    private Permission permission;


    public FilePermissions() {

    }

    public FilePermissions(User user, File file, Permission permission) {
        this.user = user;
        this.file = file;
        this.permission = permission;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
