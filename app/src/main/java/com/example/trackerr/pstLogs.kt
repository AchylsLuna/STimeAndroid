package com.example.trackerr

import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class pstLogs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pastlogs) // Ensure this is the correct layout

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)

        // Get passed data
        val date = intent.getStringExtra("DATE")
        val timeIn = intent.getStringExtra("TIME_IN")
        val timeOut = intent.getStringExtra("TIME_OUT")

        if (!date.isNullOrEmpty() && !timeIn.isNullOrEmpty() && !timeOut.isNullOrEmpty()) {
            addRow(tableLayout, date, timeIn, timeOut)
        }
    }

    private fun addRow(tableLayout: TableLayout, date: String, timeIn: String, timeOut: String) {
        val tableRow = TableRow(this)

        val dateView = TextView(this).apply {
            text = date
            setPadding(8, 8, 8, 8)
        }

        val timeInView = TextView(this).apply {
            text = timeIn
            setPadding(8, 8, 8, 8)
        }

        val timeOutView = TextView(this).apply {
            text = timeOut
            setPadding(8, 8, 8, 8)
        }

        tableRow.addView(dateView)
        tableRow.addView(timeInView)
        tableRow.addView(timeOutView)

        tableLayout.addView(tableRow)
    }
}
