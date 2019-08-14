package com.itcast.controller;

import com.itcast.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author
 * @create 2019-07-15-10:45
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    @RequestMapping("hello")
    public String sayHello(){
        System.out.println("hello");
        return "success";
    }
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println(user);
        user.setUsername("hh");
        user.setPassword("123");
        user.setAge(12);
        System.out.println(user);
        return user;

    }
    //传统方式上传文件
    public String tradtionalfileload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("文件删除");
        //指定上传位置，某某位置的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        //解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items =upload.parseRequest(request);
        //遍历
        for (FileItem item : items) {
            //判断item是否为上传文件项
            if(item.isFormField()){
                //说明是普通form表单项

            }else{
                //获取上传文件项
                //获取上传文件名称
               String filename = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-","");
                filename =uuid+"_"+filename;
                //往path上传filename的文件
               item.write(new File(path,filename));
               //删除临时文件
               item.delete();
            }
        }
        return "success";
    }
@com
    //使用springmvc进行文件上传，更简单
    public String Mvcfileload(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("文件删除");
        //指定上传位置，某某位置的绝对路径
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_"+filename;
        upload.transferTo(new File(path,filename));

        return "success";


    }
    //使用springmvc进行文件上传，更简单
    @RequestMapping("/mvcfileload2")
    public String mvcfileload2(HttpServletRequest request, MultipartFile upload) throws Exception {

        String path = "http://localhost:9090/uploads/";
        //判断该路径是否存在

        String filename = upload.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid + "_"+filename;
        //创建一个客户端的对象
        Client client = Client.create();
        //和图片服务器进行连接
        WebResource webResource = client.resource(path+filename);
        //上传文件
        webResource.put(upload.getBytes());
        return "success";


    }





}

