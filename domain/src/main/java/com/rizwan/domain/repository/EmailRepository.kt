package com.rizwan.domain.repository

import com.rizwan.core.error.Failure
import com.rizwan.core.functional.Either
import com.rizwan.domain.model.emaildetails.EmailDetailsModel
import com.rizwan.domain.model.emaillist.EmailListItemModel

interface EmailRepository {
    suspend fun getEmailList(): Either<Failure, List<EmailListItemModel>>
    suspend fun getEmailDetails(): Either<Failure, EmailDetailsModel>
}