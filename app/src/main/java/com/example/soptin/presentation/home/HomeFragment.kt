package com.example.soptin.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.soptin.R
import com.example.soptin.databinding.CalenderDayLayoutBinding
import com.example.soptin.databinding.FragmentHomeBinding
import com.example.soptin.presentation.AddRoutine.AddRoutineActivity
import com.example.soptin.presentation.routine.RoutineViewModel
import com.example.soptin.util.BorderItemDecoration
import com.example.soptin.util.ViewModelFactory
import com.example.soptin.util.convertToKoreanDayOfWeek
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import java.text.DecimalFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.*


class HomeFragment : Fragment(){

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val adapter = HomeAdapter()
    private val viewModel: RoutineViewModel by viewModels { ViewModelFactory(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calender()
        viewModel.getRoutine("2023-05-23")

        viewModel.routineDto.observe(viewLifecycleOwner) {
            binding.rv1.adapter = adapter.apply {
                submitList(it)
            }
        }

        val itemDecoration = BorderItemDecoration(requireContext(), 2) // 테두리 두께 설정
        binding.rv1.addItemDecoration(itemDecoration)

        binding.btnAddRoutine.setOnClickListener {
            val intent = Intent(context, AddRoutineActivity::class.java)
            startActivity(intent)
        }

    }

    //똥코드 죄송.. 담에 시간 날때 수정할게요 ㅠㅠ 쏘리 캘린더 첨 커스텀해바
    private fun calender() {
        //이 라이브러리는 크기가 고정되어 있습니다!
        // 크기를 변경하려면 직접 지정  해맸어요!
        with(binding.calendarView) {
            doOnPreDraw {
                val cellHeight = resources.getDimension(R.dimen.day_cell_height).toInt()
                daySize = com.kizitonwose.calendarview.utils.Size(
                    binding.calendarView.width / 7,
                    cellHeight
                )
            }
        }
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
        val formattedDate = "${year}년 ${df.format(month)}월 ${df.format(dayOfMonth)}일"

        binding.tvDate.text = formattedDate
        binding.calendarView.setup(firstMonth, lastMonth, daysOfWeek.first())
        binding.calendarView.scrollToDate(LocalDate.now())
    }

    inner class DayViewContainer(view: View) : ViewContainer(view) {


        val df = DecimalFormat("00")

        val calendarBackGround = CalenderDayLayoutBinding.bind(view).calendarBackground
        var doneIcon = CalenderDayLayoutBinding.bind(view).doneIcon
        val dateText = CalenderDayLayoutBinding.bind(view).tvDate

        lateinit var day: CalendarDay
        var isSelected: Boolean = false

        init {
            view.setOnClickListener {
                // 날짜 선택 시 처리 정의
                isSelected = !isSelected
                val clickedDate =
                    "${day.date.year}년-${df.format(day.date.monthValue)}월-${df.format(day.date.dayOfMonth)}일"
                binding.tvDate.text = clickedDate
                if (isSelected) {
                    dateText.setTextColor(ContextCompat.getColor(dateText.context, R.color.white))
                    calendarBackGround.setBackgroundResource(R.drawable.background_calendar_check) // 선택되었을 때 배경 설정
                } else {
                    dateText.setTextColor(ContextCompat.getColor(dateText.context, R.color.gray_800))
                    calendarBackGround.background = null // 선택되지 않았을 때 배경 제거
                }
            }
        }

        fun bind(day: CalendarDay) {
            val currentDate = Calendar.getInstance()
            val dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH)
            this.day = day
            doneIcon.text = day.date.dayOfMonth.toString()
            dateText.text = convertToKoreanDayOfWeek(day.date.dayOfWeek)
            //오늘날짜 선택
            if (doneIcon.text == dayOfMonth.toString()) {
                isSelected = !isSelected
                dateText.setTextColor(ContextCompat.getColor(dateText.context, R.color.white))
                calendarBackGround.setBackgroundResource(R.drawable.background_calendar_check)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}



