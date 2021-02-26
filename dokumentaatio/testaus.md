# Testausdokumentti

Luokille on tehty yksikkötestit JUnitilla (poislukien käyttöliittymästä vastaava UI-luokka).

Testikattavuutta seurataan Jacocolla. Testikattavuusraportti paketittain:

![Paketit](kaikki_kansiot.png)

pathFinder-paketti:

![pathFinder](pathFinder.png)

util-paketti:

![util](util.png)

algorithms-paketti:

![algorithms](algorithms.png)

Ohjelman toimintaa voi testata käyttöliittymän kautta. Käyttöliittymä kertoo kummallekin algoritmille löytyikö reitti, reitin pituuden sekä reitin etsintään kuluneen ajan. Löytynyttä reittiä sekä algoritmin vierailemia ruutuja voi tarkastella results-kansion pathAStar.txt ja pathIDA.txt tiedostoista. Käyttöliittymässä voi myös valita, mitä heuristiikkafunktiota algoritmi käyttää (uniform cost diagonal distance, diagonal distance vai Euclidean distance) ja funktion vaikutusta suoritusaikaan voi verrata.

Karttojen tulkitsiminen:

@	este

.	kulkukelpoinen

'#' 	reitti

'*'	vierailtu ruutu

Suorituskykytestauksessa testataan reitin löytymiseen kulunutta aikaa kahdella eri algritmilla, A starilla ja IDA starilla. Testauksessa tulen vertaamaan myös, vaikuttaako suoritusaikaan valittu heuristiikkafunktio. Testaamiseen käytetään Moving AI Labin Berliinin karttaa, sekä siihen tehtyjä valmiita skenaarioita.
