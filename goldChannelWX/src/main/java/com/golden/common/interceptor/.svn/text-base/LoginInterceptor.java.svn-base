package com.golden.common.interceptor;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor
{
    // 利用正则映射到需要拦截的路径，下面代码做到逻辑是拦截iURL里面的地址，也可以做成除了iURL里的地址都拦截的逻辑，白名单和黑名单的的区别
    private ArrayList<String> iURL;

    public LoginInterceptor()
    {
    }

    /**
     * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception
    {
    }

    /**
     * 在业务请求处理器执行之后，生成视图之前执行
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception
    {
        // 可以用来记录日志
    }

    /**
     * 在业务处理器之前调用，如果return false 后面全部只执行后续拦截方法
     * 
     * @param arg0
     * @param arg1
     * @param arg2
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception
    {
        String url = request.getRequestURL().toString();
        for (String mappingUrl : iURL)
        {
            if (mappingUrl == null || url.matches(mappingUrl))
            {
            	/*ManagerInfo managerInfo = (ManagerInfo) request.getSession().getAttribute("manager_user");
                if (managerInfo == null)
                {
                    if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
                    { //如果是ajax请求响应头会有，x-requested-with  
                        response.setHeader("sessionstatus", "unlogin");//在响应头设置session状态  
                    } else {
                        request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
                    }
                    return false;
                }*/
                return true;
            }
        }
        return true;
    }

    public ArrayList<String> getiURL()
    {
        return iURL;
    }

    public void setiURL(ArrayList<String> iURL)
    {
        this.iURL = iURL;
    }
}