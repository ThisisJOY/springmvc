package com.lagou.edu.controller;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.User;
import com.lagou.edu.pojo.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/resume")
public class ResumeController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */


    @Autowired
    private ResumeDao resumeDao;

    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public ModelAndView handleLogin(HttpSession httpSession, User user) {
        httpSession.setAttribute("user", user);

        ModelAndView modelAndView = new ModelAndView();
        final List<Resume> all = resumeDao.findAll();
        modelAndView.addObject("resumes", all);

        if (user != null && user.getUsername().equals("admin") && user.getPassword().equals("admin")) {
            modelAndView.setViewName("success");
        } else {
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/handle", method = {RequestMethod.GET})
    public ModelAndView handleGet() {

        ModelAndView modelAndView = new ModelAndView();
        final List<Resume> all = resumeDao.findAll();
        modelAndView.addObject("resumes", all);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/handle", method = {RequestMethod.POST})
    public @ResponseBody Resume handlePost(@RequestBody Resume resume) {
        return resumeDao.save(resume);

    }

    @RequestMapping(value = "/handle/{id}/{name}", method = {RequestMethod.PUT})
    public ModelAndView handlePut(@PathVariable Integer id, @PathVariable String name) {
        final Optional<Resume> resumeOptional = resumeDao.findById(Long.valueOf(id));
        final Resume resume = resumeOptional.get();
        resume.setName(name);
        resumeDao.save(resume);
        ModelAndView modelAndView = new ModelAndView();
        final List<Resume> all = resumeDao.findAll();
        modelAndView.addObject("resumes", all);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/handle/{id}", method = {RequestMethod.DELETE})
    public ModelAndView handleDelete(@PathVariable Integer id) {
        resumeDao.deleteById(Long.valueOf(id));
        ModelAndView modelAndView = new ModelAndView();
        final List<Resume> all = resumeDao.findAll();
        modelAndView.addObject("resumes", all);
        modelAndView.setViewName("success");
        return modelAndView;
    }

}
