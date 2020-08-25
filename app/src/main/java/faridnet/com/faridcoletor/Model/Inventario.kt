package faridnet.com.faridcoletor.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "inventrio_table")
data class Inventario(

    @PrimaryKey(autoGenerate = true)
    val inventarioId: Int,
    val numeroInventario: Int,
    val numeroContagem: Int

): Parcelable



