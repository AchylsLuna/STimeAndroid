package api

data class ScholarSelectionRequest(
    val student_id: String,
    val duty_status: String,
    val scholar_type: String,
    val course: String,
    val year_level: String
)