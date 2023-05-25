package com.example.soptin.util

import java.util.*

fun getNowMonth() :MutableList<String>{
    val calendar = Calendar.getInstance()
    val currentYear = calendar.get(Calendar.YEAR) // 현재 연도 가져오기
    val currentMonth = calendar.get(Calendar.MONTH) // 현재 월 가져오기

    val yearMonthList = mutableListOf<String>() // 연도와 달을 담을 리스트 생성

    calendar.add(Calendar.YEAR, -1) // 현재로부터 1년 전으로 설정

    while (calendar.get(Calendar.YEAR) < currentYear || calendar.get(Calendar.MONTH) <= currentMonth) {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1 // 월은 0부터 시작하므로 1을 더하여 저장
        val yearMonthString = "${year}년 ${month}월"
        yearMonthList.add(yearMonthString)
        calendar.add(Calendar.MONTH, 1) // 다음 달로 이동
    }
    return yearMonthList
}