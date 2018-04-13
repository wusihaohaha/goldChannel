package com.golden.common;
/**
 * 分页 工具类
 * @author xie
 */
public class PageUtil {

	/**
	 * 获取页面pagenum
	 * @param pagenum
	 * @param maxpagenum
	 * @return
	 */
	public int returnPagenum(int pagenum,int maxpagenum)
	{
		if(pagenum<=0)
		{//如果页数小于等于0
			pagenum=1;//设置为1
		}else if(pagenum>=maxpagenum)
		{//页数大于等于最大页数
			pagenum=maxpagenum;//设置为最大页数
		}
		return pagenum;
	}
	
	/**
	 * 计算总页数
	 * @param total
	 * @param maxsize
	 * @return
	 */
	public int returnMaxpage(int total,int maxsize)
	{
		int compage=total/maxsize;
		if(total%maxsize==0)
		{
			compage=compage;
		}else
		{
			compage=compage+1;
		}
		return compage;
	}
}
