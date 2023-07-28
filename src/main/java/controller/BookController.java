package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.BookService;
import vo.BookVO;

@Controller
public class BookController {
    
    @Autowired
    BookService service;
    
    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", service.findAll());
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("/insert")
    public ModelAndView insert(BookVO book) {
        int result = service.insert(book);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", service.findAll());
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", service.findAll());
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("/findOne")
    public ModelAndView findOne(int id) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", service.findAll());
        mv.addObject("book", service.findOneById(id));
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("/searchFind")
    public ModelAndView searchFind(String search) {
        ModelAndView mv = new ModelAndView();
        if (search != null) {
            mv.addObject("search", service.searchFind(search));
        } else {
            mv.addObject("search", service.searchFind(""));
        }
        mv.setViewName("view");
        return mv;
    }
    
    @RequestMapping("/update")
    public ModelAndView update(int id, BookVO book) {
        ModelAndView mv = new ModelAndView();
        int result = service.update(id, book);
        mv.addObject("list", service.findAll());
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping("/delete")
    public ModelAndView delete(int id) {
        ModelAndView mv = new ModelAndView();
        service.delete(id);
        mv.addObject("list", service.findAll());
        mv.setViewName("index");
        return mv;
    }
}
