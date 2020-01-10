package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.goods;
import entity.goodsClass;
import service.IStudentService;
import service.impl.StudentServiceImpl;

@WebServlet("/goods")
public class StudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		IStudentService ser=new StudentServiceImpl();
		String method=req.getParameter("method");
		if("query".equals(method)) {
			List<goods> list=ser.query();
			req.setAttribute("list", list);
			req.getRequestDispatcher("WEB-INF/jsp/query.jsp").forward(req, resp);
		}else if("toAdd".equals(method)) {
			List<goodsClass> list=ser.nameQuery();
			req.setAttribute("cList", list);
			req.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(req, resp);
		}
		else if("add".equals(method)) {
			goods gs=new goods();
			gs.setGoodsName(req.getParameter("name"));
			gs.setClassId(req.getParameter("className"));
			gs.setType(req.getParameter("type"));
			gs.setPrice(req.getParameter("price"));
			int num=ser.insert(gs);
			if(num>0) {
				out.print("<script>location.href='goods?method=query'</script>");
			}else {
				out.print("<script>alert('ÐÂÔöÊ§°Ü')</script>");
				req.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(req, resp);
			}
		}else if("del".equals(method)) {
			String id=req.getParameter("id");
			int Id=Integer.parseInt(id);
			int num=ser.del(Id);
			if(num>0) {
				out.print("<script>location.href='goods?method=query'</script>");
			}else {
				out.print("<script>alert('É¾³ýÊ§°Ü')</script>");
				out.print("<script>location.href='goods?method=query'</script>");
			}
		}else if("toUpd".equals(method)) {
			String id=req.getParameter("id");
			int Id=Integer.parseInt(id);		
			goods gs=ser.query(Id);
			String vl=gs.getClassName();
			List<goodsClass> list=ser.nameQuery();
			req.setAttribute("cList", list);
			req.setAttribute("vl", vl);
			req.setAttribute("gs", gs);
			req.setAttribute("cz", "upd");
			req.getRequestDispatcher("WEB-INF/jsp/add.jsp").forward(req, resp);
		}else if("upd".equals(method)) {		
			goods gs=new goods();
			gs.setGoodsId(req.getParameter("id"));
			gs.setGoodsName(req.getParameter("name"));
			gs.setClassId(req.getParameter("className"));
			gs.setType(req.getParameter("type"));
			gs.setPrice(req.getParameter("price"));
			int num=ser.upd(gs);
			System.out.println(req.getParameter("className"));
			if(num>0) {
				out.print("<script>location.href='goods?method=query'</script>");
			}else {
				out.print("<script>alert('ÐÞ¸ÄÊ§°Ü')</script>");
				out.print("<script>location.href='goods?method=query'</script>");
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
