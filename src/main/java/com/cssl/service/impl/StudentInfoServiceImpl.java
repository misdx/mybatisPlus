package com.cssl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.dao.StudentMapper;
import com.cssl.pojo.StudentInfo;
import com.cssl.service.StudentInfoService;
import org.springframework.stereotype.Service;

@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentMapper, StudentInfo> implements StudentInfoService {
}
