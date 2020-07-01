package com.example.sportmagazine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.sportmagazine.repository.local.NoticiaRepository;

import java.util.ArrayList;
import java.util.List;

public class ListaNoticias extends AppCompatActivity {
    private NoticiaRepository noticiaRepository;
    private CustomAdapter adapter;
    private List<Noticia> items = new ArrayList<>();
    Button add;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        noticiaRepository=new NoticiaRepository(getApplication());
        setContentView(R.layout.activity_listanoticias);
        add = (Button)findViewById(R.id.add);
        noticiaRepository.getAll().observe(this, new Observer<List<Noticia>>() {
            @Override
            public void onChanged(final List<Noticia> noticias) {
                items = noticias;
                System.out.println(items.get(1).getTitulo());
                list = findViewById(R.id.lista);
                CustomAdapter arrayAdapter=new CustomAdapter(getApplicationContext(),noticias);
                list.setAdapter(arrayAdapter);


                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //System.out.println(items.get(i).getTitulo());
                        Noticia task = items.get(i);
                        System.out.println(task.getTitulo());
                        Intent detailsIntent = new Intent(getApplicationContext(), MostrarNoticia.class);
                        detailsIntent.putExtra("id", task.getId());
                        startActivity(detailsIntent);
                       /* Intent activity2Intent = new Intent(getApplicationContext(), MostrarNoticia.class);
                        activity2Intent.putExtra("ID_EXTRA1", noticias.get(i).getPortada());
                        activity2Intent.putExtra("ID_EXTRA2", noticias.get(i).getTitulo());
                        activity2Intent .putExtra("ID_EXTRA3", noticias.get(i).getTexto());
                        activity2Intent .putExtra("ID_EXTRA4", noticias.get(i).isRead());
                        startActivity(activity2Intent);*/
                    }
                });
            }
        });

        addNewas();





     //   final ArrayList<Noticia> arrayList = new ArrayList<Noticia>();
          //  CustomAdapter arrayAdapter=new CustomAdapter(this,arrayList);

//assign adapter to listview
       // list.setAdapter(arrayAdapter);

      /*  list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent activity2Intent = new Intent(getApplicationContext(), MostrarNoticia.class);
                activity2Intent.putExtra("ID_EXTRA1", arrayList.get(i).getPortada());
                activity2Intent.putExtra("ID_EXTRA2", arrayList.get(i).getTitulo());
                activity2Intent .putExtra("ID_EXTRA3", arrayList.get(i).getTexto());
                startActivity(activity2Intent);
            }
        });
*/
        add.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        noticiaRepository.deleteAll();

                    }
                });

    }

    public void addNewas(){
        Noticia no1=new Noticia("Con goles de Cristiano y Dybala, Juventus venció al Bologna y se afirmó como líder de la Serie A", R.drawable.cristiano, "La Juventus se recuperó este lunes de la derrota ante Napoli en la final de la Copa Italia y venció por 2 a 0 al Bologna en el suelo correspondiente a la jornada 27 de la Serie A. Cristiano Ronaldo y Paulo Dybala fueron los autores de los tantos del equipo que sobre el final sufrió la expulsión de Danilo.",false);
        Noticia no2=new Noticia("MotoGP: Canceladas las dos primeras carreras del Mundial en Catar y Tailandia por el coronavirus", R.drawable.noti2," Se siguen cancelando eventos debido al miedo a la propagación del coronavirus y el último ha sido el mundial de motociclismo. Dorna ha decidido suspender la carrera de la máxima categoría, aunque las de Moto2 y Moto3 podrían disputarse debido a que los pilotos ya están en el circuito. La segunda prueba en Tailandia también ha sido suspendida unas horas después.",false);
        Noticia no3=new Noticia("Nakamura remonta en la ‘muerte súbita’ y fuerza la 3ª manga con Ding, que se juega este lunes", R.drawable.nakamura, "Hikaru Nakamura, uno de los gladiadores más fieros del circo del ajedrez, ha ganado al borde del abismo al chino Liren Ding (4-3) la 2ª manga de cuartos de final del torneo rápido Chessable Masters; este lunes se jugará la 3ª y definitiva, cuyo vencedor se medirá con Magnus Carlsen. El otro duelo de la jornada siguió siendo aburrido hasta que el neerlandés Anish Giri, en el día de su 26º cumpleaños, exhibió por fin su gran talento y eliminó (3-1) al ruso Alexánder Grischuk. Su rival en semifinales desde el martes será otro ruso, Ian Niepómniachi.",false);
        Noticia no4=new Noticia("Nueva polémica en el tenis: tras anunciar que se aislaría por el coronavirus, se filtró un video de Alexander Zverev en una fiesta", R.drawable.alexander, "El alemán había estado presente en el torneo que organizó Novak Djokovic y que provocó que varias personas se contagien con el Covid-19. Pese a dar negativo, el número 7 del ranking ATP había anunciado que se pondría en cuarentena",false);
        Noticia no5=new Noticia("El portero Alfredo Talavera, en la mira de Pumas de la UNAM", R.drawable.alfredo, "La organización de los Pumas de la UNAM expresó su interés por el portero Alfredo Talavera, y sería en los próximos días que el equipo realizaría la propuesta económica. Cabe señalar que el club universitario busca a un guardameta para el torneo Apertura 2020. Otra opción de la que se habló fue del uruguayo Martín Campaña, negociación que se complicó por una cláusula en la que Pumas debía comprar al jugador después de un año de préstamo.",false);
        Noticia no6=new Noticia("Los 8 brutales golpes a la cabeza que conformaron el KO más impactante de la velada de UFC en Las Vegas", R.drawable.ko, "No fue una velada de grandes nocauts. Pocas peleas terminaron por la vía rápida. Sin embargo, la adrenalina que generaron los protagonistas del combate estelar que tuvo UFC en Las Vegas sirvió para que se libere la dopamina que habitualmente se descarga en el octágono. El triunfo de Dustin Poirier sobre Dan Hooker significó una verdadera batalla. Si bien el pleito no pudo resolverse a través de la vía rápida, las tarjetas de los jueces (48-47, 48-47 y 48-46) arrojaron una decisión unánime para que el Diamante se imponga en uno de los choques más atractivos que se observó desde que la actividad regresó en medio de la pandemia de coronavirus.",false);
        Noticia no7=new Noticia("Con una genialidad de Benzema, el Real Madrid superó al Espanyol y es el único líder de La Liga", R.drawable.real, "El Real Madrid cumplió con las expectativas y se subió a la cima de la tabla de posiciones este domingo tras ganarle al Espanyol de Barcelona por 1 a 0 en Cataluña con gol de Casemiro. El Barcelona empató el sábado ante el Celta de Vigo y quedó segundo.  Los primeros minutos sorprendieron al elenco visitante, porque el equipo catalán le generó bastante peligro. La estrategia del local fue simple: le entregó la pelota al rival y apostó por el contragolpe, plan que habitualmente suele utilizar equipo de Zinedine Zidane. Fue así que la mala suerte y dos buenas atajadas de Thibaut Courtois, evitaron que el líder arranque en desventaja.",false);
        Noticia no8=new Noticia("La feroz provocación del boxeador argentino candidato a pelear con Mike Tyson: “Me tuvo miedo por 32 años”", R.drawable.mike, "A pocos días de cumplir 54 años, Mike Tyson continúa con la preparación física para su vuelta al boxeo. A 15 años de la última pelea oficial, derrota ante Kevin McBride en 2005, Iron Mike difundió varias imágenes de sus entrenamientos ensayando golpes y en un estado físico envidiable. Aunque todavía no confirmó quién o quiénes serán sus oponentes para su ansiado retorno al ring, la leyenda estadounidense fue desafiado por un el campeón argentino Walter Masseroni. Con una dura historia, el Bombardero de Beccar persigue el sueño de enfrentarlo por más de tres décadas. Semanas atrás, Masseroni en diálogo con Infobae contó que estuvo tres veces cerca de pelear con Tyson pero que por diversas cuestiones extradeportivas los combates no llegaron a realizarse. Al conocer la intención de Iron Mike de volver, Walter comenzó con una dura preparación para poder llevar a cabo esa pelea tantas veces frustradas.",false);
        Noticia no9=new Noticia("Lance Armstrong, la historia del rey deportivo de la mentira: de formar un imperio en el ciclismo y superar un cáncer a perder todo a manos del dóping", R.drawable.lance, "Lance Edward Gunderson nació en la ciudad de Plano, al norte de Dallas, Texas, el 18 de septiembre de 1971 pero su padre los abandonó a él -”nunca supe nada de él ni me interesa”- y a su madre. Linda Armstrong Kelly lo tuvo a los 17 años -”crecimos juntos. A mis 5 años, ella tenía 22, a mis 15, ella tenía 32″- y tras conocer a Terry Armstrong y casarse con él, éste lo adoptó cuando tenía tres años. Le su apellido, aunque la segunda pareja de su madre ejerció violencia contra él. Lance Armstrong lo describe como “terrible y estricto”, que le daba palizas con una raqueta por motivos como dejar abierto un cajón. Terry, exageradamente ordenado, venía de haber estado cinco años en una escuela militar y que admitió en un documental que emitió ESPN que “nunca lo abracé ni le dije que lo quería. No le demostré cariño pero lo trataba como un animal en el sentido de ganar a toda costa y si fue campeón después, mucho fue por mí”. Su madre se separó de él cuando tenía 15 años.",false);
        Noticia no10=new Noticia("Coronavirus en México: los aficionados solo regresarán a los estadios con un protocolo", R.drawable.mexico, "El titular de la Dirección General de Promoción de la Salud del Gobierno mexicano, el doctor Ricardo Cortés, aseguró a Efe este sábado que para que los aficionados regresen a los estadios del deporte profesional en el país bajo el contexto de la COVID-19, cada inmueble deberá diseñar un protocolo. Cortés es quien ha coordinado el regreso a la actividad de distintos deportes en México; en el fútbol, fue encargado por el gobierno para revisar el protocolo de regreso a los entrenamientos y partidos a puertas cerradas.",false);
        Noticia no11=new Noticia("La selección argentina, en estado de alerta: México quiere tentar a Luka Romero, el “nuevo Messi”", R.drawable.seleccion, "Luka Romero acaba de hacer historia al ser el debutante más joven en La Liga (ingresó en la derrota del Mallorca ante Real Madrid con sólo 15 años) y tres países comenzaron una carrera para “ficharlo”. Para simplificar su caso: nació en México, vive en España y su padre es argentina. El joven atacante es hijo del ex mediocampista de Quilmes y Atlético de Rafaela Diego Romero. A raíz de la profesión de su padre, nació en México mientras él se desempeñaba en los Alacranes de Durango en 2004, pero vivió unos pocos meses en tierras aztecas. Tras el paso de su padre por el fútbol ecuatoriano, vivió toda su vida en España. La Selección que más rápido se movió fue la de Argentina. Tras conocer su caso, decidió convocarlo para jugar el Sudamericano Sub-15. Luka aceptó el llamado y por el momento es parte de la estructura de la Albiceleste, siendo seguido de cerca actualmente por Pablo Aimar para la Sub-17.",false);
        Noticia no12=new Noticia("La increíble historia del playboy que ganó en la Fórmula 1, lo quiso Ferrari y su muerte la predijo una vidente", R.drawable.f1, "En sus siete décadas la Fórmula 1 tuvo muchas historias. Dentro y fuera de la pista. Personajes únicos. Uno de ellos fue François Cevert que mezcló lo deportivo, el particular glamour de la Máxima en los años setenta y lo sobrenatural. Apenas tardó cuatro temporadas para debutar en el automovilismo y llegar a la categoría más importante. El francés reunió un carisma especial y transmitió muy buena energía en quienes lo rodearon. Aunque hubo otros que no lo conocieron de forma personal, pero supieron mucho de él, como aquella vidente que filtró los momentos claves en su vida, incluso su fallecimiento. El peligro y adrenalina se transmitieron en su sangre. Su padre, Charles Goldenberg, fue un emigrante ruso que se escapó de la persecución de los judíos. En París se puso una joyería y en la Segunda Guerra Mundial se unió a la resistencia en la ocupación nazi. Para resguardar a sus hijos les puso el apellido de su mujer, Huguette Cevert. El 25 de febrero de 1944 vino al mundo François que se crió en un entorno acomodado en lo económico y estudió piano por doce años. Sin embargo su futuro estuvo en otro lugar y no tecleó a la hora de decidirse. Un día Charles echó de su casa a François, cansado de verlo llegar sucio luego de sus carreras en motos en las que arrancó a sus 16 años y corría con una Vespa de su madre. Su padre tal vez vio en su yerno un camino que quiso evitar para su hijo mayor. Jacqueline Cevert fue la esposa del recordado Jean-Pierre Beltoise, quien ya era un conocido piloto y en poco tiempo también accedió a la F-1. Su cuñado lo influyó y fue determinante para que ambos fuesen colegas.",false);
        Noticia no13=new Noticia("El drástico cambio físico de Fernando Alonso en la cuarentena que causó furor en las redes sociales", R.drawable.cambio, "A muchas personas les ha sucedido que la cuarentena por el coronavirus los ha motivado a hacer más ejercicio para aprovechar el tiempo libre y el encierro, pero pocas han logrado lo que consiguió el español Fernando Alonso, ex piloto de Ferrari en la Fórmula 1, quien ha revolucionado las redes sociales al mostrarse mucho más delgado de lo habitual. El ex bicampeón mundial de F1 (2005, 2006) ha compartido una foto en su cuenta de Instagram que dejó boquiabiertos a sus seguidores. “Descubriendo nuevos senderos”, escribió el español, quien dejó la categoría reina en 2018. Aparentemente, mientras espera que se reanuden las competiciones de motor y define su futuro, el piloto asturiano de 38 años está cuidando su físico al máximo. Esta notable delgadez no ha pasado desapercibida en los fanáticos, quien han llenado la publicación con comentarios al respecto. “Que flaco estas Fernando”, “Te estás quedando en el chasis Fer!!”, “¿Cuántos días llevas sin comer?” y “Estás fino” fueron algunas de las respuestas que recibió.",false);
        Noticia no14=new Noticia("Las “burbujas” que utilizará la Fórmula 1 para combatir al coronavirus en su regreso a la actividad", R.drawable.burbujas, "La Fórmula 1 reiniciará sus actividades el primer fin de semana de julio tras convivir con postergaciones y suspensiones de las competiciones que estaban pautadas para el arranque oficial del calendario en marzo. La pandemia del coronavirus obligó a reorganizar toda la grilla de competencias y también a repensar los métodos de trabajo. Entre el 3 y el 5 de julio próximo, pondrán en prueba el formato de las “burbujas” como forma de prevención del contagio. Así definió al esquema de trabajo que pondrán en práctica el director deportivo de Ferrari Laurent Mekies en una entrevista con varios periodistas de manera virtual. “Toda la F1 será una burbuja, iremos con certificados de aptitud de nuestros doctores y un test PCR realizado cuatro días antes de viajar, y cada cinco días todos seremos testados en el circuito otra vez; temperatura al llegar, mascarilla en todas las situaciones necesaria”, señaló el líder de una de las escuderías más simbólicas según replicó el diario español As.",false);
        Noticia no15=new Noticia("El pasado lo condena: la frase de una figura que es pretendida por el FC Barcelona y podría comprometer su futuro", R.drawable.pasado, "El trueque entre el FC Barcelona y la Juventus por Arthur Melo y Miralem Pjanic entra en su recta decisiva, ante la necesidad de cerrar las cuentas a 30 de junio, después de un ejercicio económico nefasto por las consecuencias del coronavirus. En ese contexto y con los fichajes casi cerrados, salió a la luz una polémica declaración del bosnio mientras militaba en las filas de la Roma que muchos fanáticos azulgrana están cuestionando por estos tiempos. Según diferentes fuentes, la operación puede desencallarse próximamente, después de que Arthur, que en un principio era reacio a aceptar el traspaso, puede beneficiarse de la operación, debido a las condiciones fiscales que le ofrecen en Italia y que le podrían suponer triplicar sus ingresos.",false);
        Noticia no16=new Noticia("Efecto coronavirus: la estrella de la NBA que se retiró tras 22 años de carrera", R.drawable.nba, "El escolta de 43 años Vince Carter anunció este jueves su retiro del baloncesto después de haber jugado 22 temporadas en la NBA en ocho equipos diferentes.  Carter, el primer jugador de la NBA que jugó partidos en cuatro décadas diferentes, anunció su retiro en el pódcast ‘Winging It With Vince Carter’ de The Ringer: “Oficialmente, termino de jugar baloncesto profesionalmente”, dijo. Hace dos temporadas, cuando firmó con los Hawks de Atlanta, había dicho que la de 2019-2020 sería la última de su carrera, pero luego aceptó seguir una más con ese equipo, que se ha quedado fuera de la lucha por estar en los ‘playoffs’ cuando el próximo 30 de julio se reanude la liga.",false);
        Noticia no17=new Noticia("El Leeds United de Bielsa triunfó, festejó con sus hinchas de cartón y acaricia el ascenso a la Premier", R.drawable.leeds, "El Leeds United hizo los deberes y derrotó 3-0 al Fulham por la fecha 39 de la Championship. A falta de siete jornadas para el desenlace del campeonato, lidera la tabla con tres unidades de ventaja sobre el segundo (West Bromwich) y a ocho del Brentford, tercero (los primeros dos ascienden directamente y del tercero al sexto competirán por el tercer ascenso en los playoffs). A los 10 minutos de partido abrió el tanteador con una buena maniobra colectiva definida por Patrick Bamford, su goleador. Sin embargo con el correr de los minutos el conjunto visitante se hizo dominador del juego y tuvo algunas ocasiones para igualar. Tan flojo fue el rendimiento de los Blancos en los minutos finales de la primera mitad que Marcelo Bielsa ensayó dos cambios en el entretiempo. Y surtieron efecto. Ezgjan Alioski, uno de los ingresados, anotó el 2-0 a favor de los del Loco en Elland Road. Y más tarde el español Pablo Hernández, quien retornó después de una lesión y fue la segunda variante del entretiempo, asistió a Jack Harrison para el 3-0 definitivo. Sobre el cierre fue expulsado por doble amarilla en Fulham el congoleño Neeskens Kebano.",false);
        Noticia no18=new Noticia("La dura revelación del médico que salvó al ex Fórmula 1 Zanardi en la ruta: “Sólo podía durar unos minutos”", R.drawable.zenardi, "El viernes pasado el mundo del automovilismo y del ciclismo paraolímpico se conmocionó debido al accidente que tuvo Alex Zanardi arriba de su bicicleta de mano en una ruta de la provincia de Siena, cuando impactó de frente contra un camión mientras participaba de la Obiettivo Tricolor, una carrera de ciclismo adaptado que recorre Italia de norte a sur y cuya meta estaba en la localidad de Montalcino. Fue así que mientras el ex piloto de Fórmula 1 y ganador de cuatro medallas de oro paralímpicas en ciclismo (dos en Londres 2012 y dos en Río 2016) yace internado en el hospital Santa Maria alle Scotte luchando por su vida, uno de los médicos que participó del rescate hizo fuertes declaraciones del estado en el que lo habían encontrado al deportista de 53 años. Robusto Biagioni, personal de urgencias y jefe del área de Grosseto, dio detalles de cómo fue su accionar en el salvamento de Zanardi arriba del Pegasus 2, el helicóptero que utilizaron. “Éramos seis a bordo: dos pilotos, un técnico, un operador de rescate alpino, una enfermera y yo. Aterrizamos en Pienza a las 17.20 en un campo y tuvimos que cruzar un bosque pequeño, muy denso. El operador de Alpine Rescue nos guió rompiendo las ramas en nuestro camino y encontrando la dirección correcta. No tardamos más de cuatro o cinco minutos, como máximo. Zanardi estaba al borde de la carretera supina. Afortunadamente, el médico de la ambulancia lo estaba ayudando y ya había comenzado a hacer lo necesario en esas condiciones para estabilizarlo”, expresó en una entrevista con el medio Corriere della Sera.",false);
        Noticia no19=new Noticia("Polémica en la UFC: un luchador le suplicó a su entrenador que tirara la toalla en nueve ocasiones y él se negó", R.drawable.ufc, "Días después de que se llevara a cabo el evento UFC Vegas 3, en el UFC APEX de Nevada, comenzó a circular un impactante video en el que se pudo ver como el luchador de 25 años Max Rohskopf le pedía desesperadamente a su entrenador Robert Drysdale que arroje la toalla al término del segundo round. Fueron hasta en nueve ocasiones las que el peleador le suplicó que lo haga, obteniendo como respuesta que debía continuar. Su rival Austin Hubbard había comenzado muy bien el combate y castigó al oriundo de Ohio durante los dos primeros asaltos. El primer enfrentamiento de las preliminares de dicha velada ya había comenzado con polémicas antes de que ambos ingresaran a la jaula, ya que Rohskopf tuvo sólo cinco días para prepararse mental y físicamente para lo que fue su debut en la UFC. “Detenla”, fue el pedido que le hizo el estadounidense a su entrenador desde su esquina en reiteradas ocasiones. Haciendo oídos sordos a las palabras de Rohskopf, Drysdale intentó motivarlo con sus palabras una y otra vez: “Tenemos esto”, “Puedes vencer a este chico” y “Haremos esto”, fueron las frases con las que contrarrestó a las de su pupilo.",false);
        Noticia no20=new Noticia("“El que debe pedir perdón es Djokovic, los demás no mataron a nadie”: el representante de Thiem explotó tras la ola de contagios", R.drawable.pedir, "Lo que se organizó como un torneo de exhibición para que los fanáticos del tenis pudieran volver a ver a varias de las máximas estrellas del circuito profesional de tenis masculino terminó en un escándalo internacional que generó polémicas y que provocó que varios de los protagonistas fueran diagnosticados como positivos de coronavirus. El Adria Tour, un torneo a beneficio que iba a recorrer canchas de Serbia, Croacia, Montenegro y Bosnia-Herzegovina en plena pandemia, se transformó en el epicentro de la ola de contagios para el tenis mundial con su organizador, Novak Djokovic, como el principal apuntado por el formato de juego sin distanciamiento social y la participación en fiestas privadas que se hicieron públicas y mostraron que los deportistas no tomaron las precauciones necesarias en medio de la crisis epidemiológica que atraviesa el mundo. En las últimas horas, y tras la confirmación que tanto Nole como su esposa, los tenistas Borna Coric y Viktor Troicki; los entrenadores Marco Panichi y Cristian Groh; y hasta la estrella de la NBA Nikola Jokic, están infectados con el virus COVID-19, el que se pronunció en contra de lo sucedido fue el mánager de Dominic Thiem, actual número 3 del mundo y que ganó el torneo que se jugó en Belgrado, capital serbia, fue muy crítico contra Djokovic por su forma de actuar.",false);
        noticiaRepository.insert(no1);
        noticiaRepository.insert(no2);
        noticiaRepository.insert(no3);
        noticiaRepository.insert(no4);
        noticiaRepository.insert(no5);
        noticiaRepository.insert(no6);
        noticiaRepository.insert(no7);
        noticiaRepository.insert(no8);
        noticiaRepository.insert(no9);
        noticiaRepository.insert(no10);
        noticiaRepository.insert(no11);
        noticiaRepository.insert(no12);
        noticiaRepository.insert(no13);
        noticiaRepository.insert(no14);
        noticiaRepository.insert(no15);
        noticiaRepository.insert(no16);
        noticiaRepository.insert(no17);
        noticiaRepository.insert(no18);
        noticiaRepository.insert(no19);
        noticiaRepository.insert(no20);
    }
}
