package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /*
    Repository의 4가지 기능
     */

    Member save(Member member);
    //Optional은 findXX로 반환할 때 없으면 null이 반환되는데,
    //이 Optional을 이용해서 감싸서 반환(선호되는 방식)
    //즉 Optional은 "null이 될 수도 있는 객체"을 감싸고 있는 일종의 래퍼 클래스
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
