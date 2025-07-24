package com.courtyardyearproject

import android.os.Environment
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileLogger {

    private const val LOG_DIRECTORY = "logs"
    private const val LOG_FILE = "courtyard_year_project.log"

    fun log(tag: String, message: String) {
        try {
            val logDir = File(Environment.getExternalStorageDirectory(), LOG_DIRECTORY)
            if (!logDir.exists()) {
                logDir.mkdirs()
            }
            val logFile = File(logDir, LOG_FILE)
            val writer = FileWriter(logFile, true)
            val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(Date())
            writer.append("$timestamp $tag: $message\n")
            writer.flush()
            writer.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
