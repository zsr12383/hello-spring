package spring.hellospring.repository;

import org.springframework.stereotype.Repository;
import spring.hellospring.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 동시성 문제때문에 원래는 컨쿼런스 해쉬맵을 써야한다고 함
    private static long sequence = 0L; //실무에선 동시성 때문에 다른 롱을 사용해야 한다고 함

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //하나도 발견못하면 옵셔널 널로 반환됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
