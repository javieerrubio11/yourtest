package com.yourtest.service

import com.yourtest.service.impl.SearchCriteria

interface GeneralService {
    fun search(params: List<SearchCriteria>) : List<Any>
}