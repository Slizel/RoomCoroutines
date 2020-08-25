package faridnet.com.faridcoletor.Repository

import androidx.lifecycle.LiveData
import faridnet.com.faridcoletor.Data.InventarioDao
import faridnet.com.faridcoletor.Model.Inventario
import faridnet.com.faridcoletor.Model.Produtos

class InventarioRepository (private val inventarioDao: InventarioDao) {

    val readAllData: LiveData<List<Produtos>> = inventarioDao.readAllData()

    suspend fun addInventario(inventario: Inventario){
        inventarioDao.addInventario(inventario)
    }

    suspend fun deleteAllInventarios(){
        inventarioDao.deleteAllInventarios()
    }

    suspend fun deleteProdutos(inventario: Inventario){
        inventarioDao.deleteInventario(inventario)
    }

}