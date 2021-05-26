package miguel.insua.loveArt.modules.lists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import miguel.insua.loveArt.model.User_List

class Repo {

    private val auth = FirebaseAuth.getInstance()

    private val db = FirebaseFirestore.getInstance()

    fun getUserListData():LiveData<MutableList<String>> {
        val mutableData = MutableLiveData<MutableList<String>>()
        val user = auth.currentUser
        if (user != null) {
            db.collection("users").document(user.uid).collection("lists")
                .get().addOnSuccessListener { result ->
                    val userLists: MutableList<String> = mutableListOf<String>()
                    for (document in result) {
                        val nameList: String? = document.getString("name")
                        userLists.add(nameList.toString())
                    }
                    mutableData.value = userLists
                }
        }
        return mutableData
    }
}