package com.natifedanilharitonov.hardskillsproject.domain.info

import com.natifedanilharitonov.hardskillsproject.core.UseCase
import com.natifedanilharitonov.hardskillsproject.data.repository.firebase.FirebaseUserRepository
import com.natifedanilharitonov.hardskillsproject.data.repository.recourses.RecoursesInfoRepository
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoEvent
import com.natifedanilharitonov.hardskillsproject.presentation.info.InfoState

class GetUserInfoUseCase(
    private val repository: FirebaseUserRepository,
    private val recoursesRepository: RecoursesInfoRepository
) : UseCase<InfoState, InfoEvent> {
    override suspend fun execute(state: InfoState, event: InfoEvent): InfoEvent {
        return if (event is InfoEvent.GetUserInfoEvent) {
            val email = repository.getUser()?.email
            if (email != null) {
                InfoEvent.UserDataEventIsReceived(email = email)
            } else InfoEvent.UserDataEventIsReceived(email = recoursesRepository.getUnauthorizedText())
        } else InfoEvent.ErrorEvent
    }

    override fun canHandle(event: InfoEvent): Boolean {
        return event is InfoEvent.GetUserInfoEvent
    }
}