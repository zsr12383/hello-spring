package spring.hellospring.controller;

public class MemberForm { //post방식으로 입력받을 양식인듯
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;   //post 방식으로 들어온 인풋의 네임이 자동으로 setName을 호출함
    }
}
