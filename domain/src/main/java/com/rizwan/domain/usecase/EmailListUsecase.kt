package com.rizwan.domain.usecase

import com.rizwan.domain.repository.EmailRepository
import javax.inject.Inject

class EmailListUsecase @Inject constructor(
    private val repository: EmailRepository
) {
    suspend operator fun invoke() = repository.getEmailList()
}