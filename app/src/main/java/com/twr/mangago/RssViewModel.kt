package com.twr.mangago

import androidx.lifecycle.*
import com.twr.mangago.db.Rss
import com.twr.mangago.db.RssRepository
import kotlinx.coroutines.launch

class RssViewModel(private val repository: RssRepository):ViewModel() {
    val allRss: LiveData<List<Rss>> = repository.allRss.asLiveData()

    fun insert(rss: Rss) = viewModelScope.launch {
        repository.insert(rss)
    }

}

class RssViewModelFactory(private val repository: RssRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RssViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return RssViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}