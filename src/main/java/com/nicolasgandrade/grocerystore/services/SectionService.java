package com.nicolasgandrade.grocerystore.services;

import com.nicolasgandrade.grocerystore.domain.Section;
import com.nicolasgandrade.grocerystore.dto.SectionDTO;
import com.nicolasgandrade.grocerystore.repositories.SectionRepository;
import com.nicolasgandrade.grocerystore.services.exceptions.DatabaseException;
import com.nicolasgandrade.grocerystore.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public Section findById(Integer id) {
        Optional<Section> obj = sectionRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException("Object not found"));
    }

    public Section insert(Section obj) {
        return sectionRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            sectionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Object not found");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("You cannot delete a section that contains indexed products");
        }
    }

    public void updateData(Section original, SectionDTO obj) {
        original.setName(obj.getName());
    }

    public Section update(Integer id, SectionDTO obj) {
        try {
            Section section = sectionRepository.getById(id);
            updateData(section, obj);
            return sectionRepository.save(section);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Object not found");
        }
    }

}
