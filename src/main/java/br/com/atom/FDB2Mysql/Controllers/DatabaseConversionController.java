package br.com.atom.FDB2Mysql.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atom.FDB2Mysql.DatabaseConversionService;

@RestController
@RequestMapping("/api/database")
public class DatabaseConversionController {

    @Autowired
    private DatabaseConversionService conversionService;

    @PostMapping("/convert")
    public ResponseEntity<String> convertDatabase() {
        String firebirdBackupFilePath = "/caminho/para/backup_fb.sql";
        conversionService.convertFirebirdToMySQL(firebirdBackupFilePath);
        return ResponseEntity.ok("Conversão iniciada com sucesso.");
    }
}