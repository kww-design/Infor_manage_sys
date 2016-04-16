package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.javabean.ScheduleBean;

public class ScheduleServlet extends HttpServlet {
	public final static long serialVersionUID = 0;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String method = req.getParameter("method");// 操作方法
		String topage =null;// 跳转页地址
		//未登录时跳转到登陆页面
		if(session.getAttribute("username")==null){
			topage="/login.jsp";
		}else{
			String username=(String) session.getAttribute("username");// 当前登陆用户名
			
			//取得分页参数
			String pageSize = req.getParameter("pageSize");//每页显示行数
			String pageNo = req.getParameter("pageNo");// 当前显示第几页
			if(pageSize == null){// 为空时设置默认页大小为25
				pageSize="25";
			}
			if(pageNo == null){//为空时设置默认为第一页
				pageNo ="1";
			}
			
			//保存分页参数。传递给下一个页面 
			req.setAttribute("pageSize", pageSize);
			req.setAttribute("pageNo", pageNo);
			
			// 根据 method 参数执行各种操作
			ScheduleBean scheduleBean = new ScheduleBean();
			if(method.equals("list")){//列表操作
				// 查询数据
				scheduleBean.list(req,username,pageSize,pageNo);
				
				topage="/schedule.jsp";
			}else if(method.equals("delete")){// 删除操作
				//执行删除
				scheduleBean.delete(req,username);
				//查询数据
				scheduleBean.list(req,username,pageSize,pageNo);
				topage="/schedule.jsp";
				
			}else if(method.equals("add")){//新增操作
				topage="/schedule_add.jsp";// 跳到新增页面
			}else if(method.equals("insert")){// 插入操作
				scheduleBean.insert(req, username);
				//查询数据
				scheduleBean.list(req,username,pageSize,pageNo);
				topage="/schedule.jsp";
			}else if(method.equals("edit")){//修改操作
				// 执行查询
				scheduleBean.select(req, username);			
				topage="/schedule_edit.jsp";// 跳转到修改页
			}else if(method.equals("update")){
				// 更新数据
				scheduleBean.update(req, username);
				// 查询数据
				scheduleBean.list(req,username,pageSize,pageNo);
				topage="/schedule.jsp";// 跳到列表页
			}
			
		}
			
		
		
		RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher(topage);
		requestDispatcher.forward(req, resp);
	
	}
}