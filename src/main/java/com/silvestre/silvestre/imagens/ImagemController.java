package com.silvestre.silvestre.imagens;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/imagens")
public class ImagemController {
	
	private static final String caminhoImagens = "C:\\z_Aps_SilvestreDenuncia_Imagens\\";
	
	@Autowired
	private ImagemRepository repository;
	
	@PostMapping(value = "/novo", consumes = {
		MediaType.APPLICATION_JSON_VALUE,
		MediaType.MULTIPART_FORM_DATA_VALUE})    
    public Imagem novaImagem(
    		@RequestPart("imagem") String imagem,
    		@RequestPart("file") MultipartFile arquivo) {
		
		Imagem imagemJson = new Imagem();				
		ObjectMapper objectMapper = new ObjectMapper();
		
		try {
			imagemJson = objectMapper.readValue(imagem, Imagem.class);
		} catch (JsonMappingException e1) {
			e1.printStackTrace();
		} catch (JsonProcessingException e1) { 
			e1.printStackTrace();
		}
		
		imagemJson.setNome(arquivo.getOriginalFilename());
		repository.save(imagemJson);
		
		try {
			if(!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoImagens + String.valueOf(imagemJson.getId()) + arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				
				imagemJson.setNome(String.valueOf(imagemJson.getId()) + "_" +  arquivo.getOriginalFilename());				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return imagemJson;        
    }

}
