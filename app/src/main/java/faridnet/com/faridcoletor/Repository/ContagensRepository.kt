package faridnet.com.faridcoletor.Repository

import androidx.lifecycle.LiveData
import faridnet.com.faridcoletor.Data.ContagensDao
import faridnet.com.faridcoletor.Model.Contagens

class ContagensRepository(private val contagensDao: ContagensDao) {

    val readAllData: LiveData<List<Contagens>> = contagensDao.readAllData()

    suspend fun addContagem(contagens: Contagens){
        contagensDao.addContagem(contagens)
    }

    suspend fun deleteAllContagens(){
        contagensDao.deleteAllContagens()
    }

    suspend fun deleteContagens(contagens: Contagens) {
        contagensDao.deleteContagens(contagens)

    }

    suspend fun updateContagens(contagens: Contagens){
        contagensDao.updateContagem(contagens)

    }


}