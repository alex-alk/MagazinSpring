-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: baza
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `articles`
--

DROP TABLE IF EXISTS `articles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imageURL` varchar(100) NOT NULL,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `description` text NOT NULL,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articles`
--

LOCK TABLES `articles` WRITE;
/*!40000 ALTER TABLE `articles` DISABLE KEYS */;
INSERT INTO `articles` VALUES (20,'/resources/uploads/15.jpg','Aulonocara sp. Rubin Red',35,'<p>Aulonocara Rubin Red este un favorit datorita culorilor sale deosebite. Pestele afiseaza o nuanta portocalie luminoasa si un rosu puternic, ce intra in constrast ci marcajele albastre luminoase de pe fata, coada si aripioare. Atat pentru aspectul sau natural si formele de culoare dezvoltate, cat si pentru reproducerea in captivitate, acestia sunt unii dintre cei mai cautati pesti dupa ciclidele provenite din Lacul Malawi, Africa. Rubin Red Peacock este un peste care creste, se dezvolta si se reproduce cu lejeritate in captivitate. Ea are o coloratie rosiatica mai puternica decat in forma sa naturala pura.Acest soi a fost crescut si dezvoltat in mod intentionat pentru a i se intensifica nuanta rosiatica. Sunt ciclide mai pasnice si nu este recomandat sa le puneti in acelasi acvariu cu Mbunas, o specie extrem de activa si agresiva. Dimensiunea acestor pesti poate atinge 13 cm in lungime, iar acest lucru il ajuta sa se integreze usor intr-un acvariu de minimum 300 litri. Este recomandat sa-i oferiti un spatiu deschis pentru inot, dar si pesteri in care sa se poata ascunde sau odihni. Pentru o dezvoltare armonioasa, schimbati frecvent apa din acvariu, asa cum se procedeaza la toate ciclidele (50%).&nbsp;</p><p><strong>Caracteristici</strong>:&nbsp;</p><p><br></p><ul><li>Familie: ciclidele</li><li>Nume comune: Aulonocara sp. &quot;Ruby Red&quot;, Aulonocara Red Ruben</li><li>Dimensiuni: masculi 18 cm, femele 14 cm</li><li>Origine: Lacul Malawi. Aceasta specie a fost inventata in ultimii ani de germani sau cehia</li><li>Temperatura apei: de 25 &deg;C - 26 &deg;C sau 28 &deg;C pentru reproducere</li><li>pH-ul apei: 7.5-8.5 sau 8.0 pentru reproducere &nbsp;</li><li>Duritatea apei: 10 &deg;GH - 15 &deg;GH. 10 &deg;GH</li><li>Descrierea: masculii au culoarea predominanta albastru, restul culorilor variind de la portocaliu la rosu, uneori cu urme de albastruComportament: pesti teritoriali si pasnici. Exista lupta de concurenta intraspecifica. Este recomandat un mascul si 2-4 femele). Ei vor sapa un pic, mai ales in perioadele de reproduceriReproducerea: femela depune aproximativ 60 de oua pe un subtrat de stanca sau piatra. Femela va pazi ouale in gura aproximativ 21 de zile si apoi va scoate puieti intre 1 - 2 cm, destul de independenti</li></ul>','pesti'),(21,'/resources/uploads/1.jpg','Guppy',7,'<p><strong>Habitat</strong></p><p>&nbsp;</p><p>O specie incredibil de adaptabila care apare in aproape toate biotopurile imaginabile, de la fluvii de mare altitudine pana la mlastini tulburi si santuri.<br>Unele populatii exista, de asemenea, in conditii de apa salmastra.<br><br>Cu toate acestea, acestia tind sa se dezvolte cel mai bine in habitate cu cresteri luxuriante de alge, vegetatie marginala si/sau plante acvatice.</p><p>&nbsp;</p><p><strong>Intretinere</strong></p><p>&nbsp;</p><p>Nepretentiosi, desi un acvariu cu plante plutitoare este apreciat.Curentii puternici ar trebui evitati.<br>Acesta este un peste de apa dura si in timp ce poate trai in apa moale si/sau acida, intretinerea lui pe termen lung trebuie sa fie in apa moderata ca duritate sau dura.</p><p>&nbsp;</p><p><strong>Dieta</strong></p><p>&nbsp;</p><p>Pestii salbatici sunt in esenta insectivori, insa pestii inmultiti in acvarii din ziua de astazi sunt departe de stramosii lor si vor accepta majoritatea tipurilor de hrana oferite.</p><p>&nbsp;</p><p><strong>Comportament si compatibilitate</strong></p><p>&nbsp;</p><p>Un peste foarte liniÈtit. Nu trebuie tinuti cu specii de Barbus tigru, Serpae Tetra etc. Se simte bine intr-un acvariu comunitar linistit, cu alti vivipari, Rasbora, Corydoras si Tetra mici.</p><p>&nbsp;</p><p><strong>Dimorfism sexual</strong></p><p>&nbsp;</p><p>In salbaticie, masculii sunt intens colorati si au inotatoarea alungita, iar acest lucru este dus pana la extrem la exemplarele crescute in captivitate.<br>Masculii detin, de asemenea, un gonpodiu, care este o modificare a inotatoarei anale utilizata in reproducere si arata ca un bat in aparenta.<br><br>Femelele sunt mai mari, rotunjite si in general au o colorare mai putin atragatoare, desi soiurile reproduse in acvariu pot avea inotatoarea caudala de destul de intens colorata.</p><p>&nbsp;</p><p><strong>Reproducere</strong></p><p>&nbsp;</p><p>Se face foarte usor. Se recomanda pastrarea mai multor femele la fiecare mascul, deoarece masculii pot fi destul de energici in cautarea constanta a femelelor. Nu este nevoie de eforturi reale pentru a reproduce aceste pesti, desi un acvariu dens plantat cu o multitudine de vegetatie plutitoare este cel mai bun mod de a asigura supravietuirea puilor.<br><br>O femela gestanta poate fi identificata prin punctul/zona intunecata din spatele inotatoarei anale chiar in spatele burtii. Intre 5 si 100 de pui pot fi produsi de la o singura femela, iar gestatia dureaza intre 4-6 saptamani.<br><br>Excesul de sperma poate fi conservat timp de mult timp in oviductul femelei.<br>Aceasta inseamna ca femelele sunt inca capabile sa produca pui timp de 6 luni sau mai mult daca nu sunt prezenti masculi. Pestii adulti vor manca pe cei tineri, astfel incat este mai bine sa le eliminati dupa nasterea puiilor pentru a se asigura o supravietuire de 100%. Sunt incredibil de prolifici, asa ca daca nu doriti un acvariu plin de pui, cumparati pesti de un singur sex.</p>','pesti'),(22,'/resources/uploads/2.jpg','Xiphophorus helleri',9,'<p><strong>Habitat</strong></p><p>In natura se gasesc in diferite tipuri de habitat de la nivelul marii pana la o altitudine de aproximativ 1500 m, inclusiv in paraurile care curg rapid, pietroase, izvoare, santuri, iazuri si rauri care contin apa clara pana la cea tulbure. In cele mai multe cazuri, apa este mai mica de 1.5 m adancime si nu exista vegetatie acvatica.<br>In apele curgatoare, adultii au tendinta de a se aduna in zone cu un curent mai mare, in timp ce juvenilii manifesta o preferinta pentru zonele marginale linistite.</p><p><strong>Intretinere</strong></p><p>Alegerea decorului nu este atat de importanta, desi tinde sa prezinte o mai buna colorare atunci cand este tinut intr-un bine plantat si un substrat inchis la culoare.<br>Pentru varietatile salbatice ar trebui sa se amenajeze, de asemenea, unui acvariu care sa semene cu un flux curgator cu roci purtate de apa si bolovani mici.<br><br>Adaugarea unor plante plutitoare si radacini sau crengi pentru difuzarea luminii este de asemenea, apreciata si da o senzatie mai naturala.<br>Filtrarea nu trebuie sa fie deosebit de puternica, desi pare sa aprecieze un grad mai mare de miscare al apei.</p><p><strong>Dieta</strong></p><p>Analizele stomacale ale specimenelor salbatice au aratat ca sunt omnivori, se hranesc cu o gama larga de nevertebrate acvatice si terestre, detritus, alge si alte materiale vegetale.<br><br>In acvariu nu este pretentios si va accepta aproape orice i se ofera. Incercati totusi sa-i oferiti o dieta echilibrata cuprinzand produse uscate de buna calitate impreuna cu hrana vie si congelata de mici dimensiuni, cum ar fi larvele Daphnia, Artemia si chironomus (viermii de sange).</p><p><strong>Comportament si compatibilitate</strong></p><p>In spatiile mici, grupurile de masculi tind sa formeze ierarhii de dominare si pot investi o proportie semnificativa de timp mentinand pozitiile respective.</p><p><strong>Dimorfism sexual</strong></p><p>Masculii adulti tind sa fie mai mici decat femelele si poseda un gonopodiu proeminent, plus extensia caracteristica a lobului inferior caudal. In unele varietati ornamentale, lobul superior al inotatoarei caudale sau alte aripioare poate fi de asemenea extins, inclusiv la femele.</p><p><strong>Reproducere</strong></p><p>Ca si alti membrii vivipari ai familiei Poeciliidae, masculul Xiphophorus are un gonopodiu, in esenta inotattoare caudala, modificata, care este folosit pentru fertilizarea interna a femelelor.<br><br>Comportamentul reproductiv al Xiphophorus este bine studiat, iar femelele tind sa prefere numeroase trasaturi fizice si comportamentale, cum ar fi lungimea sabiei (lunga, scurta sau fara), temepratura de culoare, dimensiunea corpului, barajul vertical pe corp, indicatiile chimice si comportamente specifice reproducerii. In unele cazuri, femelele manifesta preferinte pentru trasaturile masculine ale altor specii. Comportamentul masculilor este conceput atat pentru a atrage femelele, cat si pentru a-si indeparta rivalii.<br>Femelele sunt, de asemenea, capabile sa stocheze sperma masculilor timp de mai multe luni.</p>','pesti'),(23,'/resources/uploads/4.jpg','Acvariu Eheim incpiria 200 LED Negru',7300,'<p><strong>Specificatii:</strong></p><ul><li>Capacitate: 200 litri</li><li>Iluminare: 2x20W (LED)</li><li>Dimensiuni: 70x55x140 cm</li></ul>','acv'),(24,'/resources/uploads/5.jpg','Barbus Tetrazona',9,'<p>Acesti pesti deosebiti sunt cunoscuti in tara noastra sub diverse nume (Tetrazone, Sumatrani, Sumi etc). Ei traiesc in salbaticie in Sumatra, Borneo Cambogia, precum si in alte parti ale Asiei, in rauri cu viteza moderata. La maturitate, acest peste atinge 7 cm lungime si 3 cm latime. Marimea acestora depinde si de volumul bazinului in care sunt crescuti (cei din bazine mici nu vor atinge aceasta marime). Se gasesc sub 4 variante de colorit: Tiger, Green, Pearl si Albino. </p>','pesti'),(25,'/resources/uploads/3.jpg','Molly',9,'<p><strong>Habitat</strong></p><p>In mod obisnuit, se gasesc in iazuri, mlastini, canale si santuri unde vegetatie este foarte densa. Este asociat cu habitatele salbatice in care algele sunt prezente in cantitati mari.<br>De asemenea se poate supravietuii in apa salmastra sau chiar sarata.</p><p><strong>Intretinere</strong></p><p>Este preferat un acvariu plantat dens, cu un spatiu deschis pentru inot. Trebuie remarcat faptul ca acestia sunt pesti foarte vegetarieni, astfel &icirc;ncat orice plante cu frunze subtiri/moi pot fi distruse. Permiterea unor alge verzi in bazin va insemna o hrana suplimentara pentru acest peste.<br>Aceasta specie trebuie tinuta in apa moderata sau chiar dura, cu un pH bazic. Atunci cand este tinut in apa moale sau acida, pestele slabeste destul de rapid, indicat frecvent ciuperci si/sau aripioare paralizate. Sarea nu este necesara,asa cum sunt mineralele &quot;dure&quot; (calciu, magneziu) fiind esentiale pentru pastrarea sanatatii pe termen lung a acestei specii.</p><p><strong>Dieta</strong></p><p>Pestii salbatici sunt aproape exclusiv erbivori, hranindu-se cu alge si cu alte plante. Pestii reprodusi in captivitate din ziua de azi s-au indepartat de stramosii lor si vor accepta aroape toate formele de hrana oferite, dar si unele vegetale, cum ar fi spanacul oparit sau fulgii de legume ar trebui sa fie incluse in dieta lor. Daca este nu i se asigura o cantitate suficienta de verdeta, este posibil ca inotatoarea dorsala sa nu se dezvolte armonios.</p><p><strong>Comportament si compatibilitate</strong></p><p>In general, o specie potrivita pentru un acvariu comunitar cu apa dura, desi poate fugarii pestii mai mici pe masura ce se maturizeaza. Masculii pot fi agresivi unii fata de ceilalti, in special atunci cand se reproduc. Pot fi tinuti cu alti vivipari si unele varietati de sanitar.</p><p><strong>Dimorfism sexual</strong></p><p>Masculii poseda un gonopodiu si o inotatoare dorsala mare, lunga, asemanatoare unei vele.</p><p><strong>Reproducere</strong></p><p>Reproducerea este usoara, asta bineinteles daca aveti cel putin o pereche fertila, iar raportul ideal dintre masculi si female este 1m/2f, datorita stresului pe care il provoaca masculul (femelei) care este tot timpul dornic de a se imperechea initializand actul sexul si fugarind femela prin tot acvariul. Zonele de plantare densa vor ajuta de asemenea.<br>Gestatia este putin mai lunga decat in cazul altor specii si tine aproximativ 2 luni, dupa care se pot produce pana la 50 de pui. Acestia sunt relativ mari si vor accepta nauplii de creveti, microviermi sau fulgi sub forma de pulbere inca de la nastere. Acvariul de reproducere ar trebui sa fie puternic plantat in cazul in care puii trebuie sa supravietuiasca parintilor care-i pot percepe ca si hrana. Cea mai buna metoda este de a scoate femelele gravide intr-un bazin separat pana cand acestea dau nastere. Interesant este faptul ca la pestii salbatici exista mai putin probabilitatea sa-si manance puii decat pestii reprodusi in captivitate.</p>','pesti'),(26,'/resources/uploads/32.jpg.png','Hrana vivipari Dennerle Guppy&Co',25,'<p>Hrana de baza pentru pestii vivipari. Daca nu stiati, 1 din 3 pesti vanduti este un vivipar. Aceasta hrana a fost creata special pentru popularii guppy, xipho, platy si molly, in concordanta cu dieta lor naturala. Proportia mare de ingrediente naturale, care va aplifica culoarea pestilor va duce la niste nuante deosebite la acesti pesti foarte pigmentati. Substanta beta-glucan este adaugata pentru a intari sistemul imunitar al viviparilor, impreuna cu substante prebiotice si probiotice care vor asigura ca pestii sunt bine protejati impotriva infectiilor bacteriiene non-specifice. Recomandare de hranire: de 2-3 ori cat pot sa manance intr-un minut, zilnic. </p>','hrana'),(27,'/resources/uploads/36.jpg.png','Hranitor automat Sera Feed A plus',119,'<p>Sera Feed A plus este un dispozitiv de hranire automata a pestilor, care se poate seta sa ofere pana la 6 hraniri pe zi. In functie de programare, Sera Feed A plus elibereaza in acvariu o cantitate prestabilita de hrana - cantitate reglabila de la 1 la 6 ori pe zi. Sera Feed A Plus este destitant hranirii continue, exacte si fiabile a tuturor pestilor de acvariu. Compartimentul alimentar al hranitorului automat este rotund si are o capacitate de aproximativ 80 ml de hrana. In timpul eliberarii, mancarea aluneca incet si uniform in acvariu. Hranitorul include o carcasa de protectie contra stropirii cu apa, pentru acoperirea optima a elementelor operationale, si un conector special cu furtun de aer cu care Sera Feed A plus poate fi conectat la pompa de aer pentru pastrarea mancarii uscate. </p>','accesorii'),(28,'/resources/uploads/8.jpg','Ancistrus Sp.',119,'<p>Ancistrus Sp. sunt pesti algivori, cu grad mediu de dificultate al reproducerii. Ei sunt usor de intretinut, fiind hraniti in principal cu alge, avand astfel un rol de peste sanitar. Ancistrus Sp. sunt pesti teritoriali si devin agresivi in perioada de reproducere, cand masculii ataca alti masculi. Uneori, ei pot rani si femela daca aceasta are dimensiuni mici. Cresterea lui se poate face in acvarii mici, de minimum 80 de litri. Este recomandat un mascul de Ancistrus la doua sau mai multe femele.</p><p><strong>Caracteristici:&nbsp;</strong></p><ul><li>Familie: Loricariidae</li><li>Subfamilia: Ancistrinae</li><li>Origine: America de Sud, bazinul amazonian, Rio Negro, Brazilia, Guiana</li><li>Marime: 14-15cm, in acvarii 8-13cm</li><li>Hrana: Omnivor si vegetarian</li><li>Intretinete: usoara</li><li>Reproducere: dificultate medie</li><li>Tip Bazin: lung, min. 80cm</li><li>Nivel inot: pesti de fund</li><li>Temperatura: 24-28 C&nbsp;</li><li>Duritate: 2 - 10 dGH PH: 5 - 7</li><li>Temperatura de reproducere: 23, maximum 24 C</li><li>Volum minim de apa: 80l</li></ul>','accesorii'),(29,'/resources/uploads/16.jpg','Aulonocara nyassae',32,'<ul><li>Forma de prezentare: 5 - 9 cm</li><li>Nu sunt agresivi, dar daca sunt tinuti in acvarii mici impreuna cu alte specii devin teritoriali.</li><li>Pot trai pana la 12 ani.</li><li>Prefera un habitat nisipos cu pietre.</li><li>Femelele se deosebesc foarte usor fiind de culoare maro-cenusiu.</li><li>Sunt recomandate 3-4 femele pentru un mascul.</li><li>Hrana: toate tipurile (creveti, fulgi).</li></ul>','pesti'),(30,'/resources/uploads/25.jpg','Barbus oligolepsis',6,'<ul><li>Barbus oligolepsis sunt pesti pasnici, originari din India si dinarhipelagul malaezian, care obisnuiesc sa traiasca in lacuri, rauri mici si chiar in bazine din gradini si parcuri publice. Are solzii relativ mari, cu marginile negre care lucesc in culorile curcubeului. Culoarea de baza a pestilor Barbus oligolepsis este verzuie - maro, avand inotatoarele de nuanta rosu - inchis. Barbus oligolepsis este un peste omnivor, hranindu-se cu crustacee si larve de chironomide.<br>Acest peste poate fi crescut cu usurinta atat de acvaristii cu experienta, cat si de acvaristii incepatori. Ei pot convietui in acvariu alaturi de specii ca Puntius tetrazona, Betta splendens, Hemmigramus caudovittatus, Calisa lalia, Trichogaster leeri si Hyphessobrycon flammeus.<br><strong>Caracteristici:&nbsp;</strong><ul><li>Originar: India</li><li>Duritatea apei: medie</li><li>Temperatura apei: 20-24&deg;C</li><li>Hrana: omnivor</li></ul></li></ul>','pesti'),(31,'/resources/uploads/24.jpg','Barbus oligolepsis',5,'<ul><li>Barb cires (Puntius titteya) este un peste tropical, ce apartine genului Barb reperat din familia Cyprinidae. Este originar din Sri Lanka si a fost numit Puntius titteya de Paules Edward Pieris Deraniyagala, in 1929. Sinonime includ Barbus titteya si Capoeta titteya. Specia este extrem de cautat pe piata acvarristilor si este in pericol de a fi supraexploatate pentru aceastÄ industrie. Este o specie cu corpul fusiform alungit, de maximum 5 cm lungime.<br>Masculii sunt mai puternic colorati decat femelele, dar sunt si mai slabi decat acestea. Pentru a le asigura un mediu prielnic, aveti nevoie de un acvariu lung, cu mediu intunecat, pentru a-i evidentia. Ei prefera o apa statuta, la o temperatura de 23-25 grade Celsius si locuri bine plantate, cu substrat din pietris marunt si nisip.<br><strong>Caracteristici:</strong><ul><li>Regnul: Animalia</li><li>IncrengÄtura: Chordata</li><li>Familie: Cyprinidae</li><li>Genul: Puntius</li><li>Specii: P. titteya</li><li>Lungime: 4 cm - 5 cm</li><li>Temperatura apei: 23 &ordm;C - 25 &ordm;C</li><li>pH-ul apei: 6 &ndash; 8</li><li>Duritatea apei: 5 &ndash; 19 dH</li></ul></li></ul>','pesti'),(32,'/resources/uploads/11.jpg','Betta Splendens Halfmoon M',35,'<ul><li>Betta Splendens este fara indoiala cel mai frumos si spectaculos reprezentant al familiei Anabantidae. Este un peste cu cerinte medii, putand fi crescut si in bazine de dimensiuni relativ mici. El are o varietate de forme si de culori, multe obtinute datorita acvaristilor pasionati, care au incercat diferite incrucisari. Este recomandat ca masculul sa fie insotit de 2-3 femele.&nbsp;<br><strong>Caracteristici:</strong>&nbsp;<p><br></p><ul><li>Habitat:Asia</li><li>Familie:Osphronemidae</li><li>Dificultate: foarte usoara</li><li>Dimensiune specie: 5.1-7.6cm</li><li>Capacitate acvariu: minimum 18.9 Litri</li><li>Apa: dulce</li><li>pH-ul apei: 6.0 - 7.8</li><li>Temperatura apei: 23.9-27.8&deg;C</li><li>Duritatea apei: 4-10 &deg;d</li><li>Dieta: carnivor, fulgi, granule, hrana vie</li><li>Durata de viata: 2-7 ani</li></ul></li></ul>','pesti'),(33,'/resources/uploads/12.jpg','Colisa lalia',20,'<ul><li>Colisa Lalia este un peste deloc pretentios, care poate fi crescut in acvarii bine plantat si cu schimburi de apa regulate, recomandate o data pe saptamana. Ell poate fi hranit cu o varietate foarte mare de alimente, prefer&acirc;nd &icirc;nsa hrana de origine animala, precum purici de balta (Daphnia Pulex), tubi (Tubifex Rivularum), artemia (Artemia Salina), larve de chironomus sau &nbsp;cu hrana uscata, precum fulgi, pelete, mixturi. I se poate da si carne de vita, dar rasa bine, sau tocatura din ficat si inima de vita/pasare.&nbsp;<br><strong>Caracteristici:</strong>&nbsp;<p><br></p><ul><li>Habitat: AsiaFamilie: Osphronemidae</li><li>Dificultate: usoara</li><li>Capacitate acvariu: minimum 57 Litri</li><li>Dimensiunea speciei: 5.1-6.4 cm</li><li>Apa: dulcepH-ul apei: 6.5 - 7.5</li><li>Temperatura apei: 22-27 &deg;C</li><li>Duritatea apei: 4-13 &deg;d</li><li>Dieta: fulgi, granule, hrana vie&nbsp;</li></ul></li></ul>','pesti'),(34,'/resources/uploads/10.jpg','Corydoras elegans',16,'<ul><li>Corydoras elegans sunt pesti pasnici, care pot fi crescuti cu usurinta in acvarii comunitare, alaturi de characide mici, cyprinide, anabantoide si cichlide pitice. Au nevoie de un acvariu cu apa curata, care necesita schimbari dese si partiale de apa, cu un substrat nisipos sau din pietris fin. Ei pot fi hraniti cu alimente care se scufunda, intrucat obisnuiesc sa manance la baza acvariului. In dieta lor pot intra Artemia, larve de Chironomidae, Tubifex, Daphnia sau rame tocate. Caracteristici: Habitat: America de Sud Familie: Callichthyidae Durata de viata: 3-5 ani Dificultate:Moderata Capacitate acvariu: minimum 57 Litri Dimensiunea speciei: 5 - 6 cm Apa: dulce pH-ul apei: 6.0 - 7.4 Temperatura apei: 22.2-25&deg;C Duritatea apei:1-15 &deg;d Raspandire: neobisnuita Dieta: omnivor, hrana vie, granule, fulgi&nbsp;</li></ul>','pesti'),(35,'/resources/uploads/28a.jpg','Discus royal blue',54,'<ul><li>Discus royal blue - Symphysodon aequifasciatus haraldi este un peste pasnic, ce poate fi crescut usor intr-un acvariu destinat acestei specii. Cu toate acestea, poate convietui alaturi de alte specii, fiind compatibil cu Tetra Cardinal, Corydoras, Tetra Neon si Ottos. Inaltimea acvariului trebuie sa fie de cel putin 50 de centimetri, iar in amenajarea lui trebuie luate in considerare plasarea unor radacini, lemne si a unei vegetatii dense, pestele avand nevoie de multe zone de ascunzis. De asemenea, trebuie sa existe si spatiile deschise pentru inot. Pestii Discus royal blue sunt foarte sensibili la nitrati. Ca hrana, sunt recomandate alimentele uscate. </li></ul>','pesti');
/*!40000 ALTER TABLE `articles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `family_name` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `tel` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'awdaw','awd','awd','awd','awda,awda'),(2,'aaa','bbb','ddd','ccc','eee,fff'),(3,'n','p','e','t','p'),(4,'aa','aa','aa','aa','aa'),(5,'aaa','aaa','bb','bb','bb'),(6,'sdsa','safds','sefse','dgd','thf'),(7,'kyufk','assf','dfgh','fgj','vf'),(8,'ad','gdf','sf','gfhs','asd'),(9,'sa','rg','awd','awda','rfre'),(10,'GD','GH','sdf','DF','ghg'),(11,'GD','GH','sdf','DF','ghg'),(12,'GD','GH','sdf','DF','ghg'),(13,'GD','GH','sdf','DF','ghg'),(14,'jhk','ghdf','fdhf','sdf','hgj'),(15,'jhk','ghdf','fdhf','sdf','hgj'),(16,'jhk','ghdf','fdhf','sdf','hgj');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offers`
--

DROP TABLE IF EXISTS `offers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offers`
--

LOCK TABLES `offers` WRITE;
/*!40000 ALTER TABLE `offers` DISABLE KEYS */;
INSERT INTO `offers` VALUES (28,'/resources/offers/o1.png'),(29,'/resources/offers/o2.png');
/*!40000 ALTER TABLE `offers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `articles_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`client_id`,`articles_id`),
  KEY `fk_comenzi_clienti_idx` (`client_id`),
  KEY `fk_comenzi_articol1_idx` (`articles_id`),
  CONSTRAINT `fk_comenzi_articles` FOREIGN KEY (`articles_id`) REFERENCES `articles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comenzi_clients` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (24,5,3,20),(25,10,3,24),(26,2,3,23),(29,4,3,21);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-24 13:37:56
