package hello.member

import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class MemberRepository(
    private val template: NamedParameterJdbcTemplate
) {

    fun initTable() {
        template.jdbcTemplate.execute("CREATE TABLE member(member_id varchar primary key, name varchar)")
    }

    fun save(member: Member) {
        template.update(
            "INSERT INTO member (member_id, name) VALUES (:memberId, :name)", mapOf(
                "memberId" to member.id,
                "name" to member.name
            )
        )
    }

    fun find(memberId: String): Member? {
        return template.queryForObject(
            "SELECT member_id, name FROM member WHERE member_id = :memberId",
            mapOf("memberId" to memberId),
            memberRowMapper()
        )
    }

    fun findAll(): List<Member> {
        return template.query("SELECT member_id, name FROM member", memberRowMapper())
    }

    private fun memberRowMapper(): RowMapper<Member> {
        return RowMapper { rs, _ -> Member(
                id = rs.getString("member_id"),
                name = rs.getString("name")
            )
        }
    }

}
