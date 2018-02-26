package com.shikherverma.todayontv.data.remote

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.shikherverma.todayontv.model.DayOfWeek
import java.lang.reflect.Type
import java.util.*

/**
 * Used by Gson to convert Json array of strings to EnumSet<DayOfWeek>
 */
class DaysOfWeekDeserializer : JsonDeserializer<EnumSet<DayOfWeek>> {

    /**
     * Gson invokes this call-back method during deserialization when it encounters a field of the
     * specified type.
     *
     * @param json The Json data being deserialized
     * @param typeOfT The type of the Object to deserialize to
     * @return a deserialized object of the specified type typeOfT
     * @throws JsonParseException if json is not in the expected format of {@code typeofT}
     */
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): EnumSet<DayOfWeek> {
        val listType = object : TypeToken<List<String>>() {}.type
        val listOfDayOfWeek: List<String> = Gson().fromJson(json, listType)
        if (listOfDayOfWeek.isEmpty())
            return EnumSet.noneOf(DayOfWeek::class.java)
        return EnumSet.copyOf(listOfDayOfWeek.map { it -> DayOfWeek.parse(it) })
    }
}
