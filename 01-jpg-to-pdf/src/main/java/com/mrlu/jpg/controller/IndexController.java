package com.mrlu.jpg.controller;

import com.mrlu.jpg.util.PdfUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 简单de快乐
 * @date 2021-06-25 22:30
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String toIndex() {
        return "index";
    }


    @PostMapping("/pdf/image/to")
    public void imageToPdf(@RequestParam("file") MultipartFile file,
                           HttpServletResponse response) throws Exception{
        System.out.println("请求进来了....");
        PdfUtils.imageToPdf(file,response);
    }

}
