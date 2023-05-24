package com.example.soptin.presentation.retrospect

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.soptin.MainActivity
import com.example.soptin.R
import com.example.soptin.databinding.CalenderDayLayoutBinding
import com.example.soptin.databinding.FragmentRetrospectBinding
import com.example.soptin.presentation.home.AddRoutineActivity
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.text.DecimalFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.*

class RetrospectFragment : Fragment() {

    private var _binding: FragmentRetrospectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_retrospect, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calender()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    //똥코드 죄송.. 담에 시간 날때 수정할게요 ㅠㅠ 쏘리 캘린더 첨 커스텀해바
    private fun calender() {
        binding.calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                container.bind(day)
            }
        }
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val daysOfWeek = arrayOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY
        )
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH) + 1 // Note: Months are zero-based
        val dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH)
        val df = DecimalFormat("00")
        val formattedDate = "${year}년-${df.format(month)}월-${df.format(dayOfMonth)}일"

//        binding.tvDate.text = formattedDate
        binding.calendarView.setup(firstMonth, lastMonth, daysOfWeek.first())
        binding.calendarView.scrollToDate(LocalDate.now())
    }
    inner class DayViewContainer(view: View) : ViewContainer(view) {
        val df = DecimalFormat("00")
        var doneIcon = CalenderDayLayoutBinding.bind(view).doneIcon
        lateinit var day: CalendarDay

        init {
            view.setOnClickListener {
                // 날짜 선택 시 처리 정의
                val clickedDate =
                    "${day.date.year}년 ${df.format(day.date.monthValue)}월 ${df.format(day.date.dayOfMonth)}일"
                Log.d("date", clickedDate)
                // 누군가 본다면 캘린더는 딥하게 제대로 해보자
                //날짜 선정하는 부문
                binding.tvToday.text = clickedDate


            }
        }

        fun bind(day: CalendarDay) {
            this.day = day
            doneIcon.text = day.date.dayOfMonth.toString()
        }
    }
}

