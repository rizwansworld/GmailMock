package com.rizwan.data.repository

import com.rizwan.core.error.Failure
import com.rizwan.core.functional.Either
import com.rizwan.data.mapper.EmailDetailsMapper
import com.rizwan.data.mapper.EmailListMapper
import com.rizwan.data.remote.api.ApiService
import com.rizwan.data.remote.handler.safeApiCall
import com.rizwan.domain.model.emaildetails.EmailDetailsModel
import com.rizwan.domain.model.emaillist.EmailListItemModel
import com.rizwan.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val emailListMapper: EmailListMapper,
    private val emailDetailsMapper: EmailDetailsMapper
) : EmailRepository {
    override suspend fun getEmailList(): Either<Failure, List<EmailListItemModel>> = safeApiCall(
        apiCall = { apiService.getEmailList() },
        mapper = { emailListMapper.map(it) }
    )

    override suspend fun getEmailDetails(): Either<Failure, EmailDetailsModel> = safeApiCall(
        apiCall = { apiService.getEmailDetails() },
        mapper = { emailDetailsMapper.map(it) }
    )
}