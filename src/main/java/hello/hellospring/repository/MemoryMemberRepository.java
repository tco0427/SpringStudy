package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;


public class MemoryMemberRepository implements MemberRepository{
    /*실무에서는 동시성 문제가 있을 수 있어서 ConcurrentHashMap써야함, AutomicLong도 같은 맥락*/

    private static Map<Long, Member> store=new HashMap<>();
    private static long sequence=0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //null이 반환될 가능성이 있으면 Optional로 감쌈
        //Optional.ofNullable()을 통해 Optional로 감싸서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member ->member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
