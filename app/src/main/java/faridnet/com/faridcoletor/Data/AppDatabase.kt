package faridnet.com.faridcoletor.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import faridnet.com.faridcoletor.Model.Contagens
import faridnet.com.faridcoletor.Model.Inventario
import faridnet.com.faridcoletor.Model.Produtos

@Database(entities = [Contagens::class,
                     Produtos::class,
                     Inventario::class],
                     version = 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {

    abstract fun contagensDao(): ContagensDao
    abstract fun produtosDao(): ProdutosDao

    companion object{
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }

            //Evita concorrência das threads
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "contagem_database"
                ).build()
                INSTANCE = instance
                return instance

            }
        }

    }

}