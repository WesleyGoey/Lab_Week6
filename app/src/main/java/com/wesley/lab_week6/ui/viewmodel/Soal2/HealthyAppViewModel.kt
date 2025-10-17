package com.wesley.lab_week6.ui.viewmodel.Soal2

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import com.wesley.lab_week6.ui.model.Soal2.User
import com.wesley.lab_week6.ui.model.Soal2.UserResource
import com.wesley.lab_week6.ui.model.Soal2.Workout
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList

class HealthyAppViewModel : ViewModel() {
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users.asStateFlow()

    private val _myFriends = MutableStateFlow<List<User>>(emptyList())
    val myFriends: StateFlow<List<User>> = _myFriends.asStateFlow()
    private val _workouts = MutableStateFlow<List<Workout>>(emptyList())
    val workouts: StateFlow<List<Workout>> = _workouts.asStateFlow()

    private val _myWorkouts = MutableStateFlow<List<Workout>>(emptyList())
    val myWorkouts: StateFlow<List<Workout>> = _myWorkouts.asStateFlow()

    private val _user = MutableStateFlow(UserResource.user)
    val user: StateFlow<User> = _user.asStateFlow()

    init {
        loadFriend()
    }

    fun loadFriend() {
        _users.value = UserResource.friends.toList()
    }

    fun toggleAddWorkout(workout: Workout) {
        val newWorkouts = _workouts.value.map { currentWorkout ->
            if (currentWorkout.name == workout.name) {
                currentWorkout.copy(isCompleted = !currentWorkout.isCompleted)
            } else {
                currentWorkout
            }
        }
        _workouts.value = newWorkouts
        _myWorkouts.value = newWorkouts.filter { it.isCompleted }

        val currentWorkoutCount = _user.value.workoutCount
        val updatedProfile = _user.value.copy(
            workoutCount = if (workout.isCompleted) {
                currentWorkoutCount - 1
            } else {
                currentWorkoutCount + 1
            }
        )
        _user.value = updatedProfile
    }

    fun toggleAddFriend(user: User) {
        val newFriendList = _users.value.map { friendInList ->
            if (friendInList.name == user.name) {
                friendInList.copy(isFriend = !friendInList.isFriend)
            } else {
                friendInList
            }
        }
        _users.value = newFriendList
        _myFriends.value = newFriendList.filter { it.isFriend }

        val currentFriendCount = _user.value.friendCount
        val updatedProfile = _user.value.copy(
            friendCount = if (user.isFriend) {
                currentFriendCount - 1
            } else {
                currentFriendCount + 1
            }
        )
        _user.value = updatedProfile
    }

    fun saveWorkoutForm(title: String, type: String, calories: Int, icon: ImageVector) {
        val newWorkout = Workout(
            name = title,
            description = type,
            caloriesBurned = calories,
            icon = icon,
            isCompleted = false
        )
        _workouts.value = _workouts.value + newWorkout
    }
}