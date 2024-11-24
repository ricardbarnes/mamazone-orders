package cat.vonblum.mamazone.orders.shared.infrastructure.store.postgres

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class PostgresIntListToStringConverter : AttributeConverter<List<Int>, String> {

    override fun convertToDatabaseColumn(attribute: List<Int>?): String {
        return attribute?.joinToString(",") ?: ""
    }

    override fun convertToEntityAttribute(dbData: String?): List<Int> {
        return dbData?.split(",")?.mapNotNull { it.toIntOrNull() } ?: emptyList()
    }

}