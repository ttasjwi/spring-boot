package hello.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    lateinit var memberRepository: MemberRepository

    @Transactional
    @Test
    fun memberTest() {
        val member = Member("idA", "memberA")
        memberRepository.initTable()

        memberRepository.save(member)

        val findMember = memberRepository.find(member.id)

        assertThat(findMember!!.id).isEqualTo(member.id)
        assertThat(findMember.name).isEqualTo(member.name)
    }
}
