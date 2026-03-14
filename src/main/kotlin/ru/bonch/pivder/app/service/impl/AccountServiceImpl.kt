package ru.bonch.pivder.app.service.impl

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import ru.bonch.pivder.app.entity.AccountEntity
import ru.bonch.pivder.app.exception.notfound.impl.AccountNotFoundException
import ru.bonch.pivder.app.repository.AccountRepository
import ru.bonch.pivder.app.service.AccountService
import java.util.*

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
) : AccountService {
    @Transactional(readOnly = true)
    override fun findAccountById(id: UUID): AccountEntity {
        return accountRepository.findById(id)
            .orElseThrow { AccountNotFoundException("Account is not founded by id: $id") }
    }
}

