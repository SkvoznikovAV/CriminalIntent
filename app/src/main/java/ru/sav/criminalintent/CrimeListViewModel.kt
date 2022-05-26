package ru.sav.criminalintent

import androidx.lifecycle.ViewModel
import ru.sav.criminalintent.database.CrimeRepository

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimes = crimeRepository.getCrimes()
}