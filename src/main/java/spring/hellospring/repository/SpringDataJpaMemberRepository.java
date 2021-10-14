package spring.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.hellospring.domain.Member;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository <Member, Long>, MemberRepository { // 인터페이스가 인터페이스 받을 때엔 extends, 도메인 객체와 식별자의 타입, 인터페이스를 만들면 자동으로 스프링 데이터 jpa가 구현체를 만들어 스프링 빈에 등록해줌
    //웬만한 CRUD 관련 메소드는 다 구현이 돼있지만 없는 것들은 정의해주어야함, 전부 함수 정의가 필요한 것은 아니고 함수 작명 규칙에 따라 작성하면 알아서 변환해준다 함 , 리플렉션 기술이 읽어주나봐!
    Optional<Member> findByName(String name);
}
