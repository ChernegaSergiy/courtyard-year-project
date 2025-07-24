package com.courtyardyearproject

import android.content.ContentValues
import android.content.Context
import android.os.Environment
import android.provider.MediaStore
import java.io.OutputStreamWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object FileLogger {

    private const val LOG_FILE = "courtyard_year_project.log"

    fun log(context: Context, tag: String, message: String) {
        try {
            val resolver = context.contentResolver

            val logDir = "Documents/CourtyardYearProjectLogs"

            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, LOG_FILE)
                put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
                put(MediaStore.MediaColumns.RELATIVE_PATH, logDir)
            }

            val queryUri = MediaStore.Files.getContentUri("external")
            val selection = "${MediaStore.MediaColumns.RELATIVE_PATH}=? AND ${MediaStore.MediaColumns.DISPLAY_NAME}=?"
            val selectionArgs = arrayOf("$logDir/", LOG_FILE)

            var uri = resolver.query(queryUri, null, selection, selectionArgs, null)?.use { cursor ->
                if (cursor.moveToFirst()) {
                    val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.MediaColumns._ID))
                    MediaStore.Files.getContentUri("external", id)
                } else {
                    null
                }
            }

            if (uri == null) {
                uri = resolver.insert(queryUri, contentValues)
            }

            uri?.let {
                resolver.openOutputStream(it, "wa")?.use { outputStream ->
                    OutputStreamWriter(outputStream).use { writer ->
                        val timestamp = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US).format(Date())
                        writer.append("$timestamp $tag: $message\n")
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}