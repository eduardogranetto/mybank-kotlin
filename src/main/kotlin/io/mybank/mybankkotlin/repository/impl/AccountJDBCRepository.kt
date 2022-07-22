package io.mybank.mybankkotlin.repository.impl

import io.mybank.mybankkotlin.entity.Account
import io.mybank.mybankkotlin.exception.InsufficientFundsException
import io.mybank.mybankkotlin.repository.AccountRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.ZoneOffset.UTC
import java.util.*

@Repository
class AccountJDBCRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : AccountRepository {

    private companion object {
        const val TABLE_NAME = "accounts"
    }

    private val jdbcInsert = SimpleJdbcInsert(jdbcTemplate.jdbcTemplate)
        .withTableName(TABLE_NAME)

    private val rowMapper = RowMapper<Account> { rs, _ ->
        Account(
            id = UUID.fromString(rs.getString("id")),
            document = rs.getString("document"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime().atOffset(UTC),
            balance = rs.getBigDecimal("balance")
        )
    }

    override fun create(account: Account) = with(account) {
        jdbcInsert.execute(
            mapOf(
                "id" to id,
                "document" to document,
                "created_at" to Timestamp.valueOf(createdAt.toLocalDateTime()),
                "balance" to balance
            )
        )
        this
    }

    override fun lockBalance(id: UUID, value: BigDecimal) = try {
        jdbcTemplate.update(
            "update accounts set balance = balance - :value where id = :id",
            mapOf(
                "value" to value,
                "id" to id
            )
        ) > 0
    }catch (e: DataIntegrityViolationException){
        throw InsufficientFundsException()
    }

    override fun findById(id: UUID) : Account? = jdbcTemplate.query(
        "select * from accounts where id = :id limit 1",
        mapOf(
            "id" to id
        ),
        rowMapper
    ).firstOrNull()
}