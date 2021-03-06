package ru.sav.criminalintent.database

import android.content.Context
import androidx.room.Room
import ru.sav.criminalintent.Crime
import java.util.*

private const val DATABASE_NAME = "crime_database"

class CrimeRepository private constructor(context: Context){

    private val database: CrimeDataBase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDataBase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): List<Crime> = crimeDao.getCrimes()

    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)

    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context){
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository{
            return INSTANCE ?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}