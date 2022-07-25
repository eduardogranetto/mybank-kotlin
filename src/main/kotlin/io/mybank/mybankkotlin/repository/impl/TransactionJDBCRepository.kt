package io.mybank.mybankkotlin.repository.impl

import io.mybank.mybankkotlin.entity.Transaction
import io.mybank.mybankkotlin.functions.toUUID
import io.mybank.mybankkotlin.repository.TransactionRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import org.springframework.stereotype.Repository
import java.sql.Timestamp
import java.time.ZoneOffset.UTC
import java.util.*

@Repository
class TransactionJDBCRepository(
    private val jdbcTemplate: NamedParameterJdbcTemplate
) : TransactionRepository {

    private companion object {
        const val TABLE_NAME = "transactions"
    }

    private val jdbcInsert = SimpleJdbcInsert(jdbcTemplate.jdbcTemplate)
        .withTableName(TABLE_NAME)

    private val rowMapper = RowMapper<Transaction> { rs, _ ->
        Transaction(
            id = rs.getString("id").toUUID(),
            accountId = rs.getString("account_id").toUUID(),
            value = rs.getBigDecimal("value"),
            transactionTypeId = rs.getString("transaction_type_id"),
            createdAt = rs.getTimestamp("created_at").toLocalDateTime().atOffset(UTC)
        )
    }
    override fun create(transaction: Transaction) = with(transaction) {
        jdbcInsert.execute(
            mapOf(
                "id" to id,
                "account_id" to accountId,
                "value" to value,
                "transaction_type_id" to transactionTypeId,
                "created_at" to Timestamp.valueOf(createdAt.toLocalDateTime()),
            )
        )
        this
    }

    override fun findByAccountId(accountId: UUID, pageRequest: PageRequest): Page<Transaction> = jdbcTemplate.query(
        "select * from transactions where account_id = :account_id order by created_at desc offset :offset limit :limit",
        mapOf(
            "account_id" to accountId,
            "limit" to pageRequest.pageSize,
            "offset" to pageRequest.offset
        ),
        rowMapper
    ).let {
        PageImpl(it, pageRequest, 0)
    }

}