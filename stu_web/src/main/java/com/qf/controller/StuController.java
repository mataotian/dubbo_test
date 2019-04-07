package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Room;
import com.qf.entity.Student;
import com.qf.entity.Students;
import com.qf.service.IRoomService;
import com.qf.service.IStuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/stu")
public class StuController {
    @Reference
    private IStuService stuService;
    @Reference
    private IRoomService roomService;
    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Student> stus = stuService.queryAll();
        List<Room> rooms = roomService.queryAll();
        List<Students> students=new ArrayList<>();
        for (int i = 0; i <stus.size(); i++) {
            for (int j = 0; j < rooms.size(); j++) {
                if(stus.get(i).getCid()==rooms.get(j).getId()){
                    Students students1=new Students();
                    BeanUtils.copyProperties(stus.get(i),students1);
                    students1.setCname(rooms.get(j).getCname());
                    System.out.println(rooms.get(j).getCname());
                    System.out.println(stus.get(i).getName());
                    students.add(students1);
                }
            }
        }
        model.addAttribute("stus",students);
        return "stulist";
    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<Room> rooms = roomService.queryAll();
        model.addAttribute("rooms",rooms);
        return "stuAdd";
    }
    @RequestMapping("/add")
    public String add(Student student){
        stuService.addStu(student);
        return "redirect:/stu/queryAll";
    }
}
