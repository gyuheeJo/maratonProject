package com.example.maratonTeam.persistence;

import com.example.maratonTeam.domain.CompetenceDomain;
import com.example.maratonTeam.domain.CompetenceGet;
import com.example.maratonTeam.domain.CompetenceRegistered;
import com.example.maratonTeam.persistence.crud.CompetenceCrudRepository;
import com.example.maratonTeam.persistence.entity.Competence;
import com.example.maratonTeam.persistence.entity.TeamCompetence;
import com.example.maratonTeam.persistence.mapper.CompetenceCreateMapper;
import com.example.maratonTeam.persistence.mapper.CompetenceGetMapper;
import com.example.maratonTeam.persistence.mapper.CompetenceRegisteredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class CompetenceRepository {

    @Autowired
    private CompetenceCrudRepository competenceCrudRepository;

    @Autowired
    private CompetenceGetMapper mapper;

    @Autowired
    private CompetenceCreateMapper competenceCreateMapper;
    @Autowired
    private CompetenceRegisteredMapper competenceRegisteredMapper;

    public List<CompetenceGet> getAll(){
        List<CompetenceGet> competences = mapper.toCompetenceGets((List<Competence>) competenceCrudRepository.findAll());

        competences.forEach(competenceDomain -> competenceDomain.setName(
                competenceDomain.getDate().getYear()+""
                        + competenceDomain.getPeriod()
                        + competenceDomain.getCategory()));

        return competences;
    }

    public List<Integer> getAllValidityExpiredId(){
        return competenceCrudRepository.getAllValidityExpiredId();
    }
    public List<CompetenceRegistered> getAllRegistration(int idTeam){
        List<Competence> competences = competenceCrudRepository.getAllNotExpired();
        List<CompetenceRegistered> competenceRegistereds = competenceRegisteredMapper.toCompetenceRegistereds(competences);
        for (int i=0; i<competences.size(); i++){
            boolean registered = false;
            for (TeamCompetence teamCompetence : competences.get(i).getTeamCompetences()){
                if (teamCompetence.getId().getTeam() == idTeam){
                    registered = true;
                }
            }
            competenceRegistereds.get(i).setRegistered(registered);
        }
        competenceRegistereds.forEach(competence -> competence.setName(
                competence.getDate().getYear()+""
                        + competence.getPeriod()
                        + competence.getCategory()));
        return competenceRegistereds;
    }

    public Optional<CompetenceGet> getCompetence(int idCompetence){
        Optional<CompetenceGet> competence =  competenceCrudRepository.findById(idCompetence).map(competence1 -> mapper.toCompetenceGet(competence1));
        competence.ifPresent(competenceGet -> competenceGet.setName(
                competenceGet.getDate().getYear()+""
                        + competenceGet.getPeriod()
                        + competenceGet.getCategory()
        ));
        return competence;
    }

    public CompetenceDomain save(CompetenceDomain competenceDomain){
        return competenceCreateMapper.toCompetenceDomain(competenceCrudRepository.save(competenceCreateMapper.toCompetence(competenceDomain)));
    }

    public void delete(int idCompetence){
        competenceCrudRepository.deleteById(idCompetence);
    }
}
