package faridnet.com.faridcoletor.Data

import androidx.lifecycle.LiveData
import androidx.room.*
import faridnet.com.faridcoletor.Model.Contagens

@Dao
interface ContagensDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContagem(contagens: Contagens)

    @Update
    suspend fun updateContagem(contagens: Contagens)

    // Deleta somente 1 linha
    @Delete
    suspend fun deleteContagens(contagens: Contagens)

    @Query("DELETE FROM contagem_table")
    suspend fun deleteAllContagens()


    @Query("SELECT * FROM contagem_table ORDER BY produtoId ASC")
    fun readAllData(): LiveData<List<Contagens>>

    @Query("SELECT * FROM contagem_table ORDER BY produtoId ASC")
    fun readAllInfo(): List<Contagens>


    @get:Query("SELECT * FROM contagem_table")
    val allContagens: List<Contagens>



}