package com.example.etudiants.pojo

data class EtuItem(
	val image: String? = null,
	val firstname: String? = null,
	val id: Int? = null,
	val age: String? = null,
	val lastname: String? = null
) {
	override fun toString(): String {
		return "($id) $firstname $lastname $age\n"
	}
}

