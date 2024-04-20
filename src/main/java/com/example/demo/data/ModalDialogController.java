package com.example.demo.data;

import com.example.demo.model.RowData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ModalDialogController {

    private List<RowData> lastSavedData = new ArrayList<>();

    @GetMapping("/saved-data")
    public ResponseEntity<List<RowData>> getSavedData() {
        return ResponseEntity.ok(lastSavedData);
    }

    @PostMapping("/save-modal-data")
    public ResponseEntity<String> saveModalData(@RequestBody List<RowData> rows) {
        this.lastSavedData = rows; // Update last saved data
        System.out.println("Data saved successfully: " + rows);
        return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
    }
}