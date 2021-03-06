package spring.hellospring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.hellospring.domain.Member;
import spring.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional  //jpa쓸 때 필요 조인할 때 필요함
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired  //레포 인터페이스가 아닌 구현체를 찾아서 주입해줌, 따라서 구현체를 레포지토리 애너테이션으로 스프링컨테이너에 등록해야함 혹은 springconfig에 등록
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
