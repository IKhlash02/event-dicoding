package com.example.core.domain.usecase




import com.example.core.domain.model.Event
import com.example.core.domain.repository.IEventRepository
import javax.inject.Inject

class EventInteractor @Inject constructor(private val eventRepository: IEventRepository): EventUseCase {

    override fun getAllEvent() = eventRepository.getAllEvent()
    override fun getFavorite() = eventRepository.getFavoriteEvent()

    override fun insertFavoriteEvent(event: Event) = eventRepository.insertFavoriteEvent(event)
    override fun deleteFavoriteEvent(event: Event) = eventRepository.deleteFavoriteEvent(event)

    override fun getFavoriteEventByid(id: Int) = eventRepository.getFavoriteEventByid(id)


}