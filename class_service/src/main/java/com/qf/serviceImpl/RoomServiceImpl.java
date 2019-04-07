package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.IRoomDao;
import com.qf.entity.Room;
import com.qf.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class RoomServiceImpl implements IRoomService {
    @Autowired
    private IRoomDao roomDao;
    @Override
    public void addRoom(Room room) {
        roomDao.insert(room);
    }

    @Override
    public List<Room> queryAll() {
        return roomDao.selectList(null);
    }
}
