package miguel.insua.loveArt.modules.siEmail


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.etEmail
import kotlinx.android.synthetic.main.fragment_login.etPassword
import kotlinx.android.synthetic.main.fragment_si_email.*
import miguel.insua.loveArt.R
import miguel.insua.loveArt.databinding.FragmentSiEmailBinding
import miguel.insua.loveArt.modules.base.BaseFragment
import miguel.insua.loveArt.modules.home.HomeActivity
import miguel.insua.loveArt.modules.main.MainActivity
import miguel.insua.loveArt.modules.start.StartFragment


class SiEmailFragment : BaseFragment<SiEmailViewModel, FragmentSiEmailBinding>(
    SiEmailViewModel::class.java
) {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_si_email
    }

    override fun viewCreated(view: View?) {
        mBinding.viewModel = viewModel
        viewModel.ejemplo = ::ejemplo
        viewModel.back = ::back
    }


    private fun ejemplo() {
        var ok = !(etEmail.text.toString().equals("") || etPassword.text.toString().equals("") || etConfirmPassword.text.toString().equals(""))
        if (ok) {
            if (!etPassword.text.toString().equals(etConfirmPassword.text.toString())) {
                ok = false
            }
        }
        if (ok) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                etEmail.text.toString(),
                etPassword.text.toString()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    ok = true
                } else {
                    showAlert()
                }
            }
            if (ok) {
                val intent = Intent(activity?.applicationContext, HomeActivity::class.java).apply {
                    putExtra("email", etEmail.text)
                    putExtra("password", etPassword.text)
                }
                navigator.navigateToActivity(intent, Bundle())
            }
        }
    }

    private fun back() {
        navigator.navigate(StartFragment(), false, StartFragment().LOG_TAG, container = R.id.fragmentContainerMain)
    }

    private fun showAlert() {
        Toast.makeText(activity?.applicationContext, "ERROR", Toast.LENGTH_LONG)
    }
}
