package com.yourtest.service

interface IGeneralService {
    fun search(params: List<SearchCriteria>) : List<Any>
}