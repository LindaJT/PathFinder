# Toteutusdokumentti

## Ohjelman yleisrakenne

### Yleistä

Ohjelmassa voi etsiä lyhyimmän reitin kartalla kahden pisteen välille kahdella eri algoritmilla, A-starilla ja IDA-starilla. Ohjelmaa käytetään käyttöliittymän kautta.

### A-star

A-starille annetaan konstruktorissa käytettävä kartta kaksiulotteisena taulukkona, sekä aloituskoordinaatit. findPathTo-metodia kutsumalla se etsii lyhyimmän reitin parametreina annettuihin xy-koordinaatteihin. Kartan ruudut tallennetaan node-olioina binääripuuhun, missä jokaisen solmun noden f-arvo on pienempi tai yhtäsuuri kuin lapsisolmujen nodejen f-arvot. 

Vaaka- tai pystysuunnassa liikkumisen kulu on 1 ja diagonaalissa liikkumisen \sqrt{2} . 

### IDA-star

IDA-star saa myös konstruktorissa kartan kaksiulotteisena taulukkona ja aloituskoordinaatit ja findPathTo-metodille annetaan parametrina loppukoordinaatit. Alussa kynnysarvona on arvioitu etäisyys aloituspisteestä maalipisteeseen. Jokaisella iteraatiolla toteutetaan syvyyshaku ja jätetään pois polut, joiden f-arvo (g+h) ylittää annetun kynnysarvon. Kullakin iteraatiolla seuraavaan iteraatioon käytettävä kynnysarvo on kaikkien nykyisen kynnysarvon ylittäneiden arvojen vähimmäiskustannus (f).

Iteraatioissa sen hetkisen noden naapurit lisätään NeighborsList-tietorakenteeseen addNeighborsToOpenList-metodissa.

Vaaka- tai pystysuunnassa liikkumisen kulu on 1 ja diagonaalissa liikkumisen \sqrt{2} .

### Tiedostojen käsittely

Ohjelma hyväksyy syötteeksi txt-muotoisia tiedostoja. Tiedostot luetaan kaksiulotteiseksi int-taulukoksi. Kartan ympärille lisätään seinä, jolloin seuraavien siirtojen selvittäminen algoritmeja suorittaessa helpottuu. Tiedostojen lukemisesta ja taulukoksi muuttamisesta vastaa FileReader-luokka. 

Testausta ja verifiointia varten kuljettu reitti ja vieraillut ruudut kirjoitetaan tiedostoon reitinhakualgoritmin suorituksen jälkeen. Tiedostoon kirjoittamisesta vastaa PathWriter-luokka.

## Suorituskykytestaus

Suorituskykyä testataan Moving AI Labin Berliinin kartalla vertailemalla A-starin ja IDA-starin suoritusnopeuksia eri syötteillä. Syötteet ovat Moving AI Labin skenaarioista. Testataan myös, vaikuttaako valittu heuristiikkafunktio suoristusnopeuteen.

## Puutteet ja parannusehdotukset

IDA-starin toteutus tuotti runsaasti haasteita. Se löytää lyhyimmän reitin melko tehokkaasti pienillä kartoilla, tai kartoilla/alueilla, missä on paljon seiniä. Mikäli kartta on suuri tai siinä on paljon tyhjää, IDA-starista tulee todella hidas. Tämä johtuu käsittääkseni siitä, että se vierailee samoissa ruuduissa useaan kertaan, koska vierailtuja ruutuja ei tallenneta mihinkään, kuten A-starissa. Olen mielestäni toteuttanut IDA-starin pseudo-koodin mukaisesti, mutta en ole keksinyt, miten saisin sen nopeammaksi. Tämä on suurin ohjelman suurin puute.

Muita parannusehdotuksia olisi käyttöliittymän ja visualisoinnin helpottaminen niin, että käyttöliittymässä näkyisi kuva valitusta kartasta, sekä löydetty reitti halutun algoritmin suorituksen jälkeen. Tämä jäi toteuttamatta ajan puutteesta johtuen. 

Lähteet:

http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html

https://algorithmsinsight.wordpress.com/graph-theory-2/ida-star-algorithm-in-general/

https://ai.stackexchange.com/questions/8821/how-is-iterative-deepening-a-better-than-a

https://en.wikipedia.org/wiki/A***_search_algorithm#Complexity

https://en.m.wikipedia.org/wiki/Iterative_deepening_A***

https://medium.com/@nicholas.w.swift/easy-a-star-pathfinding-7e6689c7f7b2

https://www.growingwiththeweb.com/2012/06/a-pathfinding-algorithm.html


