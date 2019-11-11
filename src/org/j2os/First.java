package org.j2os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.MediaSizeName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Controller
//default : @Scope("singletone")
@RequestMapping("/first")   //like @Path in jersy
public class First {

//    http://localhost:8082/first/a?name=ali&id=101
//    @RequestMapping handles both get and post
    @RequestMapping("/a")  //--> ./first/a
    //and check request scope of person
    public String a(HttpServletRequest httpServletRequest, @ModelAttribute("person") Person person) {//ModelAttribute Person person  -->
        // get parameters(from post or get) and set to person. it does not take parameter from body,but it take parameter from spring-forms(<form:..> in view)

        System.out.println("ana :"+person.getName()+"   "+person.getId());
        httpServletRequest.setAttribute("name",person.getName());
        httpServletRequest.setAttribute("id",person.getId());
        //return "one"; --> dispatch: /one.jsp
        //return "redirect:/one.jsp";
        return "one";
    }

    @RequestMapping(value = "/b",method = RequestMethod.POST)
//    http://localhost:8082/first/b   +    get parameters from spring form components in view
    public String b(HttpServletRequest httpServletRequest, @ModelAttribute Person person) {

        System.out.println("ana "+person.getName()+"   "+person.getId());
        httpServletRequest.setAttribute("name",person.getName());
        httpServletRequest.setAttribute("id",person.getId());

        //return "one"; --> dispatch: /one.jsp
        //return "redirect:/one.jsp";
        return "one";
    }

    @RequestMapping(value = "/rb",method = RequestMethod.POST)
//    http://localhost:8082/first/rb  +   body : {   "name":"ali",
//"id":"27"
//}
    public String rb(HttpServletRequest httpServletRequest, @RequestBody Person person) {

        System.out.println("ana "+person.getName()+"   "+person.getId());
        httpServletRequest.setAttribute("name",person.getName());
        httpServletRequest.setAttribute("id",person.getId());

        //return "one"; --> dispatch: /one.jsp
        //return "redirect:/one.jsp";
        return "one";
    }

    @RequestMapping("/c") //--> ./first/c
    public void c() {
        System.out.println("ana c");
        //when there is no return, it looks for method-name.jsp
        //in contrary to jsf that void means remain in the same view
    }

    @RequestMapping("/d")
    @ResponseBody
    public Object d( ) {  //restFull

        List<Person> personList = Arrays.asList(new Person(1L,"a"),new Person(2L,"b"),new Person(3L,"c"));
        return personList;
    }

    @RequestMapping("/e")
    public String e(HttpServletRequest httpServletRequest, @ModelAttribute Person person) {

        System.out.println("ana e:"+person.getName()+"   "+person.getId());
        return "redirect:/one.jsp";
    }

    @RequestMapping("/f/{t}")
    public String f(@PathVariable("t") String x) {

        System.out.println("ana f:  t= "+x);
        return "redirect:/one.jsp";
    }

}
