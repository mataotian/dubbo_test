package com.qf.service;

import com.qf.entity.Room;

import java.util.List;

public interface IRoomService {

    void addRoom(Room room);
    List<Room> queryAll();
}
