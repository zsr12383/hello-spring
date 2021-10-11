package spring.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // /hello로 입력된 uri가 여기 매핑되는듯, 분해 됐다가 재조립 되는게 이런 걸 말하는 느낌인데
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; //hello.html을 찾아서 글로 넘겨라 이런 뜻인듯, 뷰리졸버가 템플리츠에 있는 html 파일 찾음
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    //@ResponseBody 를 사용하면 뷰 리졸버( viewResolver: 템플릿에서 html 찾아서 넘겨주는 녀석 )를 사용하지 않음
    //대신에 HTTP의 BODY에 문자 내용을 직접 반환(HTML BODY TAG를 말하는 것이 아님)
    //@ResponseBody 를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}

