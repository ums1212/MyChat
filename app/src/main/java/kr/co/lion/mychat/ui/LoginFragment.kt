package kr.co.lion.mychat.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.co.lion.mychat.MainActivity
import kr.co.lion.mychat.R
import kr.co.lion.mychat.databinding.FragmentLoginBinding
import kr.co.lion.mychat.utils.FragmentName

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater)

        settingToolbar()
        settingButton()

        return binding.root
    }

    private fun settingToolbar(){
        with(binding){
            toolbarLogin.apply {
                setNavigationIcon(com.google.android.material.R.drawable.ic_arrow_back_black_24)
                setNavigationOnClickListener {
                    (activity as MainActivity).removeFragment(FragmentName.LOGIN_FRAGMENT)
                }
            }
        }
    }

    private fun settingButton(){
        with(binding){
            // 로그인 버튼
            loginButton.setOnClickListener {
                if(checkLogin()) return@setOnClickListener
                (activity as MainActivity).removeFragment(FragmentName.LOGIN_FRAGMENT)
                (activity as MainActivity).removeFragment(FragmentName.ENTER_FRAGMENT)
                (activity as MainActivity).replaceFragment(FragmentName.MAIN_FRAGMENT, false, true, null)
            }

            // 회원가입 버튼
            loginRegisterButton.setOnClickListener {
                (activity as MainActivity).removeFragment(FragmentName.LOGIN_FRAGMENT)
                (activity as MainActivity).replaceFragment(FragmentName.REGISTER_FRAGMENT, true, true, null)
            }
            // 비밀번호 찾기 버튼
            findPasswordButton.setOnClickListener {

            }

            // 구글 계정 버튼
            loginButtonGoogle.setOnClickListener {

            }

            // 네이버 계정 버튼
            loginButtonNaver.setOnClickListener {

            }

            // 카카오 계정 버튼
            loginButtonKakao.setOnClickListener {

            }
        }
    }

    private fun checkLogin():Boolean{
        var result = false
        with(binding){
            if(textInputPhone.text.isNullOrEmpty()){
                textInputPhone.error = "핸드폰 번호를 입력해주세요"
                result = true
            }
            if(textInputPassword.text.isNullOrEmpty()){
                textInputPassword.error = "비밀번호를 입력해주세요"
                result = true
            }
        }
        return result
    }
}