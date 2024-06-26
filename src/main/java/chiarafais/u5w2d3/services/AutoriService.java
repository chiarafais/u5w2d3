package chiarafais.u5w2d3.services;

import chiarafais.u5w2d3.entities.Autore;
import chiarafais.u5w2d3.exceptions.NotFoundException;
import chiarafais.u5w2d3.repositories.AutoriDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutoriService {
    @Autowired
    private AutoriDAO autoreRepository;

    public List<Autore> getAutoriList() {
        return autoreRepository.findAll();
    }

    public Page<Autore> getAutori(int page, int size, String sortBy){
        if(size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.autoreRepository.findAll(pageable);
    }

    public Autore saveAutore(Autore body) {
        return autoreRepository.save(body);
    }

    public Autore findById(int id) {
        return autoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Autore findByIdAndUpdate(int id, Autore updatedAutore) {
        Autore found = findById(id);
        found.setNome(updatedAutore.getNome());
        found.setCognome(updatedAutore.getCognome());
        return autoreRepository.save(found);
    }

    public void findByIdAndDelete(int authorId) {
        autoreRepository.deleteById(authorId);
    }
}
