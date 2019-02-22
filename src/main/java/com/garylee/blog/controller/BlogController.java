package com.garylee.blog.controller;

import com.garylee.blog.dao.BlogDao;
import com.garylee.blog.domain.Blog;
import com.garylee.blog.service.BlogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by GaryLee on 2018-08-28 16:30.
 */
@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    BlogDao blogDao;
    @RequestMapping("getBlogPageInfo")
    @ResponseBody
    public PageInfo list(@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "10")int size){
        PageHelper.startPage(start,size);
        PageInfo<Blog> page = new PageInfo<>(blogDao.listBlogs());
//        PageInfo<Blog> page = new PageInfo<>(blogService.list());
        return page;
    }
    @RequestMapping("listBlog")
    @ResponseBody
//    @Cacheable(value = "abc",key = "name")
    public List<Blog> list(){
        return blogService.list();
    }
    @RequestMapping("sortBlogs")
    @ResponseBody
    public List<Blog> sortByReadNum(){
        return blogDao.sortByReadNum();
    }
    @RequestMapping("addBlog")
    public String add(Blog blog){
        blog.setCreatetime(new Date());
        blog.setIstop(0);
        blog.setReadnum(0);
        blogService.add(blog);
        return "list";
    }
    @RequestMapping("getBlog")
    @ResponseBody
    public Blog get(int id){
        return blogService.get(id);
    }

    @RequestMapping("updateBlog")
    public void update(int id){
        Blog blog = blogService.get(id);
        blog.setReadnum(blog.getReadnum()+1);//访问量
        blogService.update(blog);
    }
    @RequestMapping("searchBlog")
    @ResponseBody
//    public List<Blog> search(String keyword){
//        return blogDao.selectByKeyWord("%"+keyword+"%");
//    }
    public PageInfo list(@RequestParam("keyword")String keyword,@RequestParam(value = "start",defaultValue = "0")int start, @RequestParam(value = "size",defaultValue = "10")int size){
        System.out.println(1);
        PageHelper.startPage(start,size);
        PageInfo<Blog> page = new PageInfo<>(blogDao.selectByKeyWord("%"+keyword+"%"));
//        PageInfo<Blog> page = new PageInfo<>(blogService.list());
        return page;
    }
    @RequestMapping("deleteBlog")
    public String deleteBlog(int id){
        blogService.delete(id);
        return "redirect:/list";
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }
}
