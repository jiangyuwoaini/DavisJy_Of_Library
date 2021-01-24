package com.jy.mp.service.impl;

import com.jy.mp.beans.Employee;
import com.jy.mp.mapper.EmployeeMapper;
import com.jy.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jY
 * @since 2021-01-24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
