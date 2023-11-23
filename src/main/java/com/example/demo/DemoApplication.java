package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.domain.entities.Autor;
import com.example.demo.domain.entities.Comic;
import com.example.demo.infraestructure.autorRepository;
import com.example.demo.infraestructure.comicRepository;
//Cuarta modificación 
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	private autorRepository autorRepository;

	@Autowired
	private comicRepository comicRepository;

	
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("/**").allowedMethods("*").allowedHeaders("*");
			}
		};
	}
	
	@Override
	public void run(String... args) throws Exception {
		//Vamos a crear autores
	/*
		Autor a1 = new Autor();
		a1.setNombre("Emily Johnson");
		a1.setEditorial("DC Comics");

		Autor a2 = new Autor();
		a2.setNombre("David Lee");
		a2.setEditorial("Image Comics");

		Autor a3 = new Autor();
		a3.setNombre("Sarah Miller");
		a3.setEditorial("Dark Horse Comics");

		Autor a4 = new Autor();
		a4.setNombre("Michael Wilson");
		a4.setEditorial("IDW Publishing");

		Autor a5 = new Autor();
		a5.setNombre("Laura Davis");
		a5.setEditorial("Vertigo");

		Autor a6 = new Autor();
		a6.setNombre("Robert Martin");
		a6.setEditorial("Boom! Studios");

		Autor a7 = new Autor();
		a7.setNombre("Jennifer Clark");
		a7.setEditorial("Valiant Comics");

		Autor a8 = new Autor();
		a8.setNombre("Daniel White");
		a8.setEditorial("Top Cow Productions");

		Autor a9 = new Autor();
		a9.setNombre("Susan Taylor");
		a9.setEditorial("Archie Comics");

		autorRepository.save(a1);		
		autorRepository.save(a2);
		autorRepository.save(a3);
		autorRepository.save(a4);
		autorRepository.save(a5);
		autorRepository.save(a6);
		autorRepository.save(a7);
		autorRepository.save(a8);
		autorRepository.save(a9);

		//Autores creados

		//Creamos comics

		Comic c1 = new Comic();
		c1.setAutor(a1);
		c1.setEstado("En stock");
		c1.setDislikes(3);
		c1.setNombre("SPY x FAMILY");
		c1.setFecha_de_publicación("03-01-2021");
		c1.setLikes(10);
		c1.setPrecio(30);
		List<String> l1= new ArrayList<>();
		l1.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/095217fdb4f228410df09b18f151be28.jpe");
		c1.setImagenes_description(l1);
		c1.setDescripcion("En una era en la que las naciones de todo el mundo se encuentran involucradas en una feroz guerra de información a puerta cerrada, Ostania y Westalis llevan décadas en guerra fría.	La División de Inteligencia de Westalis (WISE) envía a su mejor espía, 'Twilight', en una misión ultrasecreta para vigilar los movimientos de Donovan Desmond");
		Set<String> generosC1 = new HashSet<>();
		generosC1.add("Comedia");
		generosC1.add("Drama");
		generosC1.add("Shounen");
		c1.setGeneros(generosC1);
		c1.setAutor(a1);
		List<Temporada> temporadasC1 = new ArrayList<>();
		temporadasC1.add(new Temporada("SPY x FAMILY Temporada 1", "La División de Inteligencia de Westalis (WISE) envía a su mejor espía, \"Twilight\", en una misión ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige el Partido Nacional por la Unidad de Ostania, responsable de bombardear los esfuerzos de paz entre ambos países.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/095217fdb4f228410df09b18f151be28.jpe"));
        c1.setTemporadas(temporadasC1);
		comicRepository.save(c1);
		



		Comic c2 = new Comic();
		c2.setAutor(a2);
		c2.setEstado("En stock");
		c2.setDislikes(3);
		c2.setNombre("Dr. STONE");
		c2.setFecha_de_publicación("04-01-2022");
		c2.setLikes(19);
		c2.setPrecio(30);
		List<String> l2= new ArrayList<>();
		l2.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/29e0d306dbff3a163acadf66a35b3cf5.jpe");
		c2.setImagenes_description(l2);
		c2.setDescripcion("Senku es un joven extremadamente inteligente con un gran don para la ciencia y una ácida personalidad, y su mejor amigo es Taiju, que es muy buena persona pero más apto para usar los músculos que para pensar. Cuando tras cierto incidente toda la humanidad acaba convertida en piedra, ellos logran despertarse en un mundo miles de años después, con la civilización humana completamente desaparecida y con toda la humanidad congelada en piedra como ellos estuvieron. Ahora es su obligación rescatar a la gente y crear un nuevo mundo.");
		Set<String> generosC2 = new HashSet<>();
		generosC2.add("Acción");
		generosC2.add("Drama");
		generosC2.add("Comedia");
		generosC2.add("Aventura");
		c2.setGeneros(generosC2);
		c2.setAutor(a2);
		List<Temporada> temporadasC2 = new ArrayList<>();
		temporadasC2.add(new Temporada("Dr. STONE", "La División de Inteligencia de Westalis (WISE) envía a su mejor espía, \"Twilight\", en una misión ultrasecreta para vigilar los movimientos de Donovan Desmond, quien dirige el Partido Nacional por la Unidad de Ostania, responsable de bombardear los esfuerzos de paz entre ambos países.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/095217fdb4f228410df09b18f151be28.jpe"));
		temporadasC2.add(new Temporada("Dr. STONE NEW WORLD", "Cuando tras cierto incidente toda la humanidad acaba convertida en piedra, ellos logran despertarse en un mundo miles de años después, con la civilización humana completamente desaparecida y con toda la humanidad congelada en piedra como ellos estuvieron. Ahora es su obligación rescatar a la gente y crear un nuevo mundo.", "https://cdn.glitch.global/97c36b09-137a-4142-98ae-1dd55a53e5ad/f3accca2b543e1d3b7b9533ca55d2119.jpe?v=1700695589481"));
		c2.setTemporadas(temporadasC2);
		comicRepository.save(c2);

		Comic c3 = new Comic();
		c3.setAutor(a3);
		c3.setEstado("En stock");
		c3.setDislikes(3);
		c3.setNombre("Frieren: Más allá del final del viaje");
		c3.setFecha_de_publicación("04-12-2023");
		c3.setLikes(34);
		c3.setPrecio(30);
		List<String> l3= new ArrayList<>();
		l3.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/f446d7a2a155c6120742978fb528fb82.jpe");
		c3.setImagenes_description(l3);
		c3.setDescripcion("La maga Frieren formaba parte del grupo del héroe Himmel, quienes derrotaron al Rey Demonio tras un viaje de 10 años y devolvieron la paz al reino. Frieren es una elfa de más de mil años de vida, así que al despedirse de Himmel y sus compañeros promete que regresará para verlos y parte de viaje sola. Al cabo de cincuenta años, Frieren cumple su promesa y acude a visitar a Himmel y al resto. Aunque ella no ha cambiado, Himmel y los demás han envejecido y están en el final de sus vidas.");
		Set<String> generosC3 = new HashSet<>();
		generosC3.add("Fantasia");
		generosC3.add("Drama");
		generosC3.add("Aventura");
		c3.setGeneros(generosC3);
		c3.setAutor(a3);
		List<Temporada> temporadasC3 = new ArrayList<>();
		temporadasC3.add(new Temporada("Frieren: Más allá del final del viaje", "La maga Frieren formaba parte del grupo del héroe Himmel, quienes derrotaron al Rey Demonio tras un viaje de 10 años y devolvieron la paz al reino. Frieren es una elfa de más de mil años de vida, así que al despedirse de Himmel y sus compañeros promete que regresará para verlos y parte de viaje sola.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/f446d7a2a155c6120742978fb528fb82.jpe"));
		c3.setTemporadas(temporadasC3);
		comicRepository.save(c3);

		Comic c4 = new Comic();
		c4.setAutor(a4);
		c4.setEstado("En stock");
		c4.setDislikes(11);
		c4.setNombre("The Rising of the Shield Hero");
		c4.setFecha_de_publicación("04-12-2023");
		c4.setLikes(18);
		c4.setPrecio(30);
		List<String> l4= new ArrayList<>();
		l4.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/e5d61ac62e1ccf624e1d7507ec1758bb.jpe");
		c4.setImagenes_description(l4);
		c4.setDescripcion("Iwatani Naofumi es el típico otaku, al menos hasta que un día encuentra en la biblioteca un libro que lo transporta a otro mundo. Allí se convertirá en el Héroe del Escudo, uno de los Cuatro Héroes Cardinales, y tendrá que luchar contra las Olas de la Catástrofe junto a los héroes de la espada, la lanza y el arco.");
		Set<String> generosC4 = new HashSet<>();
		generosC4.add("Acción");
		generosC4.add("Drama");
		generosC4.add("Aventura");
		generosC4.add("Seinen");
		c4.setGeneros(generosC4);
		c4.setAutor(a4);
		List<Temporada> temporadasC4 = new ArrayList<>();
		temporadasC4.add(new Temporada("The Rising of the Shield Hero", "Emocionado ante la perspectiva de vivir una gran aventura, Naofumi parte de viaje con su grupo. No obstante, al cabo de unos pocos días lo traicionan y pierde su dinero, su dignidad y el respeto de los que le rodean.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/e5d61ac62e1ccf624e1d7507ec1758bb.jpe"));
		c4.setTemporadas(temporadasC4);
		comicRepository.save(c4);

		Comic c5 = new Comic();
		c5.setAutor(a5);
		c5.setEstado("En stock");
		c5.setDislikes(1);
		c5.setNombre("GOBLIN SLAYER");
		c5.setFecha_de_publicación("09-02-2020");
		c5.setLikes(28);
		c5.setPrecio(30);
		List<String> l5= new ArrayList<>();
		l5.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/8cf56e51a982975b0987534985fa67c7.jpe");
		c5.setImagenes_description(l5);
		c5.setDescripcion("Una joven sacerdotisa ha formado su primer grupo de aventureros, pero no tardan mucho en verse en serios problemas. Por suerte, quien aparece en su rescate es el Asesino de Goblins, un hombre que ha dedicado su vida a exterminar a todo goblin viviente por los medios que fueran necesarios. Cuando comienzan a circular rumores sobre sus hazañas, no hay forma de saber quién será el próximo en aparecer.");
		Set<String> generosC5 = new HashSet<>();
		generosC5.add("Acción");
		generosC5.add("Aventura");
		generosC5.add("Fantasía");
		c5.setGeneros(generosC5);
		c5.setAutor(a5);
		List<Temporada> temporadasC5 = new ArrayList<>();
		temporadasC5.add(new Temporada("GOBLIN SLAYER", "Una joven sacerdotisa ha formado su primer grupo de aventureros, pero no tardan mucho en verse en serios problemas. Por suerte, quien aparece en su rescate es el Asesino de Goblins, un hombre que ha dedicado su vida a exterminar a todo goblin viviente por los medios que fueran necesarios. Cuando comienzan a circular rumores sobre sus hazañas, no hay forma de saber quién será el próximo en aparecer.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/8cf56e51a982975b0987534985fa67c7.jpe"));
		c5.setTemporadas(temporadasC5);
		comicRepository.save(c5);

		Comic c6 = new Comic();
		c6.setAutor(a6);
		c6.setEstado("En stock");
		c6.setDislikes(8);
		c6.setNombre("The Ancient Magus' Bride");
		c6.setFecha_de_publicación("11-02-2021");
		c6.setLikes(23);
		c6.setPrecio(30);
		List<String> l6= new ArrayList<>();
		l6.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/cf20e7a1792149f9655c52c4fa7e2b18.jpe");
		c6.setImagenes_description(l6);
		c6.setDescripcion("Se muda y comienza a vivir una nueva vida pacífica, tranquila pero firme, hasta que un día encuentra un libro ilustrado japonés entre los muchos que le envía Angelica desde Londres. Es un libro que ella descubrió en sus años jóvenes, cuando todavía estaba sola y desamparada.");
		Set<String> generosC6 = new HashSet<>();
		generosC6.add("Acción");
		generosC6.add("Romance");
		generosC6.add("Sobrenatural");
		c6.setGeneros(generosC6);
		c6.setAutor(a6);
		List<Temporada> temporadasC6 = new ArrayList<>();
		temporadasC6.add(new Temporada("The Ancient Magus' Bride", "Perdida, sin esperanza y sin familia, la compran por dinero. Pero quien la compra no es otra persona, sino un hechicero no humano llamado Elias. Aunque al inicio duda, la joven comenzará una nueva vida como su aprendiz y futura esposa.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/cf20e7a1792149f9655c52c4fa7e2b18.jpe"));
		c6.setTemporadas(temporadasC6);
		comicRepository.save(c6);

		Comic c7 = new Comic();
		c7.setAutor(a7);
		c7.setEstado("En stock");
		c7.setDislikes(8);
		c7.setNombre("The Ancient Magus' Bride");
		c7.setFecha_de_publicación("11-02-2021");
		c7.setLikes(23);
		c7.setPrecio(30);
		List<String> l7= new ArrayList<>();
		l7.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/cf20e7a1792149f9655c52c4fa7e2b18.jpe");
		c7.setImagenes_description(l7);
		c7.setDescripcion("Se muda y comienza a vivir una nueva vida pacífica, tranquila pero firme, hasta que un día encuentra un libro ilustrado japonés entre los muchos que le envía Angelica desde Londres. Es un libro que ella descubrió en sus años jóvenes, cuando todavía estaba sola y desamparada.");
		Set<String> generosC7 = new HashSet<>();
		generosC7.add("Acción");
		generosC7.add("Romance");
		generosC7.add("Sobrenatural");
		c7.setGeneros(generosC7);
		c7.setAutor(a7);
		List<Temporada> temporadasC7 = new ArrayList<>();
		temporadasC7.add(new Temporada("The Ancient Magus' Bride", "Perdida, sin esperanza y sin familia, la compran por dinero. Pero quien la compra no es otra persona, sino un hechicero no humano llamado Elias. Aunque al inicio duda, la joven comenzará una nueva vida como su aprendiz y futura esposa.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/cf20e7a1792149f9655c52c4fa7e2b18.jpe"));
		c7.setTemporadas(temporadasC7);
		comicRepository.save(c7);

		Comic c8 = new Comic();
		c8.setAutor(a8);
		c8.setEstado("En stock");
		c8.setDislikes(18);
		c8.setNombre("Shangri-La Frontier");
		c8.setFecha_de_publicación("17-04-2019");
		c8.setLikes(43);
		c8.setPrecio(20);
		List<String> l8= new ArrayList<>();
		l8.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/a2f948157077e3d65471329d9dd43be1.jpe");
		c8.setImagenes_description(l8);
		c8.setDescripcion("\"¿Cuándo fue la última vez que jugué un juego que no fuera una basura?\" Este es un mundo en el futuro cercano donde los juegos que usan pantallas se consideran retro, y muchos juegos de realidad virtual no llegan a un mínimo de calidad: son los llamados \"juegos basura\". A aquellos que dedican sus vidas a completar estos juegos se les llama \"cazadores de juegos basura\", y Rakuro Hizutome es uno de ellos. El juego que ha elegido abordar a continuación es Shangri-La Frontier, un juego que goza de una gran crítica y más de 30 millones de jugadores. ¡La mejor historia de aventuras escrita por el jugador más fuerte de \"juegos basura\" está a punto de comenzar!");
		Set<String> generosC8 = new HashSet<>();
		generosC8.add("Acción");
		generosC8.add("Aventura");
		generosC8.add("Ciencia Ficcion");
		c8.setGeneros(generosC8);
		c8.setAutor(a8);
		List<Temporada> temporadasC8 = new ArrayList<>();
		temporadasC8.add(new Temporada("Shangri-La Frontier", "El juego que ha elegido abordar a continuación es Shangri-La Frontier, un juego que goza de una gran crítica y más de 30 millones de jugadores. ¡La mejor historia de aventuras escrita por el jugador más fuerte de \"juegos basura\" está a punto de comenzar!", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/a2f948157077e3d65471329d9dd43be1.jpe"));
		c8.setTemporadas(temporadasC8);
		comicRepository.save(c8);

		Comic c9 = new Comic();
		c9.setAutor(a9);
		c9.setEstado("En stock");
		c9.setDislikes(2);
		c9.setNombre("The Faraway Paladin");
		c9.setFecha_de_publicación("11-04-2023");
		c9.setLikes(33);
		c9.setPrecio(20);
		List<String> l9= new ArrayList<>();
		l9.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/3b166f7f535823589980641210b88e69.jpe");
		c9.setImagenes_description(l9);
		c9.setDescripcion("En las ruinas de la ciudad de los muertos, muy lejos de la civilización humana, vive un único niño humano llamado Will. Al niño lo han criado tres no muertos: Blood el herorico guerrero esqueleto, la sacerdotisa momia Mary y el mago fantasma Gus. Los tres enseñan al niño todo lo que saben y lo colman de amor.");
		Set<String> generosC9 = new HashSet<>();
		generosC9.add("Acción");
		generosC9.add("Aventura");
		generosC9.add("Ciencia Ficcion");
		c9.setGeneros(generosC9);
		c9.setAutor(a9);
		List<Temporada> temporadasC9 = new ArrayList<>();
		temporadasC9.add(new Temporada("The Faraway Paladin", "En las ruinas de la ciudad de los muertos, muy lejos de la civilización humana, vive un único niño humano llamado Will. Al niño lo han criado tres no muertos: Blood el herorico guerrero esqueleto, la sacerdotisa momia Mary y el mago fantasma Gus. Los tres enseñan al niño todo lo que saben y lo colman de amor.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/3b166f7f535823589980641210b88e69.jpe"));
		c9.setTemporadas(temporadasC9);
		comicRepository.save(c9);

		Comic c10 = new Comic();
		c10.setAutor(a2);
		c10.setEstado("En stock");
		c10.setDislikes(2);
		c10.setNombre("JUJUTSU KAISEN");
		c10.setFecha_de_publicación("11-04-2022");
		c10.setLikes(63);
		c10.setPrecio(20);
		List<String> l10= new ArrayList<>();
		l10.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/ebcd65fa9fb83580062e7052fa6ee5a5.jpe");
		c10.setImagenes_description(l10);
		c10.setDescripcion("En las ruinas de la ciudad de los muertos, muy lejos de la civilización humana, vive un único niño humano llamado Will. Al niño lo han criado tres no muertos: Blood el herorico guerrero esqueleto, la sacerdotisa momia Mary y el mago fantasma Gus. Los tres enseñan al niño todo lo que saben y lo colman de amor.");
		Set<String> generosC10 = new HashSet<>();
		generosC9.add("Acción");
		generosC9.add("Shounen");
		generosC9.add("Sobre natural");
		c10.setGeneros(generosC10);
		c10.setAutor(a2);
		List<Temporada> temporadasC10 = new ArrayList<>();
		temporadasC10.add(new Temporada("JUJUTSU KAISEN", "Dificultades, arrepentimiento, vergüenza… Los sentimientos negativos de los humanos se convierten en Maldiciones que nos acechan en nuestra vida diaria. Las Maldiciones campan a sus anchas por todo el mundo, y pueden llevar a las personas a sufrir terribles desgracias e incluso dirigirlas a su muerte. Y lo que es peor: solo una Maldición puede exorcizar otra Maldición.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/ebcd65fa9fb83580062e7052fa6ee5a5.jpe"));
		c10.setTemporadas(temporadasC10);
		comicRepository.save(c10);

		Comic c11 = new Comic();
		c11.setAutor(a2);
		c11.setEstado("En stock");
		c11.setDislikes(2);
		c11.setNombre("Butareba");
		c11.setFecha_de_publicación("11-04-2012");
		c11.setLikes(43);
		c11.setPrecio(20);
		List<String> l11= new ArrayList<>();
		l11.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/480cc3050dd4e8c442eb567680000f52.jpe");
		c11.setImagenes_description(l1);
		c11.setDescripcion("Cuando un hombre corriente se desmaya por comer hígado de cerdo crudo y se despierta... ¡descubre que se ha convertido en un cerdo! Está atrapado hasta que la dulce y hermosa Jess lo rescata, quien casualmente puede leer mentes. Pese a que el cerdo tiene pensamientos muy groseros, lo acepta y tiene planes de cuidarlo con mucho amor. Pero Jess tiene sus secretos y corre peligro. ¿Podrá su nuevo amigo gorrino salvarla usando su olfato y su ingenio?");
		Set<String> generosC11 = new HashSet<>();
		generosC11.add("Acción");
		generosC11.add("Shounen");
		generosC11.add("Sobre natural");
		c11.setGeneros(generosC11);
		c11.setAutor(a2);
		List<Temporada> temporadasC11 = new ArrayList<>();
		temporadasC11.add(new Temporada("Butareba", "Cuando un hombre corriente se desmaya por comer hígado de cerdo crudo y se despierta... ¡descubre que se ha convertido en un cerdo! Está atrapado hasta que la dulce y hermosa Jess lo rescata, quien casualmente puede leer mentes. Pese a que el cerdo tiene pensamientos muy groseros, lo acepta y tiene planes de cuidarlo con mucho amor. Pero Jess tiene sus secretos y corre peligro. ¿Podrá su nuevo amigo gorrino salvarla usando su olfato y su ingenio?", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/480cc3050dd4e8c442eb567680000f52.jpe"));
		temporadasC11.add(new Temporada("The Story of a Man Turned into a Pig", "Cuando un hombre corriente se desmaya por comer hígado de cerdo crudo y se despierta... ¡descubre que se ha convertido en un cerdo! Está atrapado hasta que la dulce y hermosa Jess lo rescata, quien casualmente puede leer mentes. Pese a que el cerdo tiene pensamientos muy groseros, lo acepta y tiene planes de cuidarlo con mucho amor. Pero Jess tiene sus secretos y corre peligro. ¿Podrá su nuevo amigo gorrino salvarla usando su olfato y su ingenio?", "https://cdn.glitch.global/97c36b09-137a-4142-98ae-1dd55a53e5ad/a9fdec21792193da1c522366b7d93909.jpe?v=1700714380176"));
		c11.setTemporadas(temporadasC11);
		comicRepository.save(c11);

		Comic c12 = new Comic();
		c12.setAutor(a3);
		c12.setEstado("En stock");
		c12.setDislikes(22);
		c12.setNombre("One Piece");
		c12.setFecha_de_publicación("01-04-2023");
		c12.setLikes(53);
		c12.setPrecio(20);
		List<String> l12= new ArrayList<>();
		l12.add("https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/f154230aab3191aba977f337d392f812.jpe");
		c12.setImagenes_description(l1);
		c12.setDescripcion("Monkey D. Luffy se niega a que nadie se interponga en su camino para convertirse en Rey de los Piratas. Se lanza a surcar los mares y se convertirá en un capitán dispuesto a no darse por vencido jamás hasta hacerse con el mayor tesoro de la historia: el legendario One Piece.");
		Set<String> generosC12 = new HashSet<>();
		generosC12.add("Acción");
		generosC12.add("Shounen");
		generosC12.add("Aventura");
		generosC12.add("Fantasia");
		c12.setGeneros(generosC12);
		c12.setAutor(a3);
		List<Temporada> temporadasC12 = new ArrayList<>();
		temporadasC12.add(new Temporada("One Piece", "Monkey D. Luffy se niega a que nadie se interponga en su camino para convertirse en Rey de los Piratas. Se lanza a surcar los mares y se convertirá en un capitán dispuesto a no darse por vencido jamás hasta hacerse con el mayor tesoro de la historia: el legendario One Piece.", "https://www.crunchyroll.com/imgsrv/display/thumbnail/480x720/catalog/crunchyroll/f154230aab3191aba977f337d392f812.jpe"));
		c12.setTemporadas(temporadasC12);
		comicRepository.save(c12);
	*/
	}

}