package id.ac.pnm.ti.utsmobilesatu.Club

// data class Club
data class Club(
    val name: String,
    val EPL: Int,
    val FAcup: Int,
    val EFL: Int,
    val UCL: Int,
    val UEL: Int,
) {
    val totalTrophy: Int
        get() = EPL +  FAcup +EFL+ UCL + UEL
}

// extension function recap
fun Club.recap(): String {
    return "${this.name} | ${this.EPL} | ${this.FAcup} | " +
            "${this.EFL} | ${this.UCL} | ${this.UEL} |"
}