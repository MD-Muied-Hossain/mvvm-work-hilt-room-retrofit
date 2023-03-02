package com.example.test2movie.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class MyWorker@AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters
) : Worker(context,workerParameters)
{
    override fun doWork(): Result {
        Log.d(TAG, "doWork: Started")
        return Result.success()
    }
    companion object{
        const val TAG = "worker Class"
    }
}