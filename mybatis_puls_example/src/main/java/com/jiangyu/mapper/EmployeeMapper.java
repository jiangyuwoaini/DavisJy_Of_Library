package com.jiangyu.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jiangyu.beans.Employee;

/**  
 * @ClassName: EmployeeMapper
 * @Description: TODO(mapper接口,
 * 基于mabatis实现:在mapper接口中编写CRUD的相关方法,提供Mapper接口所对应的sql映射文件以及方法对应的sql语句)
 * 基于MP:让xxMapper接口继承BaseMapper
 * @author Jy
 * @date 2021-01-17 06:47:53 
*/  
public interface EmployeeMapper extends BaseMapper<Employee>{
	
}
