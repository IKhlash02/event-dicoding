package com.example.capstone1.core.utils

import com.example.capstone1.core.data.source.local.entity.EventEntity
import com.example.capstone1.core.data.source.remote.response.EventResponse
import com.example.capstone1.core.domain.model.Event

object DataMapper {
    fun mapResponsesToDomain(input: List<EventResponse>): List<Event> {
        val eventList = ArrayList<Event>()
        input.map {
            val event = Event(
                summary = it.summary,
                mediaCover = it.mediaCover,
                registrants = it.registrants,
                imageLogo = it.imageLogo,
                link = it.link,
                description = it.description,
                ownerName = it.ownerName,
                cityName = it.cityName,
                quota = it.quota,
                name = it.name,
                id = it.id,
                beginTime = it.beginTime,
                endTime = it.endTime,
                category = it.category
            )
            eventList.add(event)
        }
        return eventList
    }

    fun mapEntityToDomain(input: List<EventEntity>): List<Event> {
        val eventList = ArrayList<Event>()
        input.map {
            val event = Event(
                summary = it.summary,
                mediaCover = it.mediaCover,
                registrants = it.registrants,
                imageLogo = it.imageLogo,
                link = it.link,
                description = it.description,
                ownerName = it.ownerName,
                cityName = it.cityName,
                quota = it.quota,
                name = it.name,
                id = it.id,
                beginTime = it.beginTime,
                endTime = it.endTime,
                category = it.category
            )
            eventList.add(event)
        }
        return eventList
    }



    fun mapDomainToEntity(input: Event) = EventEntity(
        summary = input.summary,
        mediaCover = input.mediaCover,
        registrants = input.registrants,
        imageLogo = input.imageLogo,
        link = input.link,
        description = input.description,
        ownerName = input.ownerName,
        cityName = input.cityName,
        quota = input.quota,
        name = input.name,
        id = input.id,
        beginTime = input.beginTime,
        endTime = input.endTime,
        category = input.category
    )

    fun mapSingleEntityToDomain(input: EventEntity) = Event(
        summary = input.summary,
        mediaCover = input.mediaCover,
        registrants = input.registrants,
        imageLogo = input.imageLogo,
        link = input.link,
        description = input.description,
        ownerName = input.ownerName,
        cityName = input.cityName,
        quota = input.quota,
        name = input.name,
        id = input.id,
        beginTime = input.beginTime,
        endTime = input.endTime,
        category = input.category
    )
}