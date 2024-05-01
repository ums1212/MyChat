package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kr.co.lion.mychat.MainActivity
import kr.co.lion.mychat.databinding.FragmentRegisterBinding
import kr.co.lion.mychat.utils.FragmentName


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater)

        settingToolbar()
        settingButton()

        return binding.root
    }

    private fun settingToolbar(){
        with(binding){
            toolbarRegister.apply {
                setNavigationIcon(com.google.android.material.R.drawable.ic_arrow_back_black_24)
                setNavigationOnClickListener {
                    (activity as MainActivity).removeFragment(FragmentName.REGISTER_FRAGMENT)
                }
            }
        }
    }

    private fun settingButton(){
        with(binding){
            // 문자 인증 호출
            buttonAuth.setOnClickListener {
                smsAuth()
            }

            // 인증 번호 확인
            buttonCheckAuth.setOnClickListener {
                checkSmsAuth()
            }

            // 닉네임 중복 확인
            textViewCheckNickname.setOnClickListener {
                checkNicknameDup()
            }

            // 다음 버튼
            buttonLoginSubmit.setOnClickListener {
                submitNext()
            }
        }
    }

    private fun smsAuth(){
        val toast = Toast.makeText(requireActivity(), "문자 인증", Toast.LENGTH_SHORT)
        toast.show()
        with(binding){
            layoutAuth.visibility = View.VISIBLE
        }
    }

    private fun checkSmsAuth(){
        val toast = Toast.makeText(requireActivity(), "인증 번호 확인", Toast.LENGTH_SHORT)
        toast.show()
    }

    private fun checkEmpty(): Boolean{
        return false
    }

    private fun checkNicknameDup(): Boolean{
        val toast = Toast.makeText(requireActivity(), "닉네임 중복 확인", Toast.LENGTH_SHORT)
        toast.show()
        return false
    }

    private fun submitNext(){
        checkEmpty()
        (activity as MainActivity).replaceFragment(FragmentName.REGISTER2_FRAGMENT, true, true, null)
    }

}