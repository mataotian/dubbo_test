package com.qf.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.dao.IStuDao;
import com.qf.entity.Student;
import com.qf.entity.Students;
import com.qf.service.IStuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class StuServiceImpl implements IStuService {
    @Autowired
    private IStuDao stuDao;


    @Override
    public void addStu(Student student) {
        stuDao.insert(student);
    }

    @Override
    public List<Student> queryAll() {
        return stuDao.selectList(null);
    }
}
