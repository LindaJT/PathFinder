# Käyttöohje

### Ohjelman suorittaminen 

Projektin voi ladata GitHubista zip-tiedostona. Ohjelmaa suoritetaan ajamalla komento **`./gradlew run`** PathFinder-kansiossa. Ohjelma avautuu uuteen ikkunaan. Browse files-painikkeesta voi valita ajettavan karttatiedoston. Projektissa on valmiina PathFinder-kansiossa karttatiedostoja, kuten berlin.txt, maze.txt ja test2.txt. Mikäli valittu tiedosto on oikean tyyppinen, *File added* teksti ilmestyy. Muussa tapauksessa *File not found or not readable* teksti ilmestyy ja tulisi valita toinen tiedosto. 

Tiedoston onnistuneen lisäämisen jälkeen, x start, y start, x end ja y end kenttiin kirjataan halutut lähtö- ja loppukoordinaatit. Heuristiikkafunktiona on oletuksena diagonaalinen etäisyys, mutta sen voi halutessaan muuttaa uniform cost tai euclidean etäisyyteen. 

A- ja IDA-painikkeista ohjelma etsii lyhyimmän reitin valitulla algoritmilla annetuista lähtökoordinaateista loppukoordinaatteihin, mikäli sellainen löytyy. Mikäli reitti löytyy, painikkeiden alle tulee löydetyn reitin pituus, sekä reitin löytymiseen kulunut aika. Mikäli alku- tai loppupiste on ei-kuljetteva ruutu, etäisyydeksi tulee -1 ja alle teksti *Path not found*.

### Syötteet

Ohjelma hyväksyy syötteeksi txt-muotoisia tiedostoja, jotka koostuvat .- ja @-merkeistä. Muita merkkejä ei saa olla. Karttoja saa esim. [Moving AI Labs-sivustolta](https://www.movingai.com/benchmarks/street/index.html), mutta map-tiedosto tulee tallentaa .txt-muotoon, sekä poistaa tiedoston neljä ensimmäistä riviä (varsinainen kartta alkaa näiden jälkeen).

### Testit

Testit voi suorittaa ajamalla komennon **`./gradlew test`** PathFinder-kansiossa. Testit käyttävät karttatiedostoja testFiles-kansiosta. 
