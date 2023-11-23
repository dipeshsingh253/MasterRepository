package com.example;

import com.example.model.joined.Archer;
import com.example.model.joined.Infantry;
import com.example.model.joined.InfantryType;
import com.example.model.joined.Knight;
import com.example.model.singletable.*;
import com.example.model.tableperclass.FireSpell;
import com.example.model.tableperclass.FrostSpell;
import com.example.model.tableperclass.Spell;
import com.example.repository.joined.ArcherRepository;
import com.example.repository.joined.InfantryRepository;
import com.example.repository.joined.KnightRepository;
import com.example.repository.singletable.ArtPieceRepository;
import com.example.repository.singletable.PaintingRepository;
import com.example.repository.singletable.SculptureRepository;
import com.example.repository.tableperclass.FireSpellRepository;
import com.example.repository.tableperclass.FrostSpellRepository;
import com.example.repository.tableperclass.SpellRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HibernateInheritanceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(HibernateInheritanceApplication.class, args);
	// Single Table //
//		ArtPieceRepository paintingRepo = appContext.getBean(PaintingRepository.class);
//		ArtPieceRepository sculptureRepo = appContext.getBean(SculptureRepository.class);
//
//		ArtPiece sculpture = new Sculpture("Dipesh", Material.ROCK,15.5);
//		ArtPiece painting = new Painting("Shivay", PaintingStyle.OIL,12.00,7.9);
//
//		sculptureRepo.save(sculpture);
//		paintingRepo.save(painting);

		// Joined Table //
//		InfantryRepository archerRepository = appContext.getBean(ArcherRepository.class);
//		InfantryRepository knightRepository = appContext.getBean(KnightRepository.class);
//
//		Infantry archer = new Archer(InfantryType.HARD,12,52,8,5);
//		Infantry knight = new Knight(InfantryType.MEDIUM,4,108,45,true);
//
//		archerRepository.save(archer);
//		knightRepository.save(knight);


		// Table per Class //

		SpellRepository spellRepository = appContext.getBean(SpellRepository.class);
		FireSpellRepository fireSpellRepository = appContext.getBean(FireSpellRepository.class);
		FrostSpellRepository frostSpellRepository = appContext.getBean(FrostSpellRepository.class);

		Spell arcaneSpark = new Spell("Arcane Spark",45,120);
		Spell fireBall = new FireSpell("Fireball",100,150,7,20);
		Spell meteorShower = new FrostSpell("Meteor Shower",80,160,true,15);

		spellRepository.save(arcaneSpark);
		fireSpellRepository.save(fireBall);
		frostSpellRepository.save(meteorShower);

	}

}
