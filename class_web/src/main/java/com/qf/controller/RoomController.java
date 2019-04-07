package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.entity.Room;
import com.qf.service.IRoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("room")
public class RoomController {
    @Reference
    private IRoomService roomService;
    @RequestMapping("/queryAll")
    public String queryAll(Model model){
        List<Room> rooms = roomService.queryAll();
        model.addAttribute("rooms",rooms);
        return "roomlist";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "roomAdd";
    }

    @RequestMapping("/add")
    public String add(Room room){
        roomService.addRoom(room);
        return "redirect:/room/queryAll";
    }
}
