package com.example.demo.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entities.Comic;
import com.example.demo.domain.entities.Venta;
import com.example.demo.infraestructure.comicRepository;
import com.example.demo.infraestructure.ventaRepository;

@Service
public class ventaService {
    @Autowired
    private ventaRepository ventaRepository;

    @Autowired
    private comicRepository comicRepository;

    public Venta RegistrarVenta(Venta venta){
        List<Comic> comics = new ArrayList<>(venta.getComics());
        for(Comic addComic: comics){
            enrollVentaInComic(addComic.getId(), venta.getId());
        }
        return ventaRepository.save(venta);
    }
    public void enrollVentaInComic(Long comicId, Long ventaId) {
        Comic comic = comicRepository.findById(comicId).get();
        Venta venta = ventaRepository.findById(ventaId).get();
        Set<Venta> ventas = comic.getVendido();     
        ventas.add(venta);
        comic.setVendido(ventas);
        comicRepository.save(comic);    
    }   
}
