package id.ac.pnm.ti.utsmobilesatu.MainKt

import id.ac.pnm.ti.utsmobilesatu.Club.Club
import id.ac.pnm.ti.utsmobilesatu.Club.recap


fun main() {
    // Inisialisasi mutableList dan tambah data List
    val clubs= mutableListOf(Club("Liverpoll",19,8,9,6,3))
    clubs.add(Club("Man Utd", 20,12,6,3,1))
    clubs.add(Club("Chelsea", 6,6,2,3,2))
    clubs.add(Club("Man City", 8,8,8,0,0))
    clubs.add(Club("Arsenal", 13,14,2,0,0))

    // Passing a named function ::sortByNumberTrophyTotal
    val sortedClubs = filterAndSort(clubs, ::sortByNumberTrophyTotal)

    // Hasil sorting total trofi
    println("~".repeat(50))
    println("Urutan klub berdasarkan jumlah total trofi: ")
    println("~".repeat(50))
    for (club in sortedClubs) {
        println("${club.name}: ${club.totalTrophy} Tropi")
    }

    // Passing a named function ::filterByEuropeanTrophy
    val filteredClubs = filterAndSort(clubs,::filterByEuropeanTrophy)

    // Hasil sorting total trofi
    println("~".repeat(50))
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    println("~".repeat(50))
    for (club in filteredClubs) {
        println(club.name)
    }

    // Panggil extension function Club recap
    println("~".repeat(50))
    println("Recap Hasil Perolehan Tropi:")
    println("~".repeat(50))
    println("Nama CLub | EPl | FA | EFL | UCL | UEL |")
    println(clubs[0].recap())
    println(clubs[1].recap())
    println(clubs[2].recap())
    println(clubs[3].recap())
    println(clubs[4].recap())
}

// High order function filter and sort
fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}

// Fungsi sorting
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending {
        it.totalTrophy
    }
    return sortedClubs

}

// Fungsi filter
fun filterByEuropeanTrophy(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter {
        it.UCL == 0 && it.UEL == 0
    }
    return filteredClubs
}