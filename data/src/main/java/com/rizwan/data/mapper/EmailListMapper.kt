package com.rizwan.data.mapper

import com.rizwan.core.functional.orDefault
import com.rizwan.core.mapper.ResultMapper
import com.rizwan.data.dto.emaillist.EmailListItemDto
import com.rizwan.domain.model.emaillist.EmailListItemModel
import javax.inject.Inject

class EmailListMapper @Inject constructor(): ResultMapper<List<EmailListItemDto>, List<EmailListItemModel>> {
    override fun map(input: List<EmailListItemDto>): List<EmailListItemModel> = input.filter {
        it.id != null && it.payload.from != null
    }.map {
        it.toModel()
    }

    private fun EmailListItemDto.toModel() = EmailListItemModel(
        id = id!!,
        from = payload.from!!,
        profileImage = payload.profileImage,
        subject = payload.subject.orEmpty(),
        snippet = snippet.orEmpty(),
        date = payload.date.orEmpty(),
        isImportant = isImportant.orDefault(),
        isStarred = isImportant.orDefault(),
        isPromotional = isPromotional.orDefault()
    )
}