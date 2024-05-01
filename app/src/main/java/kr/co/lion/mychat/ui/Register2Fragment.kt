package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.mychat.MainActivity
import kr.co.lion.mychat.databinding.FragmentRegister2Binding
import kr.co.lion.mychat.utils.FragmentName

class Register2Fragment : Fragment() {

    lateinit var binding: FragmentRegister2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegister2Binding.inflate(inflater)

        settingToolbar()
        settingButton()

        return binding.root
    }

    private fun settingToolbar(){
        with(binding){
            toolbarRegister2.apply {
                setNavigationIcon(com.google.android.material.R.drawable.ic_arrow_back_black_24)
                setNavigationOnClickListener {
                    (activity as MainActivity).removeFragment(FragmentName.REGISTER2_FRAGMENT)
                }
            }
        }
    }

    private fun settingButton(){
        with(binding){
            // 건너뛰기
            buttonSkip.setOnClickListener {
                skipRegister2()
            }

            // 다음 버튼
            buttonLoginSubmit.setOnClickListener {
                submitRegister2()
            }
        }
    }

    private fun checkEmpty(): Boolean{
        return false
    }

    private fun skipRegister2(){
        (activity as MainActivity).replaceFragment(FragmentName.REGISTER_COMPLETE_FRAGMENT, true, true, null)
    }

    private fun submitRegister2(){
        checkEmpty()
        (activity as MainActivity).replaceFragment(FragmentName.REGISTER_COMPLETE_FRAGMENT, true, true, null)
    }

}