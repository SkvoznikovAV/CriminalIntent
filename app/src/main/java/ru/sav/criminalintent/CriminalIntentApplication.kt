package ru.sav.criminalintent

import android.app.Application
import ru.sav.criminalintent.database.CrimeRepository

class CriminalIntentApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
    }
}