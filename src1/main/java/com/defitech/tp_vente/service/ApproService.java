package com.defitech.tp_vente.service;

import com.defitech.tp_vente.modele.Appro;
import com.defitech.tp_vente.repository.ApproRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApproService {
    @Autowired
    private ApproRepository approRepository;

    public void saveAppro(Appro appro) {approRepository.save(appro);
    }

    public List<Appro> showAllAppro() {return approRepository.findAll();
    }
    public Appro showOneAppro(int id){
        return approRepository.findById(id).get();
    }
    public void deleteAppro(int id){
        approRepository.deleteById(id);
    }

    public List<Appro> findByQuantiteApr(int qteAppro){
        return approRepository.findByQuant(qteAppro);
    }
}
