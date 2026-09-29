package com.seuprojeto.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MainController {

    // Endpoint para fornecer informações dos vídeos hospedados (Canário e Pai Contra Mãe)
    @GetMapping("/videos")
    public ResponseEntity<Map<String, Object>> getVideosInfo() {
        Map<String, Object> response = new HashMap<>();
        
        Map<String, String> canario = new HashMap<>();
        canario.put("titulo", "Canário");
        canario.put("autor", "Machado de Assis");
        canario.put("descricao", "Conto filosófico sobre liberdade e existência.");
        canario.put("urlVideo", "https://www.w3schools.com/html/mov_bbb.mp4"); // Substitua pelo link real

        Map<String, String> paiContraMae = new HashMap<>();
        paiContraMae.put("titulo", "Pai Contra Mãe");
        paiContraMae.put("autor", "Machado de Assis");
        paiContraMae.put("descricao", "Crítica social e escravismo no Brasil Império.");
        paiContraMae.put("urlVideo", "https://www.w3schools.com/html/mov_bbb.mp4"); // Substitua pelo link real

        response.put("canario", canario);
        response.put("paiContraMae", paiContraMae);
        
        return ResponseEntity.ok(response);
    }

    // Endpoint de apoio para simular ou integrar a IA do quiz no backend caso deseje proteger chaves de API
    @PostMapping("/quiz/gerar")
    public ResponseEntity<Map<String, String>> gerarQuizBackend(@RequestBody Map<String, String> request) {
        String tema = request.getOrDefault("tema", "Canário");
        
        Map<String, String> resposta = new HashMap<>();
        resposta.put("status", "sucesso");
        resposta.put("mensagem", "Requisição recebida para o tema: " + tema);
        
        return ResponseEntity.ok(resposta);
    }
}