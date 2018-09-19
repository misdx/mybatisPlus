package com.cssl.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cssl.pojo.StudentInfo;
import com.cssl.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class StudentInfoController {

    private final StudentInfoService studentInfoService;

    @Autowired
    public StudentInfoController(StudentInfoService studentInfoService) {
        this.studentInfoService = studentInfoService;
    }

    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav,@RequestParam(defaultValue = "0") int index){
        mav.setViewName("index");
        //查询所有 + 一个按照stuid = 1 的条件 并且 根据stuid 降序排列
        /*List<StudentInfo> list = studentInfoService.selectList(
                new QueryWrapper<StudentInfo>().eq("stuid","1").orderByDesc("stuid")
        );*/
        Page<StudentInfo> studentInfoIPage = (Page<StudentInfo>) studentInfoService.selectPage(
                new Page<StudentInfo>(index, 5, (long) studentInfoService.selectCount(
                        new QueryWrapper<StudentInfo>()
                )), new QueryWrapper<StudentInfo>()
        );
        System.out.println("每页显示几条数据"+studentInfoIPage.getSize());
        System.out.println("当前页码"+studentInfoIPage.getCurrent());
        System.out.println("总共有多少页"+studentInfoIPage.getPages());
        System.out.println("总数据量"+studentInfoIPage.getTotal());
        List<StudentInfo> records = studentInfoIPage.getRecords();
        for(StudentInfo studentInfo : records){
            System.out.println(studentInfo);
        }
        mav.addObject("list",studentInfoIPage);
        return mav;
    }

    @RequestMapping("/insert")
    public String insert(StudentInfo studentInfo){
        if(studentInfoService.insert(studentInfo)){
            System.out.println("新增成功");
            return "forward:/";
        }else{
            System.out.println("新增失败");
            return "insert.html";
        }
    }
    // 我是git
    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(Model model, Integer stuid){
        StudentInfo studentInfo = studentInfoService.selectById(stuid);
        model.addAttribute("stu",studentInfo);
        return "update";
    }
    @ResponseBody
    @RequestMapping("delete")
    public String delete(Integer stuid){
        System.out.println(stuid);
        if(studentInfoService.deleteById(stuid)){

            return "true";
        }
        return "false";
    }
}
