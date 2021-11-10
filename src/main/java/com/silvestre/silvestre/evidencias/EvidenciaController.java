package com.silvestre.silvestre.evidencias;


import com.silvestre.silvestre.denuncias.Denuncia;
import com.silvestre.silvestre.denuncias.DenunciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evidencias")
@AllArgsConstructor
public class EvidenciaController {

    private static String caminhoImagens = "D:\\Felipe\\Documents\\SilvestreDenuncia";

    @Autowired
    EvidenciaRepository repository;

    @GetMapping("/retornaTodos")
    List<Evidencia> todosEvidencias(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Evidencia> retornaEvidencia(@PathVariable Long id) {
        return repository.findById(id);
    }

//    @PostMapping("/novo")
//    Evidencia novaEvidencia(@RequestBody Evidencia evidencia, @RequestParam("file")MultipartFile arquivo)) {
//        return repository.save(evidencia);
//
//        try{
//            if(!arquivo.isEmpty()){
//                byte[] bytes = arquivo.getBytes();
//                Path caminho = Paths.get(caminhoImagens+arquivo.getOriginalFilename());
//                Files.write(caminho, bytes);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

    @PutMapping("/{id}")
    Evidencia atualizaEvidencia(@RequestBody Evidencia evidencia, @PathVariable Long id){
        evidencia.setId(id);
        return repository.save(evidencia);
    }

    @DeleteMapping("/deleta/{id}")
    void deleteEvidencia(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
