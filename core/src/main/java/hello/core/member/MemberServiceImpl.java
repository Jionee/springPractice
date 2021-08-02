package hello.core.member;

public class MemberServiceImpl implements  MemberService{
    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //배우가 배우를 캐스팅하는 방식이 아니라
    //기획자(AppConfig)가 배우를 캐스팅하는 방식
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
