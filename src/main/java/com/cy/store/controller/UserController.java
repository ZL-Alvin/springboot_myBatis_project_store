package com.cy.store.controller;

import com.cy.store.controller.ex.*;
import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.utils.JsonResult;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @Title: UserController
 * @Author Alvin
 * @Package com.cy.store.controller
 * @Date 2023/4/19 21:22
 * @description: 用户模块控制层
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController{
    @Autowired
    private IUserService userService;

    @PostMapping("/reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(Ok);
    }
    
    @PostMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User loginUser = userService.login(username, password);
        session.setAttribute("uid", loginUser.getUid());
        session.setAttribute("username", loginUser.getUsername());
        return new JsonResult<User>(Ok, loginUser);
    }

    @PostMapping("/changePassword")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(Ok);
    }

    @GetMapping("/getByUid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getuidFromSession(session));
        return new JsonResult<>(Ok, data);
    }

    @PostMapping("/changeInfo")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        userService.changeInfo(getuidFromSession(session), getUsernameFromSession(session), user);
        return new JsonResult<>(Ok);
    }

    /**设置上传文件的最大值*/
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024; //10M

    /**限制上传文件的类型*/
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("image/jpeg");
        AVATAR_TYPE.add("image/png");
        AVATAR_TYPE.add("image/bmp");
        AVATAR_TYPE.add("image/gif");
        AVATAR_TYPE.add("image/jpg");
    }

    /**
     * MultipartFile接口是SpringMVC提供的一个接口，这个接口包含了获取文件类型的数据（任何类型的file都可以接收）。Springboot整合了SpringMVC，
     * 只需要在处理请求的方法参数列表上声明一个参数类型为MultipartFile的参数，然后Springboot将自动传递给服务的文件数据赋值给这个参数
     * @param session
     * @param file
     * @return
     */
    @PostMapping("/changeAvatar")
    public JsonResult<String> changeAvatar(HttpSession session, MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("文件超出限制");
        }
        //判断文件的类型是否是我们规定的后缀类型
        String contentType = file.getContentType();
        if (!AVATAR_TYPE.contains(contentType)) {
            throw new FileTypeException("文件类型不支持");
        }
        // 上传的文件.../upload/文件.png
        String parent = "D:\\IDEA project\\java_project\\store\\upload";
        //File对象指向这个路径，File是否存在
        File dir = new File(parent);
        if (!dir.exists()) { //检测目录是否存在
            dir.mkdirs(); //创建当前的目录
        }
        //获取到这个文件的名称，UUID工具来将生成一个新的字符串作为文件名
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileName = UUID.randomUUID().toString() + suffix;
        String finalPath = parent + File.separator + fileName;
        //实现上传功能
        try {
            file.transferTo(new File(finalPath));
        } catch (IOException e) {
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }
        Integer uid = getuidFromSession(session);
        String username = getUsernameFromSession(session);
        //虚拟路径映射
        String imagePath = "/local/" + fileName;
        userService.changeAvatar(new User(uid, imagePath, username));
        // 返回用户头像路径给前端页面，将来用于头像展示使用
        return new JsonResult<>(Ok, imagePath);
    }
}
