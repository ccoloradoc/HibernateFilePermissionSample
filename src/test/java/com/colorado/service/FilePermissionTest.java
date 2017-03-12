package com.colorado.service;

import com.colorado.enums.Permission;
import com.colorado.model.File;
import com.colorado.model.FilePermissions;
import com.colorado.model.User;
import com.colorado.repository.FileRepository;
import com.colorado.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colorado on 12/03/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class FilePermissionTest {

    private UserRepository userRepository;

    private FileRepository fileRepository;

    private User user;

    private File readOnlyFile;
    private File writeFile;
    private File commonFile;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setFileRepository(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Before
    public void setup() {
        user = new User();

        //Saving Files previous to make relationship
        readOnlyFile = fileRepository.save(new File("only-read.txt"));
        writeFile = fileRepository.save(new File("user-file.txt"));
        commonFile = fileRepository.save(new File("common-file.txt"));
    }

    @Test
    public void addPermission() {
        List<FilePermissions> filePermissionsList = new ArrayList<>();

        filePermissionsList.add(new FilePermissions(user, readOnlyFile, Permission.READ));
        filePermissionsList.add(new FilePermissions(user, writeFile, Permission.WRITE));
        filePermissionsList.add(new FilePermissions(user, commonFile, Permission.ALL));

        user.setFilePermissionsList(filePermissionsList);

        User savedUser = userRepository.save(user);

        assert savedUser.getId() != null;
        assert savedUser.getFilePermissionsList() != null;
        assert savedUser.getFilePermissionsList().size() == 3;
        assert savedUser.getFilePermissionsList().get(0).getId() != null;
        assert savedUser.getFilePermissionsList().get(0).getFile().getName().compareToIgnoreCase(readOnlyFile.getName()) == 0;
        assert savedUser.getFilePermissionsList().get(0).getPermission().compareTo(Permission.READ) ==0;
        assert savedUser.getFilePermissionsList().get(1).getId() != null;
        assert savedUser.getFilePermissionsList().get(1).getFile().getName().compareToIgnoreCase(writeFile.getName()) == 0;
        assert savedUser.getFilePermissionsList().get(1).getPermission().compareTo(Permission.WRITE) ==0;
        assert savedUser.getFilePermissionsList().get(2).getId() != null;
        assert savedUser.getFilePermissionsList().get(2).getFile().getName().compareToIgnoreCase(commonFile.getName()) == 0;
        assert savedUser.getFilePermissionsList().get(2).getPermission().compareTo(Permission.ALL) ==0;

    }
}
