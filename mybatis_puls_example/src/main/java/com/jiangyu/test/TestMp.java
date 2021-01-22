package com.jiangyu.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiangyu.beans.Employee;
import com.jiangyu.mapper.EmployeeMapper;

public class TestMp {
	private final static Logger logger = LoggerFactory.getLogger(TestMp.class.getName());
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static void main(String[] args){
		TestMp mp = new TestMp();
//		System.out.println(mp.testCommontInsert());
//		System.out.println(mp.TestCommonUpdate());
		mp.testCommonSelect();
	}
	@Test
	public int testCommontInsert()  {
		Integer result = 0;
		try {
			EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
			Employee employee = new Employee();
			employee.setLastName("mp");
			employee.setEmail("1824@163.com");
			employee.setGender(1);
			employee.setAge(22);
			//result = employeeMapper.insert(employee);
			result = employeeMapper.insertAllColumn(employee);
			//获取当前数据在数据库中主键值
			Integer id = employee.getId();
			System.out.println("key:"+id);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Test
	public void testCommonSelect() {
		//初始化对象
		EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
//		Employee employee = employeeMapper.selectById(7);
//		System.out.println(employee);
		//2.用过多个列进行查询 id + lastName
//		Employee employee = new Employee();
//		employee.setId(6);
//		employee.setLastName("马里亚老师");
//		Employee result = employeeMapper.selectOne(employee);
//		System.out.println(result);
		//3.通过多个id进行查询
//		List<Integer> idList = new ArrayList<Integer>();
//		idList.add(4);
//		idList.add(5);
//		idList.add(7);
//		idList.add(1);
//		List<Employee> emps = employeeMapper.selectBatchIds(idList);
//		System.out.println(emps);
		//通过Map封装条件查询
		Map<String,Object> columnMap = new HashMap<String, Object>();
		columnMap.put("last_name","Tom");
		columnMap.put("gender", 1);
		List<Employee> empList = employeeMapper.selectByMap(columnMap);
		logger.info("查询成功");
		System.out.println(empList);
	}
	@Test
	public int TestCommonUpdate() {
		Integer result = 0;
		try {
			//初始化对象
			EmployeeMapper employeeMapper = ioc.getBean("employeeMapper",EmployeeMapper.class);
			Employee employee = new Employee();
			employee.setId(6);
			employee.setLastName("马里亚老师");
			employee.setEmail("mly@sina.com");
			employee.setAge(33);
			//result = employeeMapper.updateById(employee);
			  result = employeeMapper.updateAllColumnById(employee);
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Test
	public void testDatasource() throws SQLException {
		DataSource ds = ioc.getBean("dataSource",DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
}
