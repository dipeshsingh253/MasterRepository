package com.example.repository.tableperclass;


import com.example.model.tableperclass.Spell;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface SpellRepository extends CrudRepository<Spell,Long> {



}
