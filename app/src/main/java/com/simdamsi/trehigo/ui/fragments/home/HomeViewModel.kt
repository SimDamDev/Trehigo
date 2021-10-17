package com.simdamsi.trehigo.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simdamsi.trehigo.R
import com.simdamsi.trehigo.models.Menu
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val listMenu = MutableLiveData<List<Menu>>()

    fun getListMenu(): LiveData<List<Menu>> {
        listMenu.value = listOf(
            Menu(1, "Sommets", R.color.fortunaGold),
            Menu(2, "???", R.color.fortunaGold),
            Menu(3, "???", R.color.fortunaGold),
            Menu(4, "???", R.color.fortunaGold)
        )
        return listMenu
    }
}
