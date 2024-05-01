package kr.co.lion.mychat.ui

import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.transition.MaterialSharedAxis
import kr.co.lion.mychat.R
import kr.co.lion.mychat.databinding.FragmentMainBinding
import kr.co.lion.mychat.utils.FragmentName

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding

    // 프래그먼트 객체를 담을 변수
    var oldMainFragment: Fragment? = null
    var newMainFragment: Fragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentMainBinding.inflate(inflater)

        settingTabLayout()
        replaceFragment(FragmentName.CHAT_LIST_FRAGMENT, false, false, null)

        return binding.root
    }

    private fun settingTabLayout(){
        binding.tabLayoutMain.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    when(tab.position){
                        0 -> {
                            replaceFragment(FragmentName.CHAT_LIST_FRAGMENT, false, false, null)
                        }

                        1 ->{
                            replaceFragment(FragmentName.MYPAGE_FRAGMENT, false, false, null)
                        }
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    fun replaceFragment(name: FragmentName, addToBackStack:Boolean, isAnimate:Boolean, data:Bundle?){
        SystemClock.sleep(200)

        val fragmentTransaction = childFragmentManager.beginTransaction()

        if(newMainFragment != null){
            oldMainFragment = newMainFragment
        }

        newMainFragment = when(name){
            FragmentName.ENTER_FRAGMENT -> { EnterFragment() }
            FragmentName.LOGIN_FRAGMENT -> { LoginFragment() }
            FragmentName.REGISTER_FRAGMENT -> { RegisterFragment() }
            FragmentName.REGISTER2_FRAGMENT -> { Register2Fragment() }
            FragmentName.REGISTER_COMPLETE_FRAGMENT -> { RegisterCompleteFragment() }
            FragmentName.MAIN_FRAGMENT -> { MainFragment() }
            FragmentName.CHAT_LIST_FRAGMENT -> { ChatListFragment() }
            FragmentName.CHATTING_FRAGMENT -> { ChattingFragment() }
            FragmentName.MYPAGE_FRAGMENT -> { MypageFragment() }
        }

        if(data != null){
            newMainFragment?.arguments = data
        }

        if(newMainFragment != null){
            if(isAnimate){
                // MaterialSharedAxis : 좌우, 위아래, 공중 바닥 사이로 이동하는 애니메이션 효과
                // X - 좌우
                // Y - 위아래
                // Z - 공중 바닥
                // 두 번째 매개변수 : 새로운 화면이 나타나는 것인지 여부를 설정
                // true : 새로운 화면이 나타나는 애니메이션이 동작한다.
                // false : 이전으로 되돌아가는 애니메이션이 동작한다.
                if(oldMainFragment != null){
                    // old에서 new가 새롭게 보여질 때 old의 애니메이션
                    oldMainFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
                    // new에서 old로 되돌아갈 때 old의 애니메이션
                    oldMainFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

                    oldMainFragment?.enterTransition = null
                    oldMainFragment?.returnTransition = null
                }

                // old에서 new가 새롭게 보여질 때 new의 애니메이션
                newMainFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true)
                // new에서 old로 되돌아갈 때의 애니메이션
                newMainFragment?.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, false)

                newMainFragment?.exitTransition = null
                newMainFragment?.reenterTransition = null
            }

            fragmentTransaction.replace(R.id.fragmentContainerViewMain, newMainFragment!!)

            if(addToBackStack == true){
                fragmentTransaction.addToBackStack(name.str)
            }

            fragmentTransaction.commit()
        }
    }

}