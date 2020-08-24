package ak.www.kursakademiaandroida.utils

import androidx.arch.core.executor.TaskExecutor

object FakeMainThreadExecutor : TaskExecutor() {
    override fun executeOnDiskIO(runnable: Runnable) = runnable.run()

    override fun isMainThread(): Boolean = true

    override fun postToMainThread(runnable: Runnable) = runnable.run()
}