package com.xzq.curd.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzq.curd.bean.Employee;
import com.xzq.curd.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*处理员工增删改查crud 请求
* */
@Controller
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    /*
    * 查询员工数据 (分页查询)
    * */

   @RequestMapping("/emps")
    public String getEmps(@RequestParam (value = "pn",defaultValue = "1")Integer pn,Model model){
       //这不是一个分页查询
       //引入PageHelpler分页插件 并注册
        //查询之前只需调用，插入页码，以及每页的大小
       PageHelper.startPage(pn,5);
       //现在startPage紧跟着的查询就是一个分页查询。
       List<Employee> emps= employeeService.getALL();
       //使用PageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
       //封装了详细的分页信息，包括有我们查询出来的数据 ,传入连续显示的页数
       PageInfo page=new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
    return "list";
    }

}

