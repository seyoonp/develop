package com.varzac.servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.varzac.util.Util;

public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {    	
    	ServletContext context = this.getServletContext();   
        //context.setAttribute("SYSTEM_IMAGE_URL", Config.getString("system.image.url"));
        new Util(context);
    }
    
    @Override
    public void destroy() {
        super.destroy();
    }
}